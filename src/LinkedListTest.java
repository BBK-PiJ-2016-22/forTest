import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit tests for all methods in LinkedList;
 */
public class LinkedListTest {

    private LinkedList testOne;
    private LinkedList testTwo;

    @Before
    public void setUp(){
        testTwo = new LinkedList();
        testOne = new LinkedList();
        for (int i = 0; i < 50; i++){
            testOne.add('a');
            testTwo.add('a');
        }
    }

    @Test
    public void isEmptyTest() {
        LinkedList testEmpty = new LinkedList();
        assertEquals(testEmpty.isEmpty(), true);
        assertEquals(testOne.isEmpty(), false);

    }

    @Test
    public void sizeTest() throws Exception {
        LinkedList testSize = new LinkedList();

        for (int i = 0; i < 2000; i++){
            assertEquals(testSize.size(), i);
            testSize.add(2);

        }
    }

    @Test
    public void getTest() throws Exception {

        for (int i = 0; i < 2000; i++) {
            assertEquals(testOne.get(i).getReturnValue(), testTwo.get(i).getReturnValue());
            assertEquals(testOne.get(i).getError(), testTwo.get(i).getError());
        }

        assertEquals(testOne.get(-1).getError(), testTwo.get(-1).getError());
        assertEquals(testOne.get(60).getError(), testTwo.get(60).getError());
    }

    @Test
    public void removeTest() throws Exception {

        for (int i = 50; i >= 0; i--) {
            testOne.remove(i);
            assertEquals(testOne.size(), i);
        }
    }

    @Test
    public void addTest() throws Exception {
        LinkedList testAddOne = new LinkedList();
        LinkedList testAddTwo = new LinkedList();

        for (int i = 0; i < 2000; i++) {
            testAddOne.add(i);
            testAddTwo.add(i);
            assertEquals(testAddOne.get(i).getReturnValue(), testAddTwo.get(i).getReturnValue());

        }

    }

    @Test
    public void addWithIndexTest() throws Exception {

        for (int i = 0; i < 50; i++) {

            testOne.add(i, "X");
            testTwo.add(i, "X");

            assertSame(testOne.get(i).getReturnValue(), testTwo.get(i).getReturnValue());

        }

    }

}