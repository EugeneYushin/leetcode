package google;

import java.util.*;


public class LongestStingChain {
    public int longestStrChain(String[] words) {
        Set<String> distinctWords = new HashSet<>();
        Collections.addAll(distinctWords, words);
        Map<String, List<String>> dp = new HashMap<>();

        List<String> chain = new LinkedList<>();

        for (String word : words) {
            List<String> currChain = dfs(word, distinctWords, dp);
            if (chain.size() < currChain.size()) {
                chain = currChain;
            }
        }

        System.out.println("---------------");
        chain.forEach(System.out::println);

        return chain.size();
    }

    private List<String> dfs(String word, Set<String> words, Map<String, List<String>> dp) {
        if (dp.containsKey(word)) return dp.get(word);

        StringBuilder wordBuilder = new StringBuilder(word);
        List<String> maxChain = new LinkedList<>();
        maxChain.add(word);

        for (int i = 0; i < word.length(); i++) {
            String newWord = wordBuilder.deleteCharAt(i).toString();
            if (words.contains(newWord)) {
                List<String> currentChain = new LinkedList<>(dfs(newWord, words, dp));
                currentChain.add(word);
                if (maxChain.size() < currentChain.size()) {
                    maxChain = currentChain;
                }
            }
            wordBuilder.insert(i, word.charAt(i));
        }

        dp.put(word, maxChain);

        return maxChain;
    }
}
