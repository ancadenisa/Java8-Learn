package LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * PredicateFunctionalInterfaceTest.java
 * Created by Anca.Barbu on 8/26/2015.
 */
public class PredicateFunctionalInterfaceTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //the second parameter of all the evaluate methods creates
        //a Predicate functional interface reference that creates
        //a test which is applied on every element list
        System.out.println("Print all numbers");
        evaluate(list, (n)->true);
        System.out.println("Print even numbers");
        evaluate(list, (n)->n%2 == 0);
        System.out.println("Print odd numbers greater than 5");
        evaluate(list, (n)->n%2 == 0 && n > 5);

    }
    public static void evaluate(List<Integer> list, Predicate<Integer> pr){
        for(Integer n : list){
            if(pr.test(n)){
                System.out.println(n + " ");
            }
        }
    }
}
