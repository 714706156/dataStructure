package DAC;

/**
 * @Author: yangkai
 * @Date: 2022/7/14 15:06
 */
public class HanoiTower {
    public static void main(String[] args) {
        tower(5,'A','B','C');
    }
    //目标是将a的塔移动到c，中间会使用到b
    public static void tower(int num,char a,char b,char c){
        if(num==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            //如果num>=2，那么第一步是将上面的塔移动到b，中间过程会使用到c
            tower(num-1,a,c,b);
            //第二步是将最下面的塔移动到c
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //第三步是将b上的塔移动到c，中间使用到了a
            tower(num-1,b,a,c);
        }
    }
}
