package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yangkai
 * @Date: 2022/2/17 16:20
 */
public class Radix {
    public static void main(String[] args) {
        //int[] arr={23,10,234,167,198,34,56};
        int[] arr=new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=format.format(date);
        System.out.println(dateString);
        radixSort(arr);
        Date date1=new Date();
        String dateString1=format.format(date1);
        System.out.println(dateString1);
        //System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr){
        //定义一个二维数组，里面每一个一维数组代表一个桶
        int[][] bucket=new int[10][arr.length];
        //定义一个一维数组，用于记录每次放入一维数组的个数
        int[] bucketCount=new int[10] ;
        //先得到数组中最大位数
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {

            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength=(max+"").length();

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int digit=arr[j]/n%10;
                bucket[digit][bucketCount[digit]]=arr[j];
                bucketCount[digit]++;
            }
            int index=0;
            //遍历每个桶，并放入数组
            for (int k = 0; k < bucketCount.length; k++) {
                if(bucketCount[k]!=0){
                    for (int l = 0; l < bucketCount[k]; l++) {
                        arr[index]=bucket[k][l];
                        index++;
                    }
                }
                bucketCount[k]=0;
            }
        }

        //第一轮
//        for (int j = 0; j < arr.length; j++) {
//            int digit=arr[j]%10;
//            bucket[digit][bucketCount[digit]]=arr[j];
//            bucketCount[digit]++;
//        }
//        int index=0;
//        //遍历每个桶，并放入数组
//        for (int k = 0; k < bucketCount.length; k++) {
//            if(bucketCount[k]!=0){
//                for (int l = 0; l < bucketCount[k]; l++) {
//                    arr[index]=bucket[k][l];
//                    index++;
//                }
//            }
//            bucketCount[k]=0;
//        }
//
//        //第二轮
//        for (int j = 0; j < arr.length; j++) {
//            int digit=arr[j]/10%10;
//            bucket[digit][bucketCount[digit]]=arr[j];
//            bucketCount[digit]++;
//        }
//        index=0;
//        //遍历每个桶，并放入数组
//        for (int k = 0; k < bucketCount.length; k++) {
//            if(bucketCount[k]!=0){
//                for (int l = 0; l < bucketCount[k]; l++) {
//                    arr[index]=bucket[k][l];
//                    index++;
//                }
//            }
//            bucketCount[k]=0;
//        }
//
//        //第三轮
//        for (int j = 0; j < arr.length; j++) {
//            int digit=arr[j]/100%10;
//            bucket[digit][bucketCount[digit]]=arr[j];
//            bucketCount[digit]++;
//        }
//        index=0;
//        //遍历每个桶，并放入数组
//        for (int k = 0; k < bucketCount.length; k++) {
//            if(bucketCount[k]!=0){
//                for (int l = 0; l < bucketCount[k]; l++) {
//                    arr[index]=bucket[k][l];
//                    index++;
//                }
//            }
//            bucketCount[k]=0;
//        }
    }
}
