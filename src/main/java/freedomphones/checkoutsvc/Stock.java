package freedomphones.checkoutsvc;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock {
    HashMap<String, ItemInfo> stock;

    @JsonCreator
    public Stock(@JsonProperty("stock") HashMap<String, ItemInfo> stock){
        this.stock = stock;
    }

    public HashMap<String, ItemInfo> getStock(){
        return this.stock;
    }
    public void setStock(HashMap<String, ItemInfo> stock){
        this.stock = stock;
    }
}