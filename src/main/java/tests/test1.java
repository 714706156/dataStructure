package tests;

import java.util.Arrays;

/**
 * @Author: yangkai
 * @Date: 2022/2/22 16:51
 */
public class test1 {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(array,5)));
    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        int temp=0;
        for (int i = 0; i < nums.length-1; i++) {
            temp=i+1;
            while (temp<nums.length){
                if(nums[i]+nums[temp]==target){
                    res[0]=i;
                    res[1]=temp;
                }
                temp++;
            }

        }
        return res;


    }
}
