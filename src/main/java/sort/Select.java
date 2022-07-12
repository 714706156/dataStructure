package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yangkai
 * @Date: 2022/2/16 15:29
 */
public class Select {

    public static void main(String[] args) {
        int[] array=new int[8];
        for (int i = 0; i < 8; i++) {
            array[i]=(int)(Math.random()*8000000);
        }
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=format.format(date);
        System.out.println(date);
        selectSort(array);
        Date date1=new Date();
        String dateString1=format.format(date1);
        System.out.println(date1);
        System.out.println(Arrays.toString(array));
    }
    public static void selectSort(int[] arr){
        int minIndex=0;
        int min=arr[minIndex];
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            arr[minIndex]=arr[i];
            arr[i]=min;
            minIndex=i+1;
            min=arr[minIndex];
        }

    }
}
