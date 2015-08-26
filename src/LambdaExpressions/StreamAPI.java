package LambdaExpressions;

import java.util.Arrays;
import java.util.List;

/**
 * StreamAPI.java
 * Created by Anca.Barbu on 8/26/2015.
 */
public class StreamAPI {
    //old way
    public static void main(String[] args) {
        /*
        Print  each element's cube
         */
        //old way
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for(Integer n : list) {
            int x = n * n;
            System.out.println(x);
        }

        //new way
        list = Arrays.asList(1,2,3,4,5,6,7);
        list.stream().map((x) -> x*x).forEach(System.out::println);

        /*
        Adds each element's cube if the element is even. Prints sum
         */
        int y = list.stream().filter((x)->x%2==0).map((x)->x*x).reduce((x, z)-> x + z).get();
        System.out.println("Result of lambda expression " + y);
    }

}
