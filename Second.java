// For testing the First class

class Second
{
    public static void main(String[] arguments)
    {
	System.out.println("In Second");
	First f = new First();
	f.upperLimit = 50;
	f.printPrimesUpTo();
    }
}
