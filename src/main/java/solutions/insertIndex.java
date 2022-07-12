package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/14 11:01
 */
public class insertIndex {
    public int searchInsert(int[] nums, int target) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>target || nums[i]==target){
                index=i;
                break;
            }else {
                index=nums.length;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,2,4,6,7};
        System.out.println(new insertIndex().searchInsert(nums,-2));
    }
}
