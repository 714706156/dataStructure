package search;

/**
 * @Author: yangkai
 * @Date: 2022/2/17 17:25
 */
public class seqSearch {
    public static void main(String[] args) {
        int[] arr={12,35,68,235,46,733,35};
        System.out.println(search(arr,35));

    }
    public static int search(int[] arr,int value){
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value){
                index=i;
                break;
            }else {
                index= -1;
            }
        }
        return index;
    }
}
