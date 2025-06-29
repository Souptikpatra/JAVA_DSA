package CLASSOFJAVA;

import java.util.Scanner;

public class fact {
    public static void main(String[] args) {
        int n = 7;
        int prdct = 1;
        for (int i = n; i >= 1; i--) {
            prdct = prdct * i;
        }
        System.out.println(prdct);
    }
}
