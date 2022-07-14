package search;

/**
 * @Author: yangkai
 * @Date: 2022/7/14 14:40
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr={1,3,5,77,405,1009};
        int index=binarySearch(arr,3);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
}
