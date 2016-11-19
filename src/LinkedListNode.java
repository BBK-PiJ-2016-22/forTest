/**
 * Node for singely Linkedlist.
 * Wrapper that stores object and is able to be connected to other Nodes via pointers.
 */
public class LinkedListNode {

    private Object item;
    private LinkedListNode nextNode;


    public LinkedListNode(Object item) {
        this.item = item;
    }

    public Object getItem() {
        // retrieves item from wrapper.
        return item;
    }

    public LinkedListNode getNextNode() {
        // getter for nextNode.
        return nextNode;
    }

    public void setNextNode(LinkedListNode nextNode) {
        // setter for nextNode.
        this.nextNode = nextNode;
    }

}
