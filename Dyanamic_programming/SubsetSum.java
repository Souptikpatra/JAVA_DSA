package Dyanamic_programming;
public class SubsetSum {
    // NON-memoized
//    public static boolean hasSubset(int currIndex,int[] arr, int target){
//        if (currIndex == arr.length) {
//            if(target == 0) return true;
//            else return false;
//        }
//        if (target == 0) return true;
//        boolean pick = false;
//        boolean skip = false;
//
//        int currElement = arr[currIndex];
//        if (currElement <= target) { // don't need to pick, if (currElement > target)
//             pick = hasSubset(currIndex + 1, arr, target - currElement); // pick that element
//        }
//        skip = hasSubset(currIndex+1,arr,target); // skip the element
//
//        return (pick || skip);
//    }

    //memoized
    public static boolean hasSubset(int currIndex,int[] arr, int target,int[][] memo){
        if (currIndex == arr.length) {
            if(target == 0) return true;
            else return false;
        }
        if (target == 0) return true;
        boolean pick = false;
        boolean skip = false;

        int currElement = arr[currIndex];
        if (currElement <= target) { // don't need to pick, if (currElement > target)
            // memo start
            boolean memoResult = false;
            // memo check
            if (memo[currIndex+1][target-currElement] != -1) { // in memo found
                if (memo[currIndex+1][target-currElement] == 1) memoResult = true;
                else memoResult = false;
            }
            else { // in memo not found
                memoResult = hasSubset(currIndex+1,arr,target-currElement,memo);
                // update memo
                memo[currIndex+1][target-currElement] = memoResult ? 1 : 0;
            }
            //memo end
            pick = memoResult; // pick that element
        }


        // memo start
        boolean memoResult = false;
        // memo check
        if (memo[currIndex+1][target] != -1) { // in memo found
            if (memo[currIndex+1][target] == 1) memoResult = true;
            else memoResult = false;
        }
        else { // in memo not found
            memoResult = hasSubset(currIndex+1,arr,target,memo);
            // update memo
            memo[currIndex+1][target] = memoResult ? 1 : 0;
        }
        //memo end

        skip = memoResult; // skip the element

        return (pick || skip);
    }
    public static void main(String[] args) {
        int[] arr =  {1, 2, 3};
        int target = 6;

        /*
        * varying part of recursion is -> 'currIndex' & 'target'
        * these two gets changed everytime on function call
        * so we need 2d memo array
        * each row represent --> 'currIndex'
        * each col represent --> 'target'
        * 'currIndex' changes from [0 --> (arr.length + 1)]
        * and 'target' changes from [target --> 0]
        * so our memo array, #of row = arr.length
        * and #of col = (target+1)
        *
        * in memo[][]   0 <-- false
        *               1 <-- true
        * */

        int[][] memo = new int[arr.length+1][target+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1; // fill entire array with (-1) --> it represent that call having value -1 is not updated.
            }
        }

        System.out.println(hasSubset(0,arr,target,memo));
    }
}
