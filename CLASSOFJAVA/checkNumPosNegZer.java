package CLASSOFJAVA;
import java.util.Scanner;
public class checkNumPosNegZer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("give a number: ");
        int a = sc.nextInt();
        if (a > 0) {
            System.out.println("its +ve");
        }
        else if (a < 0) {
            System.out.println("its -ve");
        }
        else {
            System.out.println("its 0");
        }


    }
}
