import java.util.*;

public class RandomPassGen {

    public static void main(String[] args) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = "@#%$^&*(_)!~/-+|{[}]";
        String num = "0123456789";

        String combination = upper + lower + specialChars + num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of required Password : ");
        int len = sc.nextInt();
        if (len <= 20) {
            char[] password = new char[len];
            Random r = new Random();
            for (int i = 0; i < len; i++) {
                password[i] = combination.charAt(r.nextInt(combination.length()));
            }
            System.out.println("Generated Password is: " + new String(password));
        } else {
            System.out.println("Ideal Length of a Password is upto 20 chars...Please enter correct Length!!");
        }

    }
}