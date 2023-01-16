package org.testing;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercises {
    @DataProvider(name = "generateAdditionData")
    public Object[][] generateAdditionData() {
        return new Object[][]{
                {1, 2, 3},
                {0, 2, 2},
                {-1, 2, 1},
                {-1, -1, -2},
        };
    }

    @Test(dataProvider = "generateAdditionData", groups = "addition")
    public void testAddition(int a, int b, int expectedResult) {
        int actualResult = a + b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "generateSubtractionData")
    public Object[][] generateSubtractionData() {
        return new Object[][]{
                {1, 1, 0},
                {0, 1, -1},
                {2, 1, 1},
                {2, -1, 3},
                {10, 1, 9},
                {-1, -1, 0},
                {-2, -1, -1},
        };
    }

    @Test(dataProvider = "generateSubtractionData", groups = "subtraction")
    public void testSubtraction(int a, int b, int expectedResult) {
        int actualResult = a - b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "generateMultiplicationData")
    public Object[][] generateMultiplicationData() {
        return new Object[][]{
                {1, 1, 1},
                {2, 1, 2},
                {0, 1, 0},
                {-1, -1, 1},
                {10, 1, 10},
                {2, -1, -2},
        };
    }

    @Test(dataProvider = "generateMultiplicationData", groups = "multiplication")
    public void testMultiplication(int a, int b, int expectedResult) {
        int actualResult = a * b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "generateDivisionData")
    public Object[][] generateDivisionData() {
        return new Object[][]{
                {1, 1, 1},
                {2, 1, 2},
                {0, 1, 0},
                {1, 0, 1},
                {-1, -1, 1},
                {10, 1, 10},
                {2, -1, -2},
        };
    }

    @Test(dataProvider = "generateDivisionData", groups = "division")
    public Object[][] testDivision(int a, int b, int expectedResult) {
        try {
            int actualResult = a / b;
            Assert.assertEquals(actualResult, expectedResult);
        } catch (ArithmeticException e) {
            Assert.assertEquals(e.getMessage(), "/ by zero");
            if (b != 0) {
                throw e;
            }
        }
    }
        @DataProvider(name = "generateModulusData")
        public Object[][] generateModulusData() {
            return new Object[][]{
                    {1, 1, 0},
                    {2, 1, 0},
                    {0, 1, 0},
                    {1, 0, 1},
                    {-1, -1, 0},
                    {10, 1, 0},
                    {2, -1, 0},
                    {2, -1, 0},
                    {6, 2, 0},
                    {7, 2, 1},
                    {11, 2, 1},
            };
        }

        @Test(dataProvider = "generateModulusData", groups = "modules")
        public void testModulus(int a, int b, int expectedResult) {
            try {
                int actualResult = a % b;
                Assert.assertEquals(actualResult, expectedResult);
            } catch (ArithmeticException e) {
                Assert.assertEquals(e.getMessage(), "/ by zero");
                if (b != 0) {
                    throw e;
                }
            }
        }
    }

<suite name=" Exercises suite" verbose="1" parallel="methods" thread-count="4">
<test name="Exercises Tests">
<classes>
<class name="Exercises"/>
</classes>
</test>
</suite>
        }
        suite name="Web test suite" verbose="1" parallel="methods" thread-count="2">
<test name="Parallel Tests">
<classes>
<class name="lecture10.ParallelTests"></class>
<class name="lecture10.ParallelSecondTests"></class>
<class name="lecture10.examples.ParallelTests"></class>
<class name="lecture10.examples.ParallelSecondTests"></class>
</classes>
</test>
</suite>


