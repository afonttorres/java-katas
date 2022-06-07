package katas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void calculatorStartsZero(){
        //GIVEN
        Calculator calculator = new Calculator();
        //WHEN
        double result = calculator.getTotal();
        //THEN
        assertEquals( 0.0, result);
    }
    @Test
    public void calculatorReturnsSum(){
        Calculator calculator = new Calculator();
        calculator.sum(3.0);
        double result = calculator.getTotal();
        assertEquals(3.0, result);
    }
    @Test
    public void calculatorReturnsRest(){
        Calculator calculator = new Calculator();
        calculator.rest(5.0);
        double result = calculator.getTotal();
        assertEquals(-5.0, result);
    }

    @Test
    public void calculatorReturnsMult(){
        Calculator calculator = new Calculator();
        calculator.mult(2.0);
        double result = calculator.getTotal();
        assertEquals(0.0, result);
    }

    @Test
    public void calculatorReturnsDiv(){
        Calculator calculator = new Calculator();
        calculator.div(2.0);
        double result = calculator.getTotal();
        assertEquals(0.0, result);
    }

    //modul
    @Test
    public void calculatorReturnsModul(){
        Calculator calculator = new Calculator();
        calculator.modul(2.0);
        double result = calculator.getTotal();
        assertEquals(0.0, result);
    }

    @Test
    public void calculatorReturnsIsEven(){
        Calculator calculator = new Calculator();
        boolean result = calculator.isEven(2.0);
        assertEquals(true, result);
    }

    @Test
    public void calculatorReturnsMax(){
        Calculator calculator = new Calculator();
        double result = calculator.maxNum(3.0, 15.0);
        assertEquals(15.0, result);
    }

    @Test
    public void calculatorReturnsSumArr(){
        Calculator calculator = new Calculator();
        double[] doubleArr = new double[] {5.0, 12.0, 4.0, 7.0};
        calculator.sumArr(doubleArr);
        double result = calculator.getTotal();
        assertEquals(28.0, result);
    }

    @Test
    public void calculatorReturnsEqOrGreatThan5(){
        Calculator calculator = new Calculator();

        List<Integer> list = new ArrayList<Integer>();
        int[] listVals = {2, 4, 5, 15, 1, 22, 7};
        for( int val : listVals){
            list.add(val);
        }

        List<Integer> result = calculator.returnEqOrGreatThan5(list);

        List <Integer> resList = new ArrayList<Integer>();
        resList.add(5);
        resList.add(15);
        resList.add(22);
        resList.add(7);

        assertEquals(resList, result);
    }
}