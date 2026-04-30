class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            while(numbers[j]>target-numbers[i]){
                j--;
            }
            while(numbers[i]<target-numbers[j]){
                i++;
            }
            if(numbers[j]==target-numbers[i])
                return new int[]{i+1,j+1};  
        }
        return new int[]{};
    }
}
