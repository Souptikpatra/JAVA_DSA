package CLASSOFJAVA;

import java.util.Scanner;

public class ageValidate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("give a age: ");
        byte a = sc.nextByte();
        if (a >= 18){
            System.out.println("you are valid to vote");
        }
        else {
            System.out.println("you are not valid to vote");
        }


    }
}
