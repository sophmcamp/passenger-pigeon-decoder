import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PassengerPigeonInputter {
    
    private Scanner scanner;
    private String poem = "";
    
    /**
     * Finding .txt file
     * @param name = file name
     */
    public PassengerPigeonInputter(String name) {
        try {
            scanner = new Scanner(new File(name));
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Extracting content of .txt file
     * @return
     */
    public String getDNAPoem() {
        poem = scanner.useDelimiter("\\A").next();
        if (poem.contains("A") && poem.contains("T") && poem.contains("G") && poem.contains("C")) {
            return poem;
        }
        return "Text is not a DNA poem.";
    }
    
    /**
     * Converting base pairs to binary
     * A and T map to 0
     * G and C map to 1
     */
    public String getbinPoem() {
        if (poem.contains("A") && poem.contains("T") && poem.contains("G") && poem.contains("C")) {
            poem = poem.replace('A', '0').replace('T', '0').replace('G', '1').replace('C', '1'); 
            return poem;
        }
        return "Not found";
    }
    
    /**
     * Adding a space after every 8 digits
     */
    public String get8binPoem() {
        if (poem.contains("0") && !poem.contains("3")) {

            int position = -1;
            int max = poem.length();
            String section1 = "";
            String section2 = "";
            
            for (int k = 0; k < max / 8; k++) {
               position +=9;
               section1 = poem.substring(0, position);
               section2 = poem.substring(position);
               poem = section1 + " " + section2;
            }
            return poem;
        }
        return "Not found";
    }
    
    /**
     * Converting binary to ASCII
     */
    public String getASCII() {
        if (poem.contains(" ") && poem.contains("0") && !poem.contains("3")) {
            
            int p1 = 0;
            int p2 = 8;
            int decimal = 0;
            String binary = "";
            int power = 7;
            String asciiPoem = "";
            
            while (poem.substring(p1).length() >= 8) {
               decimal = 0;
               binary = poem.substring(p1, p2);
               power = 7;
               int temp = p1;
               
               while (power >= 0) {
                  if (poem.charAt(temp) == '1')
                     decimal += Math.pow(2, power);
                  temp++;
                  power--;
               }
               
               asciiPoem += decimal + " ";
               p1 += 9;
               p2 += 9;
            }
            poem = asciiPoem;
            return poem;
        }
        return "Not found";
    }
    
    /**
     * Converting ASCII to alphanumeric letters
     */
    public String getText() {
        if (poem.contains("3")) {
            String finalPoem = "";
            
            while (poem.length() > 1) {
               String numStr = poem.substring(0, poem.indexOf(" "));
               int num = Integer.parseInt(numStr);
               char letter = (char)num;
               finalPoem += letter;
               poem = poem.substring(poem.indexOf(" ") + 1);
            }
            
            poem = finalPoem;
            int start = 0;
            int pos = 0;
            int pBefore = 0;
            String sec1 = "";
            String sec2 = "";

            
            while (pos < poem.length()) {
               if (pos > 0 && Character.isUpperCase(poem.charAt(pos)) && pos - pBefore > 20) {
                  sec1 = poem.substring(start, pos - 1);
                  sec2 = poem.substring(pos);
                  poem = sec1 + "\n" + sec2;
                  pBefore = pos;
               }
               pos++;
            }
            return poem;
            
        }
        return "Not found";
    }
}