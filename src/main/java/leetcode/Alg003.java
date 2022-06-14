package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3.给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * @author hzzhou
 * @since 2021-11-12
 */
public class Alg003 {

    public static void main(String[] args) {
        Alg003 alg003 = new Alg003();
        System.out.println(alg003.lengthOfLongestSubstring("aabaabccdefgh"));
        System.out.println(alg003.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(alg003.lengthOfLongestSubstring("bbbbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int subLen = 0;
        if (s == null || s.length() == 0) {
            return subLen;
        }
        // 滑动窗口
        Set<Character> subStr = new HashSet<Character>();
        int n = s.length();
        // 右指针
        int right = -1;
        for (int left = 0; left < n; ++left) {
            if (left != 0) {
                // 左指针向右移动一格，移除一个字符
                subStr.remove(s.charAt(left - 1));
            }
            while (right + 1 < n && !subStr.contains(s.charAt(right + 1))) {
                // 不断地移动右指针
                subStr.add(s.charAt(right + 1));
                ++right;
            }
            // 第 i 到 right 个字符是一个极长的无重复字符子串
            subLen = Math.max(subLen, right - left + 1);
        }
        return subLen;
    }

}
