/**
 * Author: Sophia Campana
 * Original date: April 11, 2018
 *
 * The Poem in the Pigeons by Emily Suvada (from This Mortal Coil) 
 *
 * This program will convert the DNA base pairs to binary, then to ASCII,
 * and then to alphanumeric letters to decode the poem.
 *
 */
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PassengerPigeonPoem {
    public static void main(String[] args) {
        
       PassengerPigeonInputter input = new PassengerPigeonInputter("src/PassengerPigeonPoemText.txt");
       
       try {
           PrintStream out = new PrintStream("./DecodedPoem.txt");
           System.setOut(out);
           System.setErr(out);
           System.out.print(
               "Base pairs:\n" + input.getDNAPoem()
               + "\n\nBinary:\n" + input.getbinPoem()
               + "\n\nBinary separated by 8 digits:\n" + input.get8binPoem()
               + "\n\nASCII:\n" + input.getASCII()
               + "\n\nAlphanumeric:\n" + input.getText()
               );
       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       
    }
 }
