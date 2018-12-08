package freedomphones.checkoutsvc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemInfo{
    private String name;
    private Integer in_stock;
    private Double price;

    @JsonCreator
    public ItemInfo(@JsonProperty("name") String name, @JsonProperty("in_stock") Integer in_stock, @JsonProperty("price") Double price){
        this.name = name;
        this.in_stock = in_stock;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Integer getIn_stock(){
        return this.in_stock;
    }
    public void setIn_stock(Integer in_stock){
        this.in_stock = in_stock;
    }
    public Double getPrice(){
        return this.price;
    }
    public void setPrice(Double price){
        this.price = price;
    }

}