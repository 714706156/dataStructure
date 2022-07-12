package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * @Author: yangkai
 * @Date: 2022/2/16 14:24
 */
public class Bubble {
    public static void main(String[] args) {
        //int array[]= {10,4,0,18,-12,3,2,1};
        int[] array=new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i]=(int)(Math.random()*8000000);
        }
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=format.format(date);
        System.out.println(date);
        bubbleSort(array);
        Date date1=new Date();
        String dateString1=format.format(date1);
        System.out.println(date1);
    }
    public static void bubbleSort(int[] array){
        int temp=0;
        boolean flag=false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    flag=true;
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if(flag==false){
                break;
            }
        }
    }
}
