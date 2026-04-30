class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = (m*n)-1;
        while(start<=end){
            int [] mid = new int[2];
            int temp = (start+end)/2;
            mid[0] = temp/n;
            mid[1] = temp%n;
            if(matrix[mid[0]][mid[1]]==target)
                return true;
            else if(matrix[mid[0]][mid[1]]>target)
                end = temp-1;
            else
                start = temp+1;
        }
        return false;
    }
}
