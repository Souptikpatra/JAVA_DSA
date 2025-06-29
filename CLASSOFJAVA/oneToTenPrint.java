package CLASSOFJAVA;
import java.util.Scanner;
public class oneToTenPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("give n: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n ; i++) {
            System.out.println(i);
        }
    }
}
