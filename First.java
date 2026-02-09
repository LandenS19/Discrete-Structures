// Every program must be in a class
// the class name must be == to file name
// By convention, classes are initial-caps

class First
{
     int upperLimit;
    
    // The entry point (first function called) for all programs is main
    /*public static void main(String[] args)
    {
	
	System.out.println("Welcome to the class!");
	upperLimit = 200;

	printPrimesUpTo();

	}*/

    // void return type means we operate solely by side-effects
    // No return value.
    void printPrimesUpTo()
    {
	System.out.println("Here are the primes up to ".toUpperCase() + upperLimit);
	for(int i = 0; i <= upperLimit; i++)
	    {
		if(isPrime(i))
		    {
			System.out.print(i + " ");
		    }
	    }
    }
    
    // Return true if x is prime, otherwise false
    boolean isPrime(int x)
    {
	if(x<2) return false;
	for(int d = 2; d < x; d++)
	    {
		if(x % d == 0) return false;
	    }
	return true;
    }			   		
}
