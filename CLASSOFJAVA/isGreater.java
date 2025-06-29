package CLASSOFJAVA;

import java.util.Scanner;

public class isGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("give number 1: ");
        int a = sc.nextInt();
        System.out.println("give number 2: ");
        int b = sc.nextInt();
        if (a > b){
            System.out.println(a +" is greater");
        }
        else {
            System.out.println(b + "is greater");
        }


    }
}
