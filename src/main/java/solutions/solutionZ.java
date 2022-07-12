package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/10 14:37
 */
public class solutionZ {
    public static String convert(String s, int numRows) {
        String newS="";
        for (int i = 0; i < numRows; i++) {
            newS+=s.charAt(i);
            newS+=s.charAt(numRows-1+numRows-2);
        }
        return newS;
    }

    public static void main(String[] args) {
        String str="JAHGOWJDKFDR4H";
        System.out.println(solutionZ.convert(str,4));
    }

}
