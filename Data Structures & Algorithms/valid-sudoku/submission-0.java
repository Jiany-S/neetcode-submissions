class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Integer>> rowmap = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> colmap = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> boxmap = new HashMap<>();
        int box;
        int number;
        for (int r = 0; r < 9; r++) rowmap.put(r, new HashSet<>());
        for (int c = 0; c < 9; c++) colmap.put(c, new HashSet<>());
        for (int b = 0; b < 9; b++) boxmap.put(b, new HashSet<>());
        for(int row = 0; row<9;row++){
            for(int col = 0; col<9; col++){
                if(board[row][col]=='.')
                    continue;
                else
                    number = board[row][col]-'0';
                box=(row/3)*3+(col/3);
                if(rowmap.get(row).contains(number)||colmap.get(col).contains(number)||boxmap.get(box).contains(number))
                    return false;
                rowmap.get(row).add(number);
                colmap.get(col).add(number);
                boxmap.get(box).add(number);
            }
        }
        return true;
    }
}
