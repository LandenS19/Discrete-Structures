import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Midterm {
    static char[] before;
    public static void main(String[] args) {
        int randSeed = 12783;
        Random rand = new Random(randSeed);

        // Here I build an ArrayList of 25 Integers
        ArrayList<Integer> intList = new ArrayList<>();
        int modulus = 27 + rand.nextInt(20);
        for(int i = 0; i < 25; i++) intList.add((37 * i + 17) % modulus);
        System.out.println("intList: " + intList);

        // Question 1
        // Find and print the least element of intList
        int leastElement = -1;
        // Your work here
        for(int least : intList){ // Loop through all the elements of intList
            if(leastElement == -1) leastElement = least; // If the leastElement is the default value it sets it to the first element of intList
            if(least < leastElement)  // If the element of intList is less than the current leastElement
                leastElement = least;  // Sets the new leastElement
        }

        System.out.println("Least element is " + leastElement);
        //////////////////////////////////////////////////////////


        // Question 2
        // Create an ArrayList called evenList, and fill it with just the 
        // even elements of intList.
        
        // Your work here
        ArrayList<Integer> evenList = new ArrayList<>();
        for(int num : intList){ // Loop through all the elements of intList
            if(num%2 == 0){  // If the element % 2 = 0 then it is even
                evenList.add(num);  // Adds the element to the list
            }
        }

        // Uncomment the line below for printing
        System.out.println("evenList: " + evenList);
        //////////////////////////////////////////////////////////////
        

        // Question 3
        // Count how many elements of intList are multiples of 3
        int numMultsOf3 = 0;
        // Your work here
        for(int z : intList){      // Loop throught the elements of intList
            if(z%3 == 0){          // If z is a multiple of 3
                numMultsOf3 ++;    // add to the count
            }
        }

        System.out.println("There are " + numMultsOf3 + " multiples of 3");
        ///////////////////////////////////////////////////////////////////
        

        // Question 4
        // Complete the addOne method below, after the end of this main method.
        // Then use it to create the plusOneList, as indicated below.
        ArrayList<Integer> plusOneList = addOne(intList);
        System.out.println("intList:     " + intList); // reprint, for comparison
        System.out.println("plusOneList: " + plusOneList);
        /////////////////////////////////////////////////////////////////////


        // Question 5
        // The loop below prints the elements of intList with some information
        // about the numbers. But probably, it's wrong. Modify the code inside
        // the loop so that it prints the "less than," "equal to," or "greater than"
        // as appropriate.
        for(int x : intList){
            if(x == 20){
                System.out.println(x + " is equal to 20");
            } else if(x > 20) {
                System.out.println(x + " is greater than 20");
            } else{
                System.out.println(x + " is less than 20");
            }
        }
        //////////////////////////////////////////////////////////////////////
        

        // Question 6
        // Complete the function readUntilGood() below. Here is some code to test it.
        int age = readUntilGood(33);
        System.out.println("Age is " + age);
        //////////////////////////////////////////////////////////////////////
        

        // Question 7
        // Write the wrapRight() function below. Here is a test:
        before = new char[] {'1', '2', '3', '4', '5', '6'};
        char[] after1 = new char[] {'3', '1', '2', '6', '4', '5'};
        char[] after2 = new char[] {'1', '3', '6', '2', '5', '4'};
        wrapRight(2, 3, before);
        boolean success1 = Arrays.equals(before, after1);
        wrapRight(3, 2, before);
        boolean success2 = Arrays.equals(before, after2);
        System.out.println("Test 1: " + success1 + ", Test 2: " + success2);
        //////////////////////////////////////////////////////////////////////
        

        // Question 8
        // Complete the function allRotations() function below. Here is a test:
        ArrayList<String> tlist = new ArrayList<>(List.of("abcd", "dabc", "cdab", "bcda"));
        ArrayList<String> slist = allRotations("abcd");
        boolean success3 = slist.equals(tlist);
        System.out.println("Rotate List Good: " + success3);
        //////////////////////////////////////////////////////////////////////

        // Question 9
        // Write the isPerfect() function below. Here are some tests:
        boolean b6 = isPerfect(6);
        if(b6 == true) System.out.println("Good Answer for 6");
        boolean b10 = isPerfect(10);
        if(b10 == false) System.out.println("Good Answer for 10");
        boolean b28 = isPerfect(28);
        if(b28 == true) System.out.println("Good Answer for 28");
        boolean b30 = isPerfect(30);
        if(b30 == false) System.out.println("Good Answer for 30");
        //////////////////////////////////////////////////////////////////////


        // Question 10
        // Write the flamingo() function below. Here are some tests:
        System.out.println("This number should be 10: " + flamingo(5, 2));
        System.out.println("This number should be 1: " + flamingo(5, 5));
        System.out.println("This number should be 20: " + flamingo(6, 3));
        System.out.println("This number should be 56: " + flamingo(8, 5));
    }




    static ArrayList<Integer> addOne(ArrayList<Integer> l){
        // Your work here
        ArrayList<Integer> plusOne = new ArrayList<>(); // Create an array list of integers called plusOne
        for(int q : l){                                 // Loop through elements of passed ArrayList l
            plusOne.add(q+1);                           // Adds 1 to the element q of l and adds it to the arraylist
        }
        // Replace the line below with a proper return statement
        return plusOne;        // Returns the new array list that was created
    }

    // This function is designed to allow the user to input his or her age.
    // The age must be in the allowable range, which means at least 18, 
    // but less than or equal to the upperLimit, which is a function parameter.
    // Keep looping until the user inputs a valid number. You may assume that the
    // user enters only nice, positive whole numbers.
    //
    // Please instantiate a Scanner object inside your function.
    static int readUntilGood(int upperLimit){
        // Your work here.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your age: "); // This prompts the user to enter thier age
        int age = scanner.nextInt();                     // Reads the next integer input by the user
        if(age >= 18 && age <= upperLimit){              // Checks if the age is in the valid range
            System.out.println("Access Granted! Valid age submitted!"); 
            return age;                                 // Returns the users age
        }
        System.out.println("Acsess Denied! Invalid Age! \nPlease try again...");  // The age submited did not pass the check
        return readUntilGood(upperLimit);                                            // Therefore call the meathod again.
    }

    // This function should operate by side effects.
    // w and h are the width and height of a board of chars
    // board[] consists of w*h characters, thought of as a wxh board.
    // The function should rotate each row one character to the right,
    // with the rightmost character wrapping to the leftmost position.
    // So:  1 2 3        3 1 2
    //      4 5 6   -->  6 4 5
    static void wrapRight(int h, int w, char[] board){
        // Your work here
        char[] nb = new char[(h*w)];
        int row = 0;
        for(int i = 0; i < w*h; i++){
            if((i+1)%w == 0){
                nb[w*row] = board[i];
                row++;
            }
            else nb[i+1] = board[i];
        }
        System.out.println(nb);
        before = nb;
    }

    // This function takes a string as input, and produces an ArrayList<String>  of
    // all rotations of the string. For example, if the string is "abcd" then 
    // it should create an ArrayList with these four strings, in this order: \
    // ["abcd", "dabc", "cdab", "bcda"]
    static ArrayList<String> allRotations(String s){
        // Your work here
        
        // Replace the line below with a proper return statement
        return new ArrayList<>();
    }


    // This function adds together all of the divisors of n (except for n itself)
    // and returns true if the sum is exactly n.
    // Such a number is called a "perfect" number.
    static boolean isPerfect(int n){
        // Your work here
        int total = 0;   // Total variable to add all divisors of n
        for(int a = 1; a < n; a++){  // Loop through all the integers where 0 < a > n
            if(n%a == 0){      // Check to see if a is a divisor of n
                total += a;    // Adds a to the total
            }
        }
        // Replace the line below so that it returns the right answer
        if(total == n) return true;   // Checks if the sum of the divisors is equal to n and returns true if it does
        return false;
    }


    // The flamingo function satisfies these rules:
    // flamingo(x, 0) = 1 for all x >= 0
    // flamingo(x, x) = 1 for all x >= 0
    // flamingo(a, b) = flamingo(a-1, b) + flamingo(a, b-1) in other cases, as long as a >= b
    // Write the flamingo function. I suggest using recursion, with two base cases.
    static int flamingo(int a, int b){
        // Your work here
        if(a >= 0 &&  b == 0) return 1;
        if(a == b && a >= 0) return 1;
        // Replace the line below so that it returns the right answer
        if(a >= b) return flamingo(a-1, b) + flamingo(a, b-1);
        return -1; //error happened
    }

}
