package sort;

import java.util.Arrays;

/**
 * @Author: yangkai
 * @Date: 2022/7/14 10:56
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={-9,78,0,23,-567,70};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int pivot=arr[(right-left)/2];
        int temp=0;
        while (l<r){
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            //当满足l>=r时，数组已经达到了中间值左边的都比它小，右边的都比它大
            if(l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //如果交换完成后，发现左边的值arr[l]和pivot相等，那么右边的前移
            if(arr[l]==pivot){
                r-=1;
            }
            //如果交换完成后，发现右边的值arr[r]和pivot相等，那么左边的后移
            if(arr[r]==pivot){
                l+=1;
            }
        }
        if(l==r){
            l+=1;
            r-=1;
        }
        if(left<r){
            sort(arr,left,r);
        }
        if(right>l){
                   sort(arr,l,right);
        }
    }
}
