package nl.ziggo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PrintOneToTenTest.class, CompareTwoListTest.class, CalculateTriangleAreaTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}