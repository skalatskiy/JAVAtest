package nl.ziggo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CompareTwoListTest {


    @Parameterized.Parameters(name
            = "{index}: Test with ListOne={0}, ListTwo={1}, allItemsAreContained")
    public static Iterable<Object[]> compareTwoListData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 3, 3, 7, 9, 0, 9, 1), Arrays.asList(3, 7, 3, 1, 1, 0, 9, 9, 8)},
                {Arrays.asList(3, 7, 3, 1, 1, 0, 9, 9, 8), Arrays.asList(1, 3, 3, 7, 9, 0, 9, 1)},
                {Arrays.asList("a", "b", "c"), Arrays.asList("c", "a", "b")},
                {Arrays.asList("c", "b"), Arrays.asList("d", "a", "b")},
        });
    }

    private List<Object> listA, listB;

    public CompareTwoListTest(List<Object> listA, List<Object> listB) {
        this.listA = listA;
        this.listB = listB;
    }


    @Test
    public void compareTwoList() {
        this.listA = this.listA.stream().parallel().distinct().filter(obj -> !this.listB.contains(obj)).collect(Collectors.toList());
        assertTrue(String.format("List %s doesn't contain object(s) %s", listB, listA), listA.isEmpty());
    }
}
