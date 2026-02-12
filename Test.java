public class Test {
    
    public static void main(String[] args) {
        int X = (int)(10 * Math.random()) + 1;
        boolean guess = false;
        while(!guess)
        {
            System.out.print("Guess a number between 1 and 10: ");
            int guessNumber = Integer.parseInt(System.console().readLine());
            if (X == guessNumber) {
            System.out.println("You guessed correctly! \nThe number was " +  X + "!");
            guess = true;
            } 
            if(X < guessNumber) {
                System.out.println("Incorrect! Your guess was too high, try again. ");
            }
            if(X > guessNumber) {
                System.out.println("Incorrect! Your guess was too low, try again. ");
            }
        }
        
    }


}
