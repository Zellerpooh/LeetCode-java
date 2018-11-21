package map_set;

import utils.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zeller
 * @Link <a href="https://leetcode.com/problems/two-sum/description/">两数之和</a>
 * @Description
 * @Date 2018/11/21
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] inputs = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(inputs, target);
        Log.d("TwoSum", result[0] + " " + result[1]);
    }

    /**
     * 用Map已经遍历过的数字
     * O(N)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }
}
