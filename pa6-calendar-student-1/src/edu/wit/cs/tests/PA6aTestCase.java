package edu.wit.cs.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.Permission;

import junit.framework.TestCase;

public class PA6aTestCase extends TestCase {
    // Added Code
    private static edu.wit.cs.comp1000.PA6a1u001 testClass;
    
    // Runs everything that starts with 'test'
    // End Added Code

    @SuppressWarnings("serial")
    private static class ExitException extends SecurityException {}

    private static class NoExitSecurityManager extends SecurityManager
    {
        @Override
        public void checkPermission(Permission perm) {}

        @Override
        public void checkPermission(Permission perm, Object context) {}

        @Override
        public void checkExit(int status) { super.checkExit(status); throw new ExitException(); }
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        System.setSecurityManager(new NoExitSecurityManager());
    }

    @Override
    protected void tearDown() throws Exception
    {
        System.setSecurityManager(null);
        super.tearDown();
    }

    public void _testLeapYear(int year, boolean expected) {
        Boolean result = null;
        try {
            result = testClass.isLeapYear(year);
        } catch (ExitException e) {}
        assertEquals((Object) expected, (Object) result);
    }

    public void testLeapYear() {
        _testLeapYear(100, false);
        _testLeapYear(200, false);
        _testLeapYear(300, false);
        _testLeapYear(400, true);

        _testLeapYear(500, false);
        _testLeapYear(600, false);
        _testLeapYear(700, false);
        _testLeapYear(800, true);

        _testLeapYear(900, false);
        _testLeapYear(1000, false);
        _testLeapYear(1100, false);
        _testLeapYear(1200, true);

        _testLeapYear(1300, false);
        _testLeapYear(1400, false);
        _testLeapYear(1500, false);
        _testLeapYear(1600, true);

        _testLeapYear(1700, false);
        _testLeapYear(1800, false);
        _testLeapYear(1900, false);
        _testLeapYear(2000, true);

        _testLeapYear(2001, false);
        _testLeapYear(2002, false);
        _testLeapYear(2003, false);
        _testLeapYear(2004, true);
        _testLeapYear(2005, false);
        _testLeapYear(2006, false);
        _testLeapYear(2007, false);
        _testLeapYear(2008, true);
        _testLeapYear(2009, false);
        _testLeapYear(2010, false);
        _testLeapYear(2011, false);
        _testLeapYear(2012, true);
        _testLeapYear(2013, false);
        _testLeapYear(2014, false);
        _testLeapYear(2015, false);
        _testLeapYear(2016, true);
    }

    public void _testMonth(String month, int startDay, int numDays, String expectedOutput, int expectedReturn) {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Integer result = null;
        try {
            result = testClass.printMonth(month, startDay, numDays);
        } catch (ExitException e) {}
        System.setOut(null);

        assertEquals((Object) expectedReturn, (Object) result);
        assertEquals(expectedOutput, outContent.toString());
    }

