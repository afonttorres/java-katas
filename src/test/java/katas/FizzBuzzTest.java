package katas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {
    @Test
    public void fizzBuzzReturnsBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.returnString(5.0);
        String result = fizzBuzz.getResult();
        assertEquals("Buzz", result);
    }

    @Test
    public void fizzBuzzReturnsFizz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.returnString(3.0);
        String result = fizzBuzz.getResult();
        assertEquals("Fizz", result);
    }

    @Test
    public void fizzBuzzReturnsFizzBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.returnString(15.0);
        String result = fizzBuzz.getResult();
        assertEquals("FizzBuzz", result);
    }

    @Test
    public void fizzBuzzReturnsNum(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.returnString(2.0);
        String result = fizzBuzz.getResult();
        assertEquals("2.0", result);
    }

    @Test
    public  void fizzBuzzReturnsListDivByNum(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<Double> doubleList = List.of(5.0, 4.0, 15.0, 75.0, 12.0, 28.0);
        List<Double> result = fizzBuzz.returnListDivByNum(doubleList, 5.0);
        List <Double> resList = List.of(5.0, 15.0, 75.0);
        assertEquals(resList, result);
    }

    @Test
    public void fizzBuzzReturnsUsersOlderThan18(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        User agnes = new User("Agnès", 27);
        User nil = new User("Nil", 23);
        User sira = new User("Sira", 2);
        List<User> usersList = List.of(agnes, nil, sira);
        List<User> result = fizzBuzz.returnAdults(usersList);
        List<User> resList = List.of(agnes, nil);
        assertEquals(resList,result);

    }
}