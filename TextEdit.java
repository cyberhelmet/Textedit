import java.util.Scanner;
import java.util.Random;

/**
 * Sensor Readings (9.1PP Divide and Conquer)
 * 
 * @author Abhishek Tamang
 */

public class TextEdit{
    
    //This method converts the text input taken from the user to an array of it's own individual characters
    public static char[] toArray(char[] cArray,String userInput){
        cArray = userInput.toCharArray();
        return cArray;
    }
    
    //This method displays the menu and operates acoording to the choice made by the user
    public static void menu(String choice,Scanner input,char[] cArray){
        
        do{
            String Array = new String(cArray);
            System.out.println(" Text: "+ Array);
            System.out.println("\nMenu Options: ");
            System.out.println("1: Measure frequency of user specific character");
            System.out.println("2: Find and replace user specific characters");
            System.out.println("3: Swap desired two characters at specified positions");
            System.out.println("4: Shuffle random pairs of characters");
            System.out.println("5: Reverse the input text");
            System.out.println("6: Quit the program");
            System.out.println("\nChoose the option you want to go with: (1-6)");
            int decision = input.nextInt();//declaring and initializing variable which will take user's choice of menu item
            
            switch(decision){
                case 1: 
                    charFrequency(cArray,input);
                    break;
                    
                case 2:
                    findReplace(cArray,input);
                    break;
                    
                case 3:
                    swapPosition(cArray,input);
                    break;
                    
                case 4:
                    shufflePosition(cArray,input);
                    break;
                    
                case 5:
                    reverseArray(cArray,input);
                    break;
                    
                case 6:
                default:
                    choice ="quit";
            }
        }while(!choice.equals("quit"));
    }
    //Finds and displays the user specified character's frquency in the input text of characters
    public static void charFrequency(char[] cArray,Scanner input){
        
        int count = 0;//variable to store the frquency of freqChar
        System.out.println("Enter the character whose frequency you want to find: ");
        char freqChar = input.next().charAt(0);//variable to store user specified character
        freqChar =  Character.toUpperCase(freqChar);//converting input character to uppercase
        
        for(int i = 0; i < cArray.length;i++){
            if(freqChar == cArray[i]){
                count++;
            }
        }
        System.out.println("The frequency of "+freqChar+" is "+count);
        
    }
    
    //This method takes a character input to replace the character the uses wishes to replace in the array
    public static void findReplace(char[] cArray,Scanner input){
        
        int count = 0;//variable to record the occurance of find-replace operation
        System.out.println("Enter the character you want to replace: ");
        char find = input.next().charAt(0);//variable to store user specified character to get replaced
        find =  Character.toUpperCase(find);//converting input character to uppercase
        
        System.out.println("Enter the character which you want to replace with: ");
        char replace = input.next().charAt(0);//variable to store user specified character to replace with
        replace=  Character.toUpperCase(replace);//converting input character to uppercase
        
        for(int i = 0;i < cArray.length;i++){
            if(cArray[i] ==  find){
                cArray[i] = replace;
                count++;
            }
            
        }
        System.out.println("After replacing "+find+" with "+replace+" ,The array looks like: ");
        System.out.println(cArray);
        System.out.println("\nand the operation occured for "+count+" times.");
        
    }
    
    //This method asks the users for two positions within the text and swap the characters at those positions
    public static void swapPosition(char[] cArray,Scanner input){
        
        System.out.println("Enter the position pairs you want to swap:");
        System.out.println("Valid range: 1 - "+cArray.length);
        int firstPos = input.nextInt()-1;//variable to store user specified 
        int secondPos  =  input.nextInt()-1;//position-pairs
        char buffer;//To store array content during swapping values
        System.out.println("Before swapping, Text: ");
        System.out.print(cArray);
        System.out.println("\n");
        cArray = updater(cArray,firstPos,secondPos);
        System.out.println("\nAfter swapping, Text: ");
        System.out.print(cArray);
        System.out.println("\n");
    }
    
    //This method shuffles the array contents by swaping random pairs of positions
    public static void shufflePosition(char[] cArray,Scanner input){
        
       Random position = new Random();//declaring a new random variable position
        char buffer;//Variable to store array content during shuffling.
        System.out.println("Before shuffing, \nText: ");
        System.out.print(cArray);
        //System.out.println("\n");
        for(int i = 0;i<cArray.length/2;i++){
        int firstPlace = position.nextInt(cArray.length-1);//randomly getting the firstposition-pair to swap for shuffling
        int secondPlace = position.nextInt(cArray.length-1);//randomly getting the secondposition-pair to swap for shuffling
         updater(cArray,firstPlace,secondPlace);
        }
        System.out.println("\nAfter shuffling, \nText: ");
        System.out.print(cArray);
        System.out.println("\n");
    }
    
    //This method reverses the input text
    public static void reverseArray(char[] cArray,Scanner input){
        
        char buffer;//variable to store array content during reversing
        System.out.println("\nBefore reversing, Text: ");
        System.out.print(cArray);
        System.out.println("\n");
        for(int i = 0;i < cArray.length/2;i++){
            
            cArray = updater(cArray,i,cArray.length-i-1);
        }
        System.out.println("\nAfter reversing, Text: ");
        System.out.print(cArray);
        System.out.println("\n");
    }
    
    //This method interchanges the values of provided positions of characters of the array 
    public static char[] updater(char[] cArray, int i, int j){
        
        char buffer = cArray[i];//buffer variable to store values during process 
        cArray[i] = cArray[j];
        cArray[j] = buffer;
        return cArray;
    }
    
    
    public static void main(String[] args){
        String userInput;//variable to store user input text
        Scanner input = new Scanner(System.in);//declaring new Scanner variable
        System.out.println(" Text Edit \nEnter a piece of text that you want to operate on?(Any characters allowed) ");
        userInput = input.next().toUpperCase();//Converting user input text to uppercase
        char[] cArray = new char[userInput.length()];//Declaring and initializing a character array
        cArray = toArray(cArray,userInput);
        System.out.println("Do you want to continue to menu: ");
        String choice = input.next(); //Taking user choice if they want to choose any menu options or not
        menu(choice,input,cArray);//passing the flow of data and control to menu method
    }
}









