package LambdaExpressions;

import java.util.Arrays;
import java.util.List;

/**
 * SimpleExamples.java
 * Created by Anca.Barbu on 8/25/2015.
 */
public class SimpleExamples {
    public static void main(String[] args) {
        //create Runnable interface’s reference from lambda expression
        //since Runnable is a functional interface(it has only one abstract method declared into it)
        Runnable r = () -> System.out.println("hello world - functional");
        r.run();

        Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world - non-functional");
            }
        };

        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list) {
            System.out.println(n);
        }

        //New way:
        //for every element of the list, the foreach function
        //know that it has to execute the function which has
        //an int argument and a body that prints that argument
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));

    }
}
