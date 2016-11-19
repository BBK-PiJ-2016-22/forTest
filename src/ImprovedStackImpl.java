/**
 * Improved stack that implements ImprovedStack and is based on ArrayList.
 */
public class ImprovedStackImpl extends ArrayList implements ImprovedStack {

    public void push(Object item) {
        // adds item to stack via list's add().
        add(item);
    }

    public ReturnObject top() {
        // returns top items by getting last object of list.
        return get(size() - 1);
    }

    public ReturnObject pop() {
        // pops off item from stack via list's remove() and get().
        if (size() == 0) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            ReturnObject objectToReturn = get(size()-1);
            remove(size() - 1);
            return objectToReturn;
        }
    }

    public ImprovedStack reverse() {
        // creates a new stack with the items reversed.
        ImprovedStack stackToReturn = new ImprovedStackImpl();
        int aux; // auxillary integer that works as counter

        for (int i = 0; i < size(); i++) {
            aux = i + 1;
            stackToReturn.push(get(size() - aux).getReturnValue());
        }
        return stackToReturn;
    }

    public void remove(Object object) {
        // using recursion and loop to remove item from list.
        for (int i = 0; i < size(); i++){

            if (get(i).getReturnValue().equals(object)) {
                remove(i);
                remove(object);
            }
        }
    }
}
