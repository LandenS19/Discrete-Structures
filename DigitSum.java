class DigitSum
{
    public static void main(String[] args)
    {
        for(int i = 1; i <= 100; i++)
	    {
		if(sumOfDigits(i) == 11)
		    {
			System.out.print(i + " ");
		    }
	    }
	System.out.println("");
    }

    static int sumOfDigits(int n)
    {
	int rv = 0;
	while(n > 0)
	    {
		rv += n%10;
		n /= 10;
	    }
	return rv;
    }
}
