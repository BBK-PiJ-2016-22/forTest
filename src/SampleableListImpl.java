/**
 * Sampleable list based on array list.
 */
public class SampleableListImpl extends ArrayList implements SampleableList {

    public SampleableList sample() {
        // returns sampleable copy of list.
        SampleableList listToReturn = new SampleableListImpl();

        for (int i = 0; i < size(); i = i + 2) {
            listToReturn.add(get(i).getReturnValue());
        }
        return listToReturn;
    }
}
