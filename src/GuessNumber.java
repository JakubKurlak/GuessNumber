import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello, there.");
        Thread.sleep(1000);
        System.out.println("I'm lottery machine.");
        Thread.sleep(1000);
        System.out.println("What's your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Thread.sleep(500);
        System.out.println("Choose the range of numbers from which I will draw.");

        int BEGIN_RANGE = Integer.MAX_VALUE;
        int END_RANGE = Integer.MIN_VALUE;
        do {
            try {
                String line1 = scanner.next();
                BEGIN_RANGE = Integer.parseInt(line1);
                String line2 = scanner.next();
                END_RANGE = Integer.parseInt(line2);
                if (BEGIN_RANGE < END_RANGE) {
                    System.out.println("I will draw a number from " + BEGIN_RANGE + " to " + END_RANGE + ".");
                } else
                    System.err.println("The beginnig of range is bigger than the end of range.");
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid range.");
            }
        } while (BEGIN_RANGE > END_RANGE);

        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(500);
        System.out.println("...");
        Thread.sleep(500);
        System.out.println("...");
        Thread.sleep(500);

        Random random = new Random();
        int randomNumber = random.nextInt((END_RANGE - BEGIN_RANGE + 1) + BEGIN_RANGE);

        System.out.println("Your move.");
        Thread.sleep(1000);
        System.out.println("Guess the number.");

        int myNumber = Integer.MAX_VALUE;
        do {
            try {
                String line3 = scanner.next();
                myNumber = Integer.parseInt(line3);
                if (myNumber > END_RANGE) {
                    System.err.println("Roger, roger. \nYour number is out of the range.");
                } else if (myNumber < BEGIN_RANGE) {
                    System.err.println("Roger, roger. \nYour number is out of the range.");
                } else if (myNumber == randomNumber - 1) {
                    System.out.println("So close \nYour number is too small.");
                } else if (myNumber == randomNumber + 1) {
                    System.out.println("So close \nYour number is too big.");
                } else if (myNumber > randomNumber && myNumber < randomNumber + 10) {
                    System.out.println("Warm, warmer. \nYour number is too big.");
                } else if (myNumber < randomNumber && myNumber > randomNumber - 10) {
                    System.out.println("Warm, warmer. \nYour number is too small.");
                } else if (myNumber > randomNumber && myNumber >= randomNumber + 10) {
                    System.out.println("I don't think so. \nYour number is too big.");
                } else if (myNumber < randomNumber && myNumber <= randomNumber - 10) {
                    System.out.println("I don't think so. \nYour number is too small.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Write the number.");
            }
        } while (myNumber != randomNumber);
        System.out.println("Good " + name + ", good.");
        Thread.sleep(1000);
        System.out.println(myNumber + " it's my number.");
        Thread.sleep(1000);
        System.out.println("When we started the game you were a learner.");
        Thread.sleep(2000);
        System.out.println("Now you are a master.");
        Thread.sleep(5000);
    }
}
