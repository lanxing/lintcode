package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaofan
 * @version 1.0
 * @date 2018/5/9 下午5:45
 * @desc https://www.lintcode.com/problem/range-sum-query-immutable/description
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class LintCode943 {

    private int[] arrs;

    public LintCode943(int[] nums) {
        arrs = nums;
    }

    private int fun(int[] arr, int i, int j){
        if (i == j){
            return arr[i];
        }
        if (i > j){
            return 0;
        }

        int m = (i + j) / 2;
        return fun(arr, i, m) + fun(arr, m + 1, j);
    }

    public int sumRange(int i, int j) {
        return fun(arrs, i, j);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        LintCode943 lintCode943 = new LintCode943(arr);
        System.out.println(lintCode943.sumRange(2, 3));
    }

}
