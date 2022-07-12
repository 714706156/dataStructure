package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangkai
 * @Date: 2022/6/13 15:15
 */
public class mergeLists {
    public List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> list0=new ArrayList<>();
        list0.addAll(list1);
        list0.addAll(list2);
        Integer[] array=list0.toArray(new Integer[list0.size()]);
        List<Integer> list=new ArrayList<>();
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
        list= Arrays.asList(array);
        return list;
    }

    public static void main(String[] args) {
        Integer[] arr1=new Integer[]{2,5,4};
        Integer[] arr2=new Integer[]{3,5,9};
        List<Integer> list1= Arrays.asList(arr1);
        List<Integer> list2= Arrays.asList(arr2);
        System.out.println(new mergeLists().mergeTwoLists(list1,list2));
        int k=list1.size();
        assert k==1;
    }
}
