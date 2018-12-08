package freedomphones.checkoutsvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import freedomphones.checkoutsvc.cart.Cart;
import freedomphones.checkoutsvc.cart.Item;

@RestController
public class CheckoutController{
    @Autowired
    ItemGetter itemGetter;

    @GetMapping(value = "/checkout/{username}")
    public ErrorList checkout(@PathVariable String username){
        ErrorList errors = new ErrorList();
        Cart usercart = itemGetter.getCart(username);
        Stock stock = itemGetter.getStock();
        HashMap<String, ItemInfo> stockInfo = stock.getStock();
        HashMap<String, Item> items = usercart.getItems();
        List<String> low_stock = Collections.<String>emptyList();
        Double total = 0.0;
        Boolean quantityError = false;
        for(Map.Entry<String, Item> entry: items.entrySet()) {
            Item item = entry.getValue();
            ItemInfo iteminfo = stockInfo.get(entry.getKey());
            if(item.getQuantity() > iteminfo.getIn_stock()){
                quantityError = true;
                low_stock.add(entry.getKey());
            }
            total += (item.getQuantity() * iteminfo.getPrice());
        }
        Boolean hasFunds = itemGetter.hasFunds(username, total.toString());
        if(!hasFunds){
            errors.addError("You do not have enough funds to make this purchase");
        }
        if(quantityError){
            errors.addError("Not enough stock for " + String.join(", ", low_stock));
        }
        if(errors.isEmpty()){
            itemGetter.removeFunds(username, total.toString());
            itemGetter.removeQuantities(usercart.getItems());
            itemGetter.clearCart(username);
        }
        return errors;
    }
}