package KMP;

import java.util.Arrays;

/**
 * @Author: yangkai
 * @Date: 2022/7/15 15:16
 */
public class Algorithm {
    public static void main(String[] args) {
        String str1="hellomojito";
        String str2="mojito";
        System.out.println(Arrays.toString(kmpNext(str2)));
    }
    public static int match(String str1,String str2,int[] next){
        for (int i = 0,j=0; i < str1.length(); i++) {
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }
    public static int[] kmpNext(String dest){
        int[] next=new int[dest.length()];
        next[0]=0;
        for(int i=1,j=0;i<dest.length();i++){
            //KMP算法核心
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
