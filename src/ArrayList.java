/**
 * This class implements interface List by the use of an array.
 *
 */
public class ArrayList implements List {

    private Object[] list;

    public ArrayList() {
        // constructor method creates an empty array of various boxed types.
        list = new Object[0];
    }

    public boolean isEmpty() {
        // if length of array is zero, then list is empty.
        if (list.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        // length of array is length of list.
        return list.length;
    }


    public ReturnObject get(int index) {
        // returns either wrapped object by index or error message.
        if (index < 0 || index >= list.length) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            return new ReturnObjectImpl(list[index]);
        }

    }

    public ReturnObject remove(int index) {
        // removes object from array by index and loop.
        if (index < 0 || index >= list.length) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }
        Object objectToReturn = list[index];
        Object[] temp = new Object[list.length - 1];

        int aux  = 0; // auxiliary integer that gets set to one when index nr is reached.

        for (int i = 0; i < list.length; i++) {

                if (i != index) {
                    temp[i - aux] = list[i];
                }

                if (i == index) {
                    aux = 1;
            }
        }

        list = temp;

        return new ReturnObjectImpl(objectToReturn);
    }

    public ReturnObject add(int index, Object item) {
        // adds object to array by index and loop.
        if (index < 0 || index >= list.length) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        Object[] temp = new Object[list.length + 1]; // creates new temp array

        int aux = 0; // auxiliary integer that gets set to one when index nr is reached.

        for (int i = 0; i < list.length; i++) {

            if (i == index && index != temp.length) {
                temp[i] = item;

                temp[i + 1] = list[i];

                aux = 1;

            } else {
                temp[index] = item; // adds the new element
            }

            if (i != index) {
                temp[i + aux] = list[i];
            }

        }

        list = temp;

        return new ReturnObjectImpl(null);
    }


    public ReturnObject add(Object item) {

        // if add equals null

        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        Object[] temp = new Object[list.length + 1]; // creates new temp array

        // copies everything over to the new array
        for (int i = 0; i < list.length; i++) {

            temp[i] = list[i];
        }
        temp[list.length] = item; // adds the new element

        list = temp;

        return new ReturnObjectImpl(null);
    }
}
