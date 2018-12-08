package freedomphones.checkoutsvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import freedomphones.checkoutsvc.cart.Cart;
import freedomphones.checkoutsvc.cart.Item;

@Repository
public class ItemGetter{
    public Cart getCart(String username){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/cart-service/getCart/{username}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        return restTemplate.getForObject(uri, Cart.class, params);
    }
    public Stock getStock(){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/phone-service/getStock";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Stock.class);
    }
    public Boolean hasFunds(String username, String total){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/user-service/hasFunds/{username}/{total}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("total", total);
        return restTemplate.getForObject(uri, Boolean.class, params);
    }
    public String removeFunds(String username, String total){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/user-service/removeFunds/{username}/{total}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("total", total);
        return restTemplate.getForObject(uri, String.class, params);
    }
    public void removeQuantities(HashMap<String, Item> items){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/phone-service/removeQuantities";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(uri, items, String.class);
    }
    public void clearCart(String username){
        final String uri = "https://freedomphones-zuul-svc.herokuapp.com/cart-service/clearCart/{username}";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        restTemplate.getForObject(uri, String.class, params);
    }
}