    public void testPrintMonth() {
        _testMonth("Foo", 0, 1, String.format("Foo%n  1%n%n", new Object[] {}), 1);
        _testMonth("Bar", 0, 2, String.format("Bar%n  1  2%n%n", new Object[] {}), 2);
        _testMonth("Baz", 0, 3, String.format("Baz%n  1  2  3%n%n", new Object[] {}), 3);
        _testMonth("Quz", 0, 6, String.format("Quz%n  1  2  3  4  5  6%n%n", new Object[] {}), 6);
        _testMonth("Foo", 0, 7, String.format("Foo%n  1  2  3  4  5  6  7%n%n", new Object[] {}), 0);
        _testMonth("Bar", 0, 8, String.format("Bar%n  1  2  3  4  5  6  7%n  8%n%n", new Object[] {}), 1);

        _testMonth("Baz", 0, 11, String.format("Baz%n  1  2  3  4  5  6  7%n  8  9 10 11%n%n", new Object[] {}), 4);
        _testMonth("Foo", 0, 14, String.format("Foo%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n%n", new Object[] {}), 0);
        _testMonth("Bar", 0, 15, String.format("Bar%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15%n%n", new Object[] {}), 1);

        _testMonth("Quz", 0, 19, String.format("Quz%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19%n%n", new Object[] {}), 5);
        _testMonth("Foo", 0, 21, String.format("Foo%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n%n", new Object[] {}), 0);
        _testMonth("Bar", 0, 22, String.format("Bar%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22%n%n", new Object[] {}), 1);

        _testMonth("Foo", 0, 27, String.format("Foo%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27%n%n", new Object[] {}), 6);
        _testMonth("Foo", 0, 28, String.format("Foo%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n%n", new Object[] {}), 0);
        _testMonth("Bar", 0, 29, String.format("Bar%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n 29%n%n", new Object[] {}), 1);
        _testMonth("Bar", 0, 30, String.format("Bar%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n 29 30%n%n", new Object[] {}), 2);
        _testMonth("Baz", 0, 31, String.format("Baz%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n 29 30 31%n%n", new Object[] {}), 3);

        _testMonth("December", 0, 9, String.format("December%n  1  2  3  4  5  6  7%n  8  9%n%n", new Object[] {}), 2);
        _testMonth("January", 1, 9, String.format("January%n     1  2  3  4  5  6%n  7  8  9%n%n", new Object[] {}), 3);
        _testMonth("February", 2, 9, String.format("February%n        1  2  3  4  5%n  6  7  8  9%n%n", new Object[] {}), 4);
        _testMonth("March", 3, 9, String.format("March%n           1  2  3  4%n  5  6  7  8  9%n%n", new Object[] {}), 5);
        _testMonth("April", 4, 9, String.format("April%n              1  2  3%n  4  5  6  7  8  9%n%n", new Object[] {}), 6);
        _testMonth("May", 5, 9, String.format("May%n                 1  2%n  3  4  5  6  7  8  9%n%n", new Object[] {}), 0);
        _testMonth("June", 6, 9, String.format("June%n                    1%n  2  3  4  5  6  7  8%n  9%n%n", new Object[] {}), 1);
    }

    public static final String E_YEAR = "The year must be positive!";
    public static final String E_DAY = "The day of January 1st must be between 0 and 6!";

    private void _test(String[] values, String result) {
        final String input = String.join(" ", values);

        final String output = TestSuite.stringOutput(new String[] {
                "Enter the year: ",
                "Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ",
                "%s" }, new Object[] { result });

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(outContent));

        try {
            testClass.main(new String[] {"foo"});
        } catch (ExitException e) {}
        assertEquals(output, outContent.toString());

