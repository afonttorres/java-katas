package katas;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private double total = 0.0;

    public double getTotal(){
        return this.total;
    }

    public void sum(double num){
        this.total += num;
    }

    public void rest(double num) {
        this.total -= num;
    }

    public void mult(double num){
        this.total*= num;
    }

    public void div(double num){
        this.total/=num;
    }

    public void modul(double num){
        this.total%=num;
    }

    public boolean isEven(double num){
        if(num %2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public double maxNum(double num1, double num2){
        return Math.max(num1, num2);
    }

    public void sumArr(double[] arr){
        double result = 0.0;
        for( double num : arr ){
            result += num;
        }
        this.total = result;
    }

    public List<Integer> returnEqOrGreatThan5(List<Integer> list){
        List <Integer> resList = new ArrayList<>();

        for(int num : list){
            if(num >=5.0){
                resList.add(num);
            }
        }
        return resList;
    }


}
