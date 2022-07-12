package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/22 11:08
 */
public class mergeArr {
    public static void main(String[] args) {
        int[] nums1=new int[]{1,2,3,0,0,0};
        int[] nums2=new int[]{2,5,6};
        new mergeArr().merge(nums1,3,nums2,3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m;
        for (int i = 0; i < n; i++) {
            nums1[index]=nums2[i];
            ++index;
        }
        int temp=0;
        boolean flag=false;
        for (int i = 0; i < nums1.length-1; i++) {
            for (int j = 0; j < nums1.length-1-i; j++) {
                if(nums1[j]>nums1[j+1]){
                    flag=true;
                    temp=nums1[j];
                    nums1[j]=nums1[j+1];
                    nums1[j+1]=temp;
                }
            }
            if(flag==false){
                break;
            }
        }
    }
}
