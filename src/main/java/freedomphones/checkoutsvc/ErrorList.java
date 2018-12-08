package freedomphones.checkoutsvc;

import java.util.Collections;
import java.util.List;

public class ErrorList {
    public List<String> errors;

    public ErrorList(){
        this.errors = Collections.<String>emptyList();
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