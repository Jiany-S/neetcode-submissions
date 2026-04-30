class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            boolean found = false;
            for (int i = 0; i < board.length && !found; i++) {
                for (int j = 0; j < board[0].length && !found; j++) {
                    if (board[i][j] == s.charAt(0)) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if (search(s, 0, visited, board, i, j)) {
                            ans.add(s);
                            found = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    boolean search(String s, int ind, boolean[][] visited, char[][] board, int i, int j) {
        if (ind == s.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || visited[i][j] || board[i][j] != s.charAt(ind)) {
            return false;
        }

        visited[i][j] = true;
        boolean res = search(s, ind + 1, visited, board, i + 1, j)
                   || search(s, ind + 1, visited, board, i - 1, j)
                   || search(s, ind + 1, visited, board, i, j + 1)
                   || search(s, ind + 1, visited, board, i, j - 1);
        visited[i][j] = false;
        return res;
    }
}
