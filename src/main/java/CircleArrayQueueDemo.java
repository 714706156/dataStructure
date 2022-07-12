import java.util.Scanner;

/**
 * @Author: yangkai
 * @Date: 2022/2/10 15:51
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray circleArray=new CircleArray(3);
        char key=' ';
        Scanner scanner=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("q:退出程序");
            System.out.println("s:显示");
            System.out.println("a:添加");
            System.out.println("g:获取一个数据");
            System.out.println("h:获取头部数据");
            key=scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    circleArray.show();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value=scanner.nextInt();
                    circleArray.add(value);
                    break;
                case 'g':
                    try{
                        int res=circleArray.get();
                        System.out.println("取出的数据是： "+res+"\n");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res=circleArray.showhead();
                        System.out.println("取出的数据是："+res+"\n");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'q':
                    scanner.close();
                    flag=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }

}
class CircleArray{
    private int maxsize;
    private int front;
    private int rear;
    private int array[];
    public CircleArray(int maxsize){
        this.maxsize=maxsize;
        this.array=new int[this.maxsize];
        this.front=0;
        this.rear=0;
    }
    //判断是否为满
    public boolean isfull(){
        return (rear+1)%maxsize==front;
    }
    //判断是否为空
    public boolean isempty(){
        return rear==front;
    }
    //往队列添加数据
    public void add(int n){
        if(isfull()) {
            System.out.println("队列已满");
            return;
        }
        array[rear]=n;
        rear=(rear+1)%maxsize;
    }
    //往队列取数据
    public int get(){
        if(isempty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        int value=array[front];
        front=(front+1)%maxsize;
        return value;
    }
    //求出当前数组中有效个数
    public int size(){
        return (rear-front+maxsize)%maxsize;
    }
    //显示数据
    public void show(){
        if(isempty()){
            System.out.println("队列为空");
        }
        for (int i=front;i<size();i++){
            System.out.println(array[i%maxsize]);
        }
    }
    public int showhead(){
        if(isempty()){
            System.out.println("队列为空");
        }
        return (array[front]);
    }
}
