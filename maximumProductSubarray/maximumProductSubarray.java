package maximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int product = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                min = Math.min(nums[i], nums[i]*min);
                max = Math.max(nums[i], nums[i]*max);
            }
            else {
                int temp = min;
                min = Math.min(nums[i], nums[i]*max);
                max = Math.max(nums[i], nums[i]*temp);
            }
            product = Math.max(max, product);
        }
        return product;
    }
}