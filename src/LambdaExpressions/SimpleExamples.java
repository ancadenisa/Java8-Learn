package LambdaExpressions;

import java.util.Arrays;
import java.util.List;

/**
 * SimpleExamples.java
 * Created by Anca.Barbu on 8/25/2015.
 */
public class SimpleExamples {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hello world");

        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list) {
            System.out.println(n);
        }

        //New way:
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));

    }
}
