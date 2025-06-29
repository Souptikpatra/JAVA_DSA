package CLASSOFJAVA;


import java.util.Scanner;
public class oddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("give a number: ");
        int a = sc.nextInt();
        if(a % 2 == 0){
            System.out.println("its even");
        }
        else {
            System.out.println("its odd");
        }


    }
}
