package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangkai
 * @Date: 2022/6/13 10:45
 */
public class solutionRoman {
    public static void main(String[] args) {
        String s="LVIII";
        System.out.println(new solutionRoman().romanToInt(s));
    }
    public int romanToInt(String s) {
        Integer it=0;
        List<Integer> integerList=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='I'){
                integerList.add(1);
            }else if(s.charAt(i)=='V'){
                integerList.add(5);
            }else if(s.charAt(i)=='X'){
                integerList.add(10);
            }else if(s.charAt(i)=='L'){
                integerList.add(50);
            }else if(s.charAt(i)=='C'){
                integerList.add(100);
            }else if(s.charAt(i)=='D'){
                integerList.add(500);
            }else if(s.charAt(i)=='M'){
                integerList.add(1000);
            }
        }
        for (int i = 0; i < integerList.size(); i++) {
            if(i<integerList.size()-1){
                if(integerList.get(i)<integerList.get(i+1)){
                    Integer temp=integerList.get(i+1)-integerList.get(i);
                    it+=temp;
                    i+=1;
                }else {
                    it+=integerList.get(i);
                }
            }else {
                it+=integerList.get(i);
            }

        }
        return it;
    }
}
