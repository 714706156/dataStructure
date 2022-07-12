package solutions;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangkai
 * @Date: 2022/6/13 16:48
 */
public class removeDup {
    public int removeDuplicates(int[] nums) {
//        int k=1;
//        int num=nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if(num==nums[i]){
//                nums[i]=20000;
//            }else {
//                num=nums[i];
//                k+=1;
//            }
//        }
//        return k;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        ;
        System.out.println(new removeDup().removeDuplicates(nums));
    }
}
