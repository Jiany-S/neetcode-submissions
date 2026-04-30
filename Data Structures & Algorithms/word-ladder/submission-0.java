class Solution {
    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        dfs(beginWord, endWord, wordList, new HashSet<>(), 1);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    void dfs(String word, String endWord, List<String> words, Set<String> visited, int depth) {
        if (word.equals(endWord)) {
            min = Math.min(min, depth);
            return;
        }

        for (String next : words) {
            if (!visited.contains(next) && oneDiff(word, next)) {
                visited.add(next);
                dfs(next, endWord, words, visited, depth + 1);
                visited.remove(next);
            }
        }
    }

    boolean oneDiff(String a, String b) {
        if (a.length() != b.length()) return false;
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
