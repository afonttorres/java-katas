package katas;

import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {

    private String result;

    public String getResult(){
        return this.result;
    }

    public void returnString(double num){
        if( num%5 == 0.0 && num%3 == 0 ){
            this.result = "FizzBuzz";
        } else if( num%5 == 0){
            this.result = "Buzz";
        } else if( num%3 == 0){
            this.result = "Fizz";
        } else{
            this.result = String.valueOf(num);
        }
    }

    public List<Double> returnListDivByNum(List<Double> doubleList, double num){
        List<Double> doublesFound = doubleList.stream().filter(Double -> Double % num == 0.0).collect(Collectors.toList());
        return doublesFound;
    }

    public List<User> returnAdults(List<User> usersList){
        List<User> usersFound = usersList.stream().filter(User -> User.getAge() >=18).collect(Collectors.toList());
        return usersFound;
    }


}