        System.setIn(null);
        System.setOut(null);
    }

    public void testYearNeg() {_test(new String[] {"-1", "0"}, String.format(E_YEAR+"%n", new Object[] {}));}
    public void testZeroYear() {_test(new String[] {"0", "0"}, String.format(E_YEAR+"%n", new Object[] {}));}

    public void testDayLessGreater() {
        _test(new String[] {"2015", "-2"}, String.format(E_DAY+"%n", new Object[] {}));
        _test(new String[] {"2015", "8"}, String.format(E_DAY+"%n", new Object[] {}));
        _test(new String[] {"2016", "7"}, String.format(E_DAY+"%n", new Object[] {}));
        _test(new String[] {"2016", "-1"}, String.format(E_DAY+"%n", new Object[] {}));
        _test(new String[] {"2016", "-5"}, String.format(E_DAY+"%n", new Object[] {}));

    }

    public void test2015() {
        _test(new String[] {"2015", "4"}, String.format(
                "January%n              1  2  3%n  4  5  6  7  8  9 10%n 11 12 13 14 15 16 17%n 18 19 20 21 22 23 24%n 25 26 27 28 29 30 31%n%n" +
                        "February%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n%n" +
                        "March%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n 29 30 31%n%n" +
                        "April%n           1  2  3  4%n  5  6  7  8  9 10 11%n 12 13 14 15 16 17 18%n 19 20 21 22 23 24 25%n 26 27 28 29 30%n%n" +
                        "May%n                 1  2%n  3  4  5  6  7  8  9%n 10 11 12 13 14 15 16%n 17 18 19 20 21 22 23%n 24 25 26 27 28 29 30%n 31%n%n" +
                        "June%n     1  2  3  4  5  6%n  7  8  9 10 11 12 13%n 14 15 16 17 18 19 20%n 21 22 23 24 25 26 27%n 28 29 30%n%n" +
                        "July%n           1  2  3  4%n  5  6  7  8  9 10 11%n 12 13 14 15 16 17 18%n 19 20 21 22 23 24 25%n 26 27 28 29 30 31%n%n" +
                        "August%n                    1%n  2  3  4  5  6  7  8%n  9 10 11 12 13 14 15%n 16 17 18 19 20 21 22%n 23 24 25 26 27 28 29%n 30 31%n%n" +
                        "September%n        1  2  3  4  5%n  6  7  8  9 10 11 12%n 13 14 15 16 17 18 19%n 20 21 22 23 24 25 26%n 27 28 29 30%n%n" +
                        "October%n              1  2  3%n  4  5  6  7  8  9 10%n 11 12 13 14 15 16 17%n 18 19 20 21 22 23 24%n 25 26 27 28 29 30 31%n%n" +
                        "November%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n 29 30%n%n" +
                        "December%n        1  2  3  4  5%n  6  7  8  9 10 11 12%n 13 14 15 16 17 18 19%n 20 21 22 23 24 25 26%n 27 28 29 30 31%n%n"
                , new Object[] {}));
    }

    public void test2016() {
        _test(new String[] {"2016", "5"}, String.format(
                "January%n                 1  2%n  3  4  5  6  7  8  9%n 10 11 12 13 14 15 16%n 17 18 19 20 21 22 23%n 24 25 26 27 28 29 30%n 31%n%n"+
                        "February%n     1  2  3  4  5  6%n  7  8  9 10 11 12 13%n 14 15 16 17 18 19 20%n 21 22 23 24 25 26 27%n 28 29%n%n"+
                        "March%n        1  2  3  4  5%n  6  7  8  9 10 11 12%n 13 14 15 16 17 18 19%n 20 21 22 23 24 25 26%n 27 28 29 30 31%n%n"+
                        "April%n                 1  2%n  3  4  5  6  7  8  9%n 10 11 12 13 14 15 16%n 17 18 19 20 21 22 23%n 24 25 26 27 28 29 30%n%n"+
                        "May%n  1  2  3  4  5  6  7%n  8  9 10 11 12 13 14%n 15 16 17 18 19 20 21%n 22 23 24 25 26 27 28%n 29 30 31%n%n"+
                        "June%n           1  2  3  4%n  5  6  7  8  9 10 11%n 12 13 14 15 16 17 18%n 19 20 21 22 23 24 25%n 26 27 28 29 30%n%n"+
                        "July%n                 1  2%n  3  4  5  6  7  8  9%n 10 11 12 13 14 15 16%n 17 18 19 20 21 22 23%n 24 25 26 27 28 29 30%n 31%n%n"+
                        "August%n     1  2  3  4  5  6%n  7  8  9 10 11 12 13%n 14 15 16 17 18 19 20%n 21 22 23 24 25 26 27%n 28 29 30 31%n%n"+
                        "September%n              1  2  3%n  4  5  6  7  8  9 10%n 11 12 13 14 15 16 17%n 18 19 20 21 22 23 24%n 25 26 27 28 29 30%n%n"+
                        "October%n                    1%n  2  3  4  5  6  7  8%n  9 10 11 12 13 14 15%n 16 17 18 19 20 21 22%n 23 24 25 26 27 28 29%n 30 31%n%n"+
                        "November%n        1  2  3  4  5%n  6  7  8  9 10 11 12%n 13 14 15 16 17 18 19%n 20 21 22 23 24 25 26%n 27 28 29 30%n%n"+
                        "December%n              1  2  3%n  4  5  6  7  8  9 10%n 11 12 13 14 15 16 17%n 18 19 20 21 22 23 24%n 25 26 27 28 29 30 31%n%n"
                , new Object[] {}));
    }
}