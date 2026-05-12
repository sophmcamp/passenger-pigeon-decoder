/**
 * Author: Sophia Campana (Alexandria, Virginia)
 * Date: April 11, 2018
 *
 * The Poem in the Pigeons by Emily Suvada (from This Mortal Coil) 
 *
 * This program will convert the DNA base pairs to binary, then to ASCII,
 * and then to alphanumeric letters to decyrpt the poem.
 *
 */
public class PassengerPigeonPoem {
    public static void main(String[] args) {
        
       PassengerPigeonInputter input = new PassengerPigeonInputter("src/PassengerPigeonPoemText.txt");
       
       String poem = input.getDNAPoem();
       System.out.println("Base pairs: " + poem);
       
       poem = input.getbinPoem();
       System.out.println("Binary:     " + poem);  
       
       poem = input.get8binPoem();
       System.out.println("Binary separated by 8 digits: " + poem);
      
       poem = input.getASCII();
       System.out.println("ASCII: " + poem);
       
       poem = input.getText();
       System.out.println("Alphanumeric:\n\n" + poem);
    }
 }