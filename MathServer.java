import java.io.IOException;
import java.net.URI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class Calcuation {
    String history = "Welcome! To choose the topic you want to practice, type the corresponding path into the url: \"/add\", \"/subtract\", \"/multiply\", \"/divide\" \n\n";
    Integer solution;

    public String operation(URI url) {
        int range = 20;
        int min = 1;

        //expect /add
        if (url.getPath().equals("/add")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            solution = num1 + num2;
            history += num1 + " + " + num2 + " = ?\n";
            return history;
        }
        else if (url.getPath().equals("/subtract")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            solution = num2 - num1;
            history += num2 + " - " + num1 + " = ?\n";
            return history;
        }
        else if (url.getPath().equals("/multiply")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            solution = num1 * num2;
            history += num1 + " * " + num2 + " = ?\n";
            return history;
        }
        else if (url.getPath().equals("/divide")) {
            int num1 = (int)(Math.random() * range) + min;
            int num2 = (int)(Math.random() * range) + min;
            //fix due to the rounding down of java
            solution = num1 / num2;
            history += num1 + " / " + num2 + " = ?\n";
            return history;
        }
        //expect /solve?answer=<answer>
        else if (url.getPath().equals("/solve")) {
            String[] params = url.getQuery().split("=");
            String answer = params[1];
            if (params[0].equals("answer")) {
                if (answer.equals(solution.toString())) {
                    history += "Correct!\n\n";
                }
                else {
                    history += "Oopsie, thats incorrect. Try again!\n";
                }
                return history;
            }
            else {
                return "Invalid parameters: " + String.join("=", params);
            }
        }
        return history;
    }
}

class MathServer {
    public static void main(String[] args) throws IOException {
      int port = Integer.parseInt(args[0]);
      Server.start(port, new Calcuation());
    }
  }