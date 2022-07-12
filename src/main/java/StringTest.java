
/**
 * @Author: yangkai
 * @Date: 2022/2/11 14:23
 */
public class StringTest {
    public static void main(String[] args) {
        String string = new String("hello");
        StringBuffer buffer = new StringBuffer("hello");
        StringBuilder builder = new StringBuilder("hello");
        System.out.println(string.hashCode());
        string="hellobuffer";
        System.out.println(string);
        buffer.append("buffer");
        builder.append("builder");
        System.out.println(buffer);
        System.out.println(builder);
        System.out.println(string.hashCode());
    }
}
