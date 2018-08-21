package nl.ziggo;

import org.junit.Test;

import java.util.stream.IntStream;

public class PrintOneToTenTest {
    @Test
    public void test() {
        IntStream.rangeClosed(1,10).forEachOrdered(System.out::println);
    }
}
