/**
 * Stack extending abstract stack, which implements Stack.
 */
public class StackImpl extends AbstractStack {

    public StackImpl() {
        // constructor evoked in superclass.
        super(new ArrayList());
    }

    public boolean isEmpty() {
        //  if internalList is empty, stack is empty.
        if (internalList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        // returns size of stack via size of internalList.
        return internalList.size();
    }

    public void push(Object item) {
        // pushes to stack via add method.
        internalList.add(item);
    }

    public ReturnObject top() {
        // returns last elements of list as top of stack.
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return internalList.get(size() - 1);
        }
    }

    public ReturnObject pop() {
        // deletes and returns last element of list as top of stack.
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            ReturnObject objectToReturn = internalList.get(size() - 1);
            internalList.remove(size() - 1);
            return objectToReturn;
        }
    }
}
