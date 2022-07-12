package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/14 15:27
 */
public class arrMax {
    public static void main(String[] args) {
        int[] nums=new int[]{5,4,-1,7,8};
        System.out.println(new arrMax().maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int max=-10000;
        int k=0;
        int max2=-10000;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp+=nums[i];


            k=i;
            while (k<nums.length){
                temp+=nums[k];
                if(temp>max2){
                    max2=temp;
                }
                k+=1;
            }
            temp=0;
            if(max2>max){
                max=max2;
            }
        }
        return max;
    }
}
