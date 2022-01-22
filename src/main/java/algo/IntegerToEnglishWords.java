package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {
    /**
     * Time complexity: O(32) = O(1)
     * Space complexity: O(1) not counting space for result
     */
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        Map<String, String> tens = new HashMap<>();
        tens.put("2", "Twenty");
        tens.put("3", "Thirty");
        tens.put("4", "Forty");
        tens.put("5", "Fifty");
        tens.put("6", "Sixty");
        tens.put("7", "Seventy");
        tens.put("8", "Eighty");
        tens.put("9", "Ninety");
        tens.put("10", "Ten");
        tens.put("11", "Eleven");
        tens.put("12", "Twelve");
        tens.put("13", "Thirteen");
        tens.put("14", "Fourteen");
        tens.put("15", "Fifteen");
        tens.put("16", "Sixteen");
        tens.put("17", "Seventeen");
        tens.put("18", "Eighteen");
        tens.put("19", "Nineteen");

        Map<Character, String> ones = new HashMap<>();
        ones.put('1', "One");
        ones.put('2', "Two");
        ones.put('3', "Three");
        ones.put('4', "Four");
        ones.put('5', "Five");
        ones.put('6', "Six");
        ones.put('7', "Seven");
        ones.put('8', "Eight");
        ones.put('9', "Nine");

        String[] factor = new String[4];
        factor[0] = "";
        factor[1] = "Thousand";
        factor[2] = "Million";
        factor[3] = "Billion";

        int currentFactor = 0;

        String s = String.valueOf(num);
        List<String> buffer = new ArrayList<>();    // reversed

        // 1,234
        for (int j = 0; j < s.length(); j++) {
            // 4-0-1=3
            // 4-1-1=2
            // 4-2-1=1
            // 4-3-1=0
            int i = s.length() - j - 1;

            // 0%3=0 1%3=1 2%3=2 3%3=0
            if (j % 3 == 0) {
                // last 2 digits

                if (currentFactor > 0) {
                    if (i < 3 || (s.charAt(i) != '0' || s.charAt(i - 1) != '0' || s.charAt(i - 2) != '0')) {
                        buffer.add(factor[currentFactor]); // four thirty hundred two thousand
                    }
                }

                // 3-1>=0?  0-1>=0?
                if (i - 1 >= 0) {
                    // check tens
                    String s1 = String.valueOf(s.charAt(i));        // 4
                    String s2 = String.valueOf(s.charAt(i - 1));    // 3
                    // s2s1
                    // 01


                    if (tens.containsKey(s2)) { // 2->Twenty
                        if (s.charAt(i) != '0') buffer.add(ones.get(s.charAt(i)));  // four
                        buffer.add(tens.get(s2));           // four thirty
                    } else if (tens.containsKey(s2 + s1)) {
                        buffer.add(tens.get(s2 + s1));
                    } else if (s.charAt(i) != '0') {
                        buffer.add(ones.get(s.charAt(i)));
                    }
                } else {
                    // check ones
                    buffer.add(ones.get(s.charAt(i))); // four thirty hundred two thousand one
                }
            } else if (j % 3 == 2) {
                // first digit out of group of 3
                if (s.charAt(i) != '0') {
                    buffer.add("Hundred");  // four thirty hundred
                    buffer.add(ones.get(s.charAt(i))); // four thirty hundred two
                }
                currentFactor++;    // 1
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String i : buffer) {
            sb.insert(0, i);    // four     thirty_four
            sb.insert(0, " ");  // _four    _thirty_four
        }

        sb.deleteCharAt(0);

        return sb.toString();
    }
}
