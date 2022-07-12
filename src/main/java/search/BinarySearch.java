package search;

import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangkai
 * @Date: 2022/2/17 17:40
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={50,50,52,67,70,80,90};
        List list=search2(arr,0,arr.length-1,50);
        System.out.println(list);
        System.out.println(search(arr,0,arr.length-1,90));


    }
    public static int search(int[] arr,int left,int right,int value){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(value>midVal){
            return search(arr,mid+1,right,value);
        }else if(value<midVal){
            return search(arr,left,mid-1,value);
        }else {
            System.out.println("this is rock!");
            return mid;
        }
    }

    public static ArrayList<Integer> search2(int[] arr, int left, int right, int value){
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(value>midVal){
            return search2(arr,mid+1,right,value);
        }else if(value<midVal){
            return search2(arr,left,mid-1,value);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp=mid-1;
            while (true){
                if(temp<0 || arr[temp]!=value){
                    break;
                }
                list.add(temp);
                temp-=1;
            }
            list.add(mid);
            temp=mid+1;
            while (true){
                if(temp>arr.length-1 || arr[temp]!=value){
                    break;
                }
                list.add(temp);
                temp+=1;
            }
            return list;
        }
    }
}
