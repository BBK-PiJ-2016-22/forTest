/**
 * This class implements interface List, as a singely linked list, by the use of nodes and pointers.
 */
public class LinkedList implements List {

    private LinkedListNode header;

    public boolean isEmpty() {
        // if header is null list is empty.
        if (header == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        // calculates size by counting through a loop.
        int size = 0;
        LinkedListNode pointer = header;

        while (pointer != null) {
            pointer = pointer.getNextNode();
            size ++;
        }
        return size;
    }

    public ReturnObject get(int index) {
        // gets object by index.
        int length = size();

        if (index < 0 || index >= length) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        LinkedListNode pointer = header;

        for (int i = 0; i < index; i++) {
            pointer = pointer.getNextNode();
        }
        return new ReturnObjectImpl(pointer.getItem());
    }

    public ReturnObject remove(int index) {
        // removes node by index.
        int length = size();
        LinkedListNode pointer = header;
        Object ObjectToReturn = get(index).getReturnValue();

        if (index < 0 || index >= length) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        if (length == 1 && index == 0) {
            header = null;
            return new ReturnObjectImpl(null);
        }

        if (index+1 == length) {
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.getNextNode();
            }
            pointer.setNextNode(null);
        } else if(index == 0) {
            header = pointer.getNextNode();
            pointer.setNextNode(null);
        } else {
            for (int i = 0; i < index-1; i++) {
                pointer = pointer.getNextNode();
            }
            pointer.setNextNode(pointer.getNextNode().getNextNode());
        }
        return new ReturnObjectImpl(ObjectToReturn);
    }

    public ReturnObject add(int index, Object item) {
        // adds node by index.
        int length = size();
        LinkedListNode pointer = header;

        if (index < 0 || index >= length) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        if (index == 0) {
            LinkedListNode itemToInsert = new LinkedListNode(item);
            itemToInsert.setNextNode(pointer);
            header = itemToInsert;
        } else {
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.getNextNode();
            }

            LinkedListNode itemToInsert = new LinkedListNode(item);
            itemToInsert.setNextNode(pointer.getNextNode());
            pointer.setNextNode(itemToInsert);
        }

        return new ReturnObjectImpl(null);
    }

    public ReturnObject add(Object item) {
        // adds node at the end of list.
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        LinkedListNode pointer = header;

        if (header == null) {
           header = new LinkedListNode(item);
           return new ReturnObjectImpl(null);

        } else {

            while (pointer.getNextNode() != null) {
                pointer = pointer.getNextNode();
            }
            pointer.setNextNode(new LinkedListNode(item));
            return new ReturnObjectImpl(null);
        }
    }
}
