package search;

/**
 * @Author: yangkai
 * @Date: 2022/2/18 9:41
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr=new int[10000];
        for (int i = 0; i <10000 ; i++) {
            arr[i]=i+1;
        }
        System.out.println(insertSearch(arr,0,arr.length-1,2040));
    }
    public static int insertSearch(int[] arr,int left,int right,int value){
        System.out.println("查找次数");
        if(left>right || value<arr[0] || value>arr[arr.length-1]){
            return -1;
        }
        int mid=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if(value>midVal){
            return insertSearch(arr,mid+1,right,value);
        } else if(value<midVal){
            return insertSearch(arr,left,mid-1,value);
        }else {
            return mid;
        }

    }
}
