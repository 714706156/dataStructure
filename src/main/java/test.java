import java.util.Scanner;

/**
 * @Author: yangkai
 * @Date: 2022/2/14 10:03
 */
public class test {
    public static void main(String[] args) {
        String key="";
        boolean flag=true;
        Scanner scanner=new Scanner(System.in);
        while (flag) {

            System.out.println("s表示显示数据");
            System.out.println("e表示退出");
            System.out.println("push表示添加数据");
            System.out.println("pop表示取出数据");
            System.out.println("请输入你的选择");
            key = scanner.next();
            break;
        }
    }
}
