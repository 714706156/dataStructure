package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangkai
 * @Date: 2022/6/21 11:47
 */
public class addOne {
    public static void main(String[] args) {
        int[] ral=new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] rel=new addOne().plusOne(ral);
        for (int i = 0; i < rel.length; i++) {
            System.out.println(rel[i]);
        }
    }
    public int[] plusOne(int[] digits) {
        List<Integer> integerList=new ArrayList<>();
        String numStr="";
        int num=0;
        for (int i = 0; i < digits.length; i++) {
            num+=digits[i]*Math.pow(10,digits.length-1-i);
        }
        numStr=String.valueOf(num+1);
        System.out.println(numStr);
        for (int i = 0; i < numStr.length(); i++) {
            if(i==numStr.length()-1){
                integerList.add(Integer.parseInt(numStr.substring(i)));
            }else {
                integerList.add(Integer.parseInt(numStr.substring(i,i+1)));
            }
        }
        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
