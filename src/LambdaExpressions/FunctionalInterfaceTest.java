package LambdaExpressions;

/**
 * FunctionalInterfaceTest.java
 * Created by Anca.Barbu on 8/25/2015.
 */
@FunctionalInterface
// Functional Interfaces can have only one abstract method.
interface CoffeeShop{
    void printOpenAndClose();
}
public class FunctionalInterfaceTest {
    public static void testCoffeeShop(CoffeeShop coffeeShop){
        coffeeShop.printOpenAndClose();
    }

    public static void main(String[] args) {
        //testCoffeeShop() method can now take lambda expressions as argument that
        //transaltes to:  create an FunctionalInteraceTest object and implement the interface method
        //with the body of this lambda expression
        testCoffeeShop(()-> System.out.println("Opens at 10 am and closes at 11 pm!"));
    }
}
