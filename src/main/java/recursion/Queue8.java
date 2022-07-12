package recursion;

/**
 * @Author: yangkai
 * @Date: 2022/2/16 10:25
 */
public class Queue8 {
    int[] array=new int[8];
    static int count=0;
    public static void main(String[] args) {
        Queue8 queue=new Queue8();
        queue.check(0);
        System.out.println(count);
    }
    public void check(int n){//放置第n个皇后
        if(n==8){
            print();
            return;
        }
        for (int i = 0; i < 8; i++) {
            array[n]=i;
            if(judge(n)){
                check(n+1);
            }
        }
    }
    public boolean judge(int n){//判断是否冲突
        for (int i = 0; i < n; i++) {
            if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    public void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
