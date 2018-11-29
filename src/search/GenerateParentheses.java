package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeller
 * @Link <a href=" https://leetcode.com/problems/generate-parentheses/"> </a>
 * @Description
 * @Date 2018/11/26
 **/
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> results = generateParenthesis(3);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generateOneByOne("", results, n, n);
        return results;
    }

    public static void generateOneByOne(String sublist, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sublist);
            return;
        }
        if (left > 0) {
            generateOneByOne(sublist + "(", result, left - 1, right);
        }
        if (right > left) {
            generateOneByOne(sublist + ")", result, left, right - 1);
        }
    }


}
