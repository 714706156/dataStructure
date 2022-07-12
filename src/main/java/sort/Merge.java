package sort;

import java.util.Arrays;

/**
 * @Author: yangkai
 * @Date: 2022/2/17 15:08
 */
public class Merge {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,6,1,3,2};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+合的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);

        }
    }
    //合并的方法
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//左边有序数组的初始索引
        int j=mid+1;//右边有序数组的初始索引
        int t=0;//新数组的索引
        //把左右两边的数组按照规则填充到temp数组，知道有一边处理完毕
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else {
                temp[t]=arr[j];
                j+=1;
                t+=1;
            }
        }
        //如果左边的数组还有元素，则依次填入temp数组
        while (i<=mid){
            temp[t]=arr[i];
            i+=1;
            t+=1;
        }
        while (j<=right){
            temp[t]=arr[j];
            j+=1;
            t+=1;
        }
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            tempLeft+=1;
            t+=1;
        }

    }

}
