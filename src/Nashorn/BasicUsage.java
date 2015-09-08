package Nashorn;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * BasicUsage.java
 * Class that shows how Java can call Javascript functions and viceversa
 * Created by Anca.Barbu on 9/7/2015.
 */
public class BasicUsage {

    public static String javaFun1(String name) {
        System.out.format("Hi there from Java, %s - invoked by Javascript from Java\n", name);
        return "greetings from java - invoked by Javascript from Java";
    }

    public static void fun2(Object object) {
        System.out.println(object.getClass() + " - invoked by Javascript from Java");
    }

    public static void fun3(ScriptObjectMirror mirror) {
        System.out.println(mirror.getClass() + ": " +
                Arrays.toString(mirror.getOwnKeys(true)));
    }

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval(new FileReader("src/Nashorn/script.js"));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e + " -- Script invoked in main method, in BasicUsage class, not found");
        }
        /*------------------------------------Invoking Javascript Functions from Java------------------------------------*/
        //in order to call a function, first  cast the script engine to NashornScriptEngine(implements Invocable)
        Invocable invocable = (Invocable) engine;
        Object result = null;
        try {
            //get result from invoking function
            result = invocable.invokeFunction("fun1", "Anca Denisa");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //printing result
        System.out.println(result);


        //call the second function by passing arbitrary java objects:
        invocable.invokeFunction("fun2", new Date());
        // [object java.util.Date]

        invocable.invokeFunction("fun2", LocalDateTime.now());
        // [object java.time.LocalDateTime]

        invocable.invokeFunction("fun2", new Person());
        // [object com.winterbe.java8.Person]



    }
}
