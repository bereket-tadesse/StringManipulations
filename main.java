package pro1;

import java.util.Scanner;

/**
 * A class which contains differnt methods analysing strings.
 * @author Bereket
 * @version 1.0
 */
class Assignment1{

    public static void main(String[] args) {
    	
    	
    	
    	System.out.println(Assignment1.palindromeIterative("5nurses run5"));
    	
    	System.out.println("Welcome to the APP!\n 1. Palindrome Check \n 2. Anagram Check \n 3. Add Substring \n 4. Get Length \n 5. Count Occurences \n 6. Reverse Sentence \n 7. Quit ");
    	
    	int option = 0;
    	
    	while(option != 7) {
    		
    		// ask option again
    		System.out.println("Choose An Option: ");
    		
    		// a reeader object for inputs.
        	Scanner reader = new Scanner(System.in);
        	//stores option choice
        	option = reader.nextInt();
    		
        	if (option == 7) {
        		System.out.println("Have a nice day!");
        	} 
        	
    		// switch statemes for the 7 options
    		switch(option) {
    		
    		//Palindrome checker option
			case 1: 
				System.out.println("Enter String: ");
				reader = new Scanner(System.in);
				String input = reader.nextLine();
				
				System.out.println("Palindrome: " + Assignment1.palindromeIterative(input));
				break;
			//anagram checker option
			case 2:
				System.out.println("Enter first String: ");
				reader = new Scanner(System.in);
				String first = reader.nextLine();
				
				System.out.println("Enter second String: ");
				reader = new Scanner(System.in);
				String second = reader.nextLine();
				
				System.out.println("Anagram: " + Assignment1.anagramChecker(first, second));
				break;
				
			// addsubstring option
			case 3:
				System.out.println("Enter first String: ");
				reader = new Scanner(System.in);
				String string = reader.nextLine();
				
				System.out.println("Enter sub-String: ");
				reader = new Scanner(System.in);
				String substring = reader.nextLine();
				
				System.out.println("Enter index: ");
				reader = new Scanner(System.in);
				int index = reader.nextInt();
				System.out.println("Final string is: " + Assignment1.addSubString(string, substring, index));
				break;
			
			// getting length option
			case 4:
				System.out.println("Enter string: ");
				reader = new Scanner(System.in);
				String string2 = reader.nextLine();
				System.out.println("Length of the string is: " + Assignment1.getLength(string2));
				break;
			
			// occurence counter option
			case 5:
				System.out.println("Enter String: ");
				reader = new Scanner(System.in);
				String string3 = reader.nextLine();
				
				System.out.println("Enter sub-String: ");
				reader = new Scanner(System.in);
				String substring2 = reader.nextLine();
				
				System.out.println("Number of occurance is: " + Assignment1.occuranceCounter(string3, substring2));
				break;
			
			// sentence reversion ooption
			case 6: 
				System.out.println("Enter Sentence: ");
				reader = new Scanner(System.in);
				String sentence = reader.nextLine();
			
				System.out.println("Reversed sentence is: " + Assignment1.senetenceReversal(sentence));
				break;
    		}
    		
    		
        	
		}
    	
    	
    }

    /**
     * A method which checks if a string is palindrome or not.
     * @param input the string
     * @return returns true or false 
     */
    public static boolean palindromeIterative(String input){
    	//start and end indexes
        int start = 0;
        int end = input.length() -1 ;
        
        // compare first and last & decrement each time.
        while(start <= end){
        	
        	//skipping white spaces
        	if(Character.isWhitespace(input.charAt(end))) {
        		start++;
        	} else if (Character.isWhitespace(input.charAt(start))) {
        		end--;
        
        	} else {
        		if(Character.toLowerCase(input.charAt(start)) != Character.toLowerCase(input.charAt(end))){
                    return false;
                }
        		start++;
                end--;
        	}
        	
            
            
        }
        
        return true;
    }
    
