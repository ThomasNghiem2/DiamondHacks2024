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
        if (url.getPath().equals("/add")) {
            String[]
            while (true) {
                int num1 = (int)(Math.random() * range);
                int num2 = (int)(Math.random() * range);

            }
        }
        if (url.getPath().equals("/subtract")) {

        }
        if (url.getPath().equals("/multiply")) {

        }
        if (url.getPath().equals("/divide")) {

        }
    }
}
