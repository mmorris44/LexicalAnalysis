import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter your regex: ");
        Scanner scanner = new Scanner(System.in);
        String regexString = scanner.nextLine();
        RegularExpression re = new RegularExpression(regexString);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                System.out.println(re.match(line.charAt(0)));
            } catch (UnsimplifiedRegexException e) {
                System.out.println("Regular expression '" + re.re + "' not simple");
            }
        }
    }

}
