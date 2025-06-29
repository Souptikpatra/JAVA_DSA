package CLASSOFJAVA;

import java.awt.*;
import java.util.Scanner;

public class multiplicationTable {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("give a number: ");
//        int n = sc.nextInt();
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(n + " * " + i + " = "+ (n*i));
//
//        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt ( ) ;
        for (int i = n; i <= (n*10); i +=n ) {
            System.out.println(i);
        }

    }
}
