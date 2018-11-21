package map_set;

import utils.Log;
import utils.MethodTimeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zeller
 * @Link <a href="https://leetcode.com/problems/3sum/description/">3Sum</a>
 * @Description
 * @Date 2018/11/21
 **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] inputs = {-1, 0, 1, 2, -1, -4};

        MethodTimeUtils.getInstance().start();
        List<List<Integer>> results = threeSum(inputs);
        MethodTimeUtils.getInstance().end();

    }

    public static List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);
        List<List<Integer>> results = new LinkedList<>();

        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        results.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return results;
    }

}