    /**
     * Alternative method of palindorme check using recursive steps.
     * @param input the string to be checked
     * @return returns true or false
     */
    public static boolean PalindromeRecursive(String input) {
    	// uses the helper method with start and end indexes given.
        int start = 0;
        int end = input.length() -1;
        return Assignment1.HelperPalindromeRecursive(input, start, end);
    }
    
    /**
     * A helper method that recursively checks if string is palidrome or not.
     * @param input the string to be checked
     * @param start start index
     * @param end end index
     * @return returns true if palidrom false if not.
     */
    public static boolean HelperPalindromeRecursive(String input, int start, int end) {
        // base case
        if (start >= end) {
            return true;
        }
        // Compare characters at start and end positions.
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }
        // Recursive call remove the outer character each time.
        return HelperPalindromeRecursive(input, start + 1, end - 1);
    }
    
    /**
     * A method which checks two strings for anagram
     * @param first first string
     * @param second second string
     * @return returns true or false
     */
    public static boolean anagramChecker(String first, String second) {
    	// silent and liste
    	if (first.length()!= second.length()) {
    		return false;
    	}

    	int i = 0;
    	int j = 0;
    	// s i l e n t :                l i s t e n
    	int count = 0;
    	while (i <= first.length()-1) {
            j = 0;
    		while (j<= second.length()-1) {
    			if (first.charAt(i)== second.charAt(j)) {
    				count+=1;
    			}
    			j++;
    		}
    		i++;
    	}
    	
    	if (count == first.length()) {
    		return true;
    	} else {
    		return false;
    	}
	}

    /**
     * A method which adds a substring at specfied index.
     * @param input the main string.
     * @param substring the substring to be added.
     * @param index the index the substric is added at (assuming index starts at 0).
     * @return returns the final appended string.
     */
    public static String addSubString(String input, String substring, int index){

    	// checking invalid index
        if(index > input.length() || index < 0){
            return "Ivalid index";
        }
        
        // stores the final string
        StringBuilder builder = new StringBuilder();

        // add each character before index
        int i = 0;
        while (i < index){
            builder.append(input.charAt(i));
            i++;
        }
        
        // append the substring
        builder.append(substring);

        // continue adding the rest.
        while (i<=input.length()-1){
            builder.append(input.charAt(i));
            i++;
        }
        
        return builder.toString();
    }

    /**
     * A method to find the length of a string. (alternative to input.length() method)
     * @param input the string.
     * @return returns the length.
     */
    public static int getLength(String input){
    	
    	int i = 0;
    	//loops thorugh the array of the string
    	for (char c : input.toCharArray()) {
    	  i++;
    	}
    	return i;
    }

    /**
     * A method which counts the number of occurence of substring in a string.
     * @param input the main string
     * @param substring part of a string to be counted
     * @return returns the number of occurence
     */
    public static int occuranceCounter(String input, String substring) {
        
        int counter = 0;
        int occurance = 0;
        int i = 0; 
        int j = 0;

        if(substring.length() == 0){
            return 0;
        }

        while (j <= input.length()-1) {
            if (substring.charAt(i) == input.charAt(j)){
                counter++;
                i++;
                if (counter == substring.length()){
                    occurance ++;
                    counter = 0;
                    i = 0;
                }
            } else {
                counter = 0;
                i =0;
            }
            j++;
        }
        return occurance;
    }

    /**
     * A method to reverse a sentence 
     * @param input the string to be reversed
     * @return returns the rversed string
     */
    public static String senetenceReversal(String input) {
    	
    	// array containing the words splitted by space
        String[] array = input.split(" ");
        
        // removing the "." from the last word
        String last_word = array[array.length-1].substring(0,array[array.length-1].length()-1);
        //updating the word
        array[array.length - 1] = last_word;
        
        // stores the final reversed string
        StringBuilder builder = new StringBuilder();
        
        // loops trhough the array in reverse order
        for(int i = array.length-1; i >=0; i--) {
        	if(i == 0) {
        		builder.append(array[i] + ". ");
        	} else {
        		builder.append(array[i] + " ");
        	}
        }
        
        return builder.toString();
    }
}
