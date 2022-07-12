package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: yangkai
 * @Date: 2022/2/16 16:14
 */
public class Insert {
    public static void main(String[] args) {
        int[] array=new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i]=(int)(Math.random()*8000000);
        }
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=format.format(date);
        System.out.println(date);
        insertSort(array);
        Date date1=new Date();
        String dateString1=format.format(date1);
        System.out.println(date1);

//        int[] arr={10,22,12,4,5,-10,0};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertIndex=i-1;
            int insertVal=arr[i];
            while (insertIndex>=0 && arr[insertIndex]>insertVal){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
        }

    }
}
