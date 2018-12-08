package freedomphones.checkoutsvc.cart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item{
    private String prod_id;
    private Integer qty;

    @JsonCreator
    public Item(@JsonProperty("prod_id") String prod_id, @JsonProperty("qty") Integer qty){
        this.prod_id = prod_id;
        this.qty = qty;
    }
    public String getProduct(){
        return this.prod_id;
    }
    public void setProduct(String prod_id){
        this.prod_id = prod_id;
    }
    public Integer getQuantity(){
        return this.qty;
    }
    public void setQuantity(Integer qty){
        this.qty = qty;
    }
}