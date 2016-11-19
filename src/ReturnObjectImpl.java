/**
 * This class implements interface ReturnObject.
 * It's member fields either contain an object to return and null,
 * or an error message utilising the public enum ErrorMassage and null.
 * Object can also be set to null and thus the object and error both contains null.
 */
public class ReturnObjectImpl implements ReturnObject {

    private Object object;
    private ErrorMessage error;

    public ReturnObjectImpl(Object object) {
        // constructor method for the Object to wrap.
        this.object = object;
    }

    public ReturnObjectImpl(ErrorMessage error) {
        // constructor method for the ErrorMessage to return.
        this.error = error;
    }

    public boolean hasError() {
        // if error isn't equal to null, an error message has been set.
        if (this.error != null) {
            return true;
        } else {
            return false;
        }
    }

    public ErrorMessage getError(){
        // returns error message if error has been set.
        if (hasError()) {
            return error;
        } else {
            return ErrorMessage.NO_ERROR;
        }
    }

    public Object getReturnValue() {
        // returns wrapped object or null.
        if (hasError()) {
            return null;
        } else {
            return object;
        }
    }
}
