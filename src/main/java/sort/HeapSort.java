package sort;

import java.util.Arrays;

/**
 * @Author: yangkai
 * @Date: 2022/7/13 17:37
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr={4,6,8,5,9};
        sort(arr);
    }
    public static void sort(int[] arr){
        System.out.println("堆排序！");
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        for(int j=arr.length-1;j>0;j--){
            int temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }
    //将数组调整成大顶堆,i表示飞叶子节点在数组中的索引，length表示对多少个元素继续调整
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];
        for(int k=i*2+1;k<length;k=2*k+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else {break;}
        }
        arr[i]=temp;
    }
}
