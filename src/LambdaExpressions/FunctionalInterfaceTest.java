package LambdaExpressions;

/**
 * FunctionalInterfaceTest.java
 * Created by Anca.Barbu on 8/25/2015.
 */
@FunctionalInterface
interface CoffeeShop{
    void printOpenAndClose();
}
public class FunctionalInterfaceTest {
    public static void testCoffeeShop(CoffeeShop coffeeShop){
        coffeeShop.printOpenAndClose();
    }

    public static void main(String[] args) {
        testCoffeeShop(()-> System.out.println("Opens at 10 am and closes at 11 pm!"));
    }
}
