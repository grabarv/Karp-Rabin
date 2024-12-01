import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();
        System.out.println("Enter pattern:");
        String pattern = scanner.nextLine();
        KarpRabin matcher = new KarpRabin(text, pattern, 3, 10000);
        matcher.findMatches();
    }


}