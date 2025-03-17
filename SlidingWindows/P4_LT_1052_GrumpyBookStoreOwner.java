package SlidingWindows;
public class P4_LT_1052_GrumpyBookStoreOwner {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unsatisfiedCount = 0;
        int maxUnsatisfied = 0;
        int mark = -1;
        int finalSatisfied = 0;

        // setting window of ('minutes' size)
        int a = 0;  // a --> front of window
        int b = minutes-1;  // b --> rear of window

        // for 1st window, manually calculate (unsatisfied count)
        for (int i = a; i <= b; i++) {
            unsatisfiedCount += (grumpy[i] * customers[i]);
        }
        maxUnsatisfied = unsatisfiedCount;
        mark = a;

        // sliding windows
        while(b < n-1){
            a++;b++;

            // calculate new unsatisfied count.
            int prev = (grumpy[a-1] * customers[a-1]);
            int next =(grumpy[b] * customers[b]);
            unsatisfiedCount = unsatisfiedCount - prev + next;

            // if unsatisfiedCount > maxUnsatisfied  --> then mark ; update maxUnsatisfied ;
            if (unsatisfiedCount > maxUnsatisfied) {
                mark = a;
                maxUnsatisfied = unsatisfiedCount;
            }
        }

        // make (calm) at marked one
        int temp = mark;
        for (int i = 0; i < minutes; i++) {
            grumpy[temp] = 0;
            temp++;
        }

        // The maximum number of customers that can be satisfied
        for (int i = 0; i < n; i++) { // traverse the whole array
            if (grumpy[i] == 0) finalSatisfied += customers[i];
        }

        return finalSatisfied;
    }

    public static void main(String[] args) {
        int [] customer = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        System.out.println(maxSatisfied(customer,grumpy,3));
    }
}
