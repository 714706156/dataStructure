package solutions;

import java.util.List;

/**
 * @Author: yangkai
 * @Date: 2022/6/13 11:14
 */
public class CommonPrefix {
    public static void main(String[] args) {
        String[] strs= {"flagsos", "flajownh","fldsajshduy","f"};
        System.out.println(new CommonPrefix().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        String common="";
        char[] chars=new char[200];
        int index=0;
        int length=strs[index].length();
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length()<length){
                length=strs[i].length();
                index=i;
            }
        }
        for (int i = 0; i < strs[index].length(); i++) {
            chars[i]=strs[0].charAt(i);
        }
        for (int i = 1; i < strs.length; i++) {
            for (int i1 = 0; i1 < strs[i].length(); i1++) {
                if(strs[i].charAt(i1)!=chars[i1]){
                    chars[i1]=Character.MIN_VALUE;
                }
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!=Character.MIN_VALUE){
                common+=chars[i];
            }else{
                break;
            }
        }
        return common;
    }
}
