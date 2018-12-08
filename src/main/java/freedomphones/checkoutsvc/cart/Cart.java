package freedomphones.checkoutsvc.cart;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cart{
    private String id;
    private String username;
    private HashMap<String, Item> items;

    @JsonCreator
    public Cart(@JsonProperty("id") String id, @JsonProperty("username") String username,@JsonProperty("items") HashMap<String, Item> items) {
        this.username = username;
        this.items = items;
    }
    public String getId(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public HashMap<String, Item> getItems(){
        return this.items;
    }
    public void setItems(HashMap<String, Item> items){
        this.items = items;
    }
}