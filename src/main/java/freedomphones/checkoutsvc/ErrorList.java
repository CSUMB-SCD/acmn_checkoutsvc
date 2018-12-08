package freedomphones.checkoutsvc;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {
    private List<String> errors;

    public ErrorList(){
        this.errors = new ArrayList<>();
    }
    public List<String> getErrors(){
        return this.errors;
    }
    public void setErrors(List<String> errors){
        this.errors = errors;
    }
    public void addError(String error){
        this.errors.add(error);
    }
    public Boolean isEmpty(){
        return errors.isEmpty();
    }
}