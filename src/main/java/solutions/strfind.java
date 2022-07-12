package solutions;

/**
 * @Author: yangkai
 * @Date: 2022/6/14 10:27
 */
public class strfind {
    public int strStr(String haystack, String needle) {
        int index=0;
        int len=needle.length();
        if(!haystack.contains(needle)){
            index=-1;
        }else {
            for (int i = 0; i < haystack.length(); i++) {
                if(haystack.substring(i,i+len).equals(needle)){
                    index=i;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String haystack="helloihello";
        String needle="hello";
        System.out.println(new strfind().strStr(haystack,needle));
    }
}
