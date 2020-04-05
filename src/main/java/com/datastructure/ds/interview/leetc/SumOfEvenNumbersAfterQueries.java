package com.datastructure.ds.interview.leetc;

// TC: O(N + Q), where N is the length of A and Q is the number of queries
// SC: O(1)
public class SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;

        for (int n : A) {
            if (n % 2 == 0) {
                sum += n;
            }
        }

        int[] res = new int[A.length];

        for (int i = 0; i < res.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];

            if (A[index] % 2 == 0) sum -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) sum += A[index];
            res[i] = sum;
        }

        return res;
    }
}
