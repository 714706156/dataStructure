package sort;

import java.util.Arrays;

/**
 * @Author: yangkai
 * @Date: 2022/2/16 17:05
 */
public class Shell {
    public static void main(String[] args) {
        int arr[]={10,22,12,4,5,-10,0,8,30,20};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){
        int temp=0;
//        for (int gap = arr.length/2; gap >0 ; gap/=2) {
//            for (int i = gap; i < arr.length; i++) {
//                for (int j = i-gap; j >=0; j-=gap) {
//                    if(arr[j]>arr[j+gap]){
//                        temp=arr[j];
//                        arr[j]=arr[j+gap];
//                        arr[j+gap]=temp;
//                    }
//                }
//            }
//        }
        for (int i = 5; i < arr.length; i++) {
            for (int j = i-5; j >=0; j-=5) {
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 2; i < arr.length; i++) {
            for (int j = i-2; j >=0; j-=2) {
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0; j-=1) {
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort2(int[] arr){
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
    }

}
