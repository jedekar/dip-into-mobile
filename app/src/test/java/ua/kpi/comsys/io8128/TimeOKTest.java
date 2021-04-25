package ua.kpi.comsys.io8128;

import org.junit.Test;

import java.util.Date;

import ua.kpi.comsys.io8128.other.TimeOK;

public class TimeOKTest {
    @Test
    public void TimeOK_test() {
        final TimeOK firstTime = new TimeOK(12, 0, 0);
        final TimeOK secondTime = new TimeOK(12, 0, 1);
        final TimeOK thirdTime = new TimeOK(new Date(10, 12, 2003, 23, 59, 59));
        System.out.println(String.format("Time to string: %s", thirdTime.toString()));
        System.out.println(String.format("Sum : %s", secondTime.add(thirdTime)));
        System.out.println(String.format("Difference: %s", new TimeOK(0L, 0L, 0L).substract(new TimeOK(0L, 0L, 1L))));
        System.out.println(String.format("Add two: %s", TimeOK.addTwoObjects(new TimeOK(10L, 10L, 10L), new TimeOK(10L, 30L, 30L))));
        System.out.println(String.format("Subtract two: %s", TimeOK.subtractTwoObjects(new TimeOK(20L, 10L, 10L), new TimeOK(10L, 50L, 5L))));
    }
}
