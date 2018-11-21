package map_set;

import utils.Log;
import utils.MethodTimeUtils;

import java.util.*;

/**
 * @author Zeller
 * @Link <a href="https://leetcode.com/problems/3sum/description/">3Sum</a>
 * @Description
 * @Date 2018/11/21
 **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] inputs = {-1, 0, 1, 2, -1, -4, -2, 10, 3, -12, 41, 54135, 13321, 41, -431, -321, 321, -432, 452, 421, -532, -559, 3432};

        MethodTimeUtils.getInstance().start();
        List<List<Integer>> results = threeSumWithoutHash(inputs);
        MethodTimeUtils.getInstance().end();
        showResult(results);
    }

    private static void showResult(List<List<Integer>> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println("{ ");
            List<Integer> list = results.get(i);
            System.out.println("{" + list.get(0) + "," + list.get(1) + "," + list.get(2) + "}");
            System.out.println(" }");
        }
    }

    public static List<List<Integer>> threeSumWithoutHash(int[] num) {
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

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> firstNum = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (!firstNum.contains(nums[i])) {
                int sum = -nums[i];
                Set<Integer> secondNum = new HashSet<>();
                Set<Integer> thirdNum = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++) {
                    if (!firstNum.contains(nums[j]) && !thirdNum.contains(nums[j])) {
                        if (secondNum.contains(sum - nums[j])) {
                            res.add(Arrays.asList(nums[i], nums[j], sum - nums[j]));
                            thirdNum.add(nums[j]);
                        } else {
                            secondNum.add(nums[j]);
                        }
                    }
                }
                firstNum.add(nums[i]);
            }
        }
        return res;
    }

}
