package solutions;


/**
 * @Author: yangkai
 * @Date: 2022/6/21 11:21
 */
public class lastLength {
    public static void main(String[] args) {
        String s="     ";
        System.out.println(new lastLength().lengthOfLastWord(s));
    }
    public int lengthOfLastWord(String s){
        int length=0;
        String[] strings=s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        if(strings.length>0){
            length=strings[strings.length-1].length();
        }
        return length;
    }
}
