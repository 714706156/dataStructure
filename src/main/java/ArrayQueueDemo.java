import java.util.Scanner;

/**
 * @Author: yangkai
 * @Date: 2022/2/10 11:47
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayqueue=new ArrayQueue(3);
        arrayqueue.add(10);

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
                    arrayqueue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value=scanner.nextInt();
                    arrayqueue.add(value);
                    break;
                case 'g':
                    try{
                      int res=arrayqueue.get();
                        System.out.println("取出的数据是： "+res+"\n");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res=arrayqueue.showhead();
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
class ArrayQueue{
    private int maxsize;
    private int front;
    private int rear;
    private int array[];
    public ArrayQueue(int maxsize){
        this.maxsize=maxsize;
        this.array=new int[this.maxsize];
        this.front=-1;
        this.rear=-1;
    }
    //判断是否为满
    public boolean isfull(){
        return rear==maxsize-1;
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
        rear++;
        array[rear]=n;
    }
    //往队列取数据
    public int get(){
        if(isempty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return array[front];
    }
    //显示数据
    public void show(){
        if(isempty()){
            System.out.println("队列为空");
        }
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public int showhead(){
        if(isempty()){
            System.out.println("队列为空");
        }
        return (array[front+1]);
    }
}
