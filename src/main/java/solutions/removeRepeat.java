package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/13 17:40
 */
public class removeRepeat {
    public int removeElement(int[] nums, int val) {
        int m=0;
        int n=-1;
        int len=nums.length;
        while (m<len){
            if(nums[m]!=val){
                ++n;
                nums[n]=nums[m];
                if(m!=n){
                    nums[m]=val;
                }
                ++m;
            }else {
                ++m;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return n+1;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,2,2,3,0,4,2};
        System.out.println(new removeRepeat().removeElement(arr,2));
    }
}
