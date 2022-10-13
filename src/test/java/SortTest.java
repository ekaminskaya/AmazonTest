import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SortTest {

    public List<String> sortDropdownItemsList(Collection collection) {
        List<String> listForSorting = new ArrayList<>(collection);
        Collections.sort(listForSorting, Collections.reverseOrder());
        return listForSorting;
    }

    public LinkedHashSet sortDropdownItemsSet(Collection collection) {
       return (LinkedHashSet) collection.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Test
    public void sortListTest(){
        List<String> beforeSort = Arrays.asList("One", "Five", "Seven");
        Assert.assertEquals(sortDropdownItemsList(beforeSort), Arrays.asList("Seven", "One", "Five"));
    }

    @Test
    public void sortSet(){
        List<Integer> beforeSort = Arrays.asList(1,3,20,9,1);
        Assert.assertEquals(sortDropdownItemsSet(beforeSort), Arrays.asList(1,3,9,20));
    }
}
