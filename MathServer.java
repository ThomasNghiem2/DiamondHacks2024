import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class MathServer {
    String history = "Welcome! To choose the topic you want to practice, type the corresponding path into the url: \"/add\", \"/subtract\", \"/multiply\", \"/divide\" \n\n";
    HashMap<String, String> dataAdd = new HashMap<String, String>();
    HashMap<String, String> dataSubtract = new HashMap<String, String>();
    HashMap<String, String> dataMultiply = new HashMap<String, String>();
    HashMap<String, String> dataDivide = new HashMap<String, String>();

    public String operation(URI url) {
        int range = 20;
        int min = 1;
        Integer solution = 0;

        //expect /add
        if (url.getPath().equals("/add")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            solution = num1 + num2;
            
        }
        if (url.getPath().equals("/subtract")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            solution = num2 - num1;;
        }
        if (url.getPath().equals("/multiply")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            solution = num1 * num2;
        }
        if (url.getPath().equals("/divide")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            //fix due to the rounding down of java
            solution = num1 / num2;
        }
        //expect /solve?answer=<answer>
        if (url.getPath().equals("/solve")) {
            String[] params = url.getQuery().split("=");
            String answer = params[1];
            if (params[0].equals("answer")) {
                if (answer == solution.toString()) {
                    history += "Correct!\n\n";
                }
                else {
                    history += "Oopsie, thats incorrect. Try again!";
                }
            }
            else {
                return "Invalid parameters: " + String.join("=", params);
            }
        }
    }
}
