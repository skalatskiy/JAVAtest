package nl.ziggo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CalculateTriangleAreaTest {


    @Parameterized.Parameters(name = "{index}: Test with X={0}, Y={1}, result: {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Point(1, 5), new Point(1, 3), new Point(3, 1)},
        });
    }

    private Point a, b, c;

    public CalculateTriangleAreaTest(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Test
    public void test() {
        assertTrue(String.format("The three points a=%s b=%s c=%s given doesn't form a triangle Is Not a triangle", a.toString(), b.toString(), c.toString()), !a.equals(b) && !b.equals(c) && !c.equals(a));
        Double distanceAB = Math.sqrt(Math.pow(this.a.getX() - this.b.getX(), 2) + Math.pow(this.a.getY() - this.b.getY(), 2));
        Double distanceBC = Math.sqrt(Math.pow(this.b.getX() - this.c.getX(), 2) + Math.pow(this.b.getY() - this.c.getY(), 2));
        Double distanceCA = Math.sqrt(Math.pow(this.c.getX() - this.a.getX(), 2) + Math.pow(this.c.getY() - this.a.getY(), 2));
        Double perimeter = (distanceAB + distanceBC + distanceCA) / 2;
        double area = Math.sqrt((perimeter * (perimeter - distanceAB) * (perimeter - distanceBC) * (perimeter - distanceCA)));
        assertTrue("Area value is not correct", area > 0);
        System.out.println(String.format("This (%s) is the value of area for triangle with points a=%s , b=%s and c=%s", area, a, b, c));
    }

}
