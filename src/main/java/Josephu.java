/**
 * @Author: yangkai
 * @Date: 2022/2/11 16:13
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(20);
        //circleSingleLinkedList.show();
        circleSingleLinkedList.conutBoy(2,3,20);
    }
}

class CircleSingleLinkedList{
    private Boy first=null;
    //创建环形链表
    public void addBoy(int num){
        if (num<1){
            System.out.println("num必须大于1");
            return;
        }
        Boy curBoy=null;
        for(int i=1;i<=num;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //输出出圈顺序
    public void conutBoy(int startNum,int countNum,int nums){
        if(first==null || startNum<1 || startNum>nums){
            System.out.println("参数输入有误");
            return;
        }
        //创建辅助指针，帮助小孩出圈
        Boy helper=first;
        //让helper指针事先指向最后一个节点
        while (true){
            if(helper.getNext()==first){break;}
            helper=helper.getNext();
        }
        //在报数前，先让first和helper移动startNum-1次
        for(int j=0;j< startNum-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //小孩报数时，first和helper共移动countNum-1次
        while (true){
            if (helper==first){
                break;
            }
            for(int j=0;j<countNum-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("出圈的小孩是：%d\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后出圈的小孩是：%d",first.getNo());


    }
    //遍历环形链表
    public void show(){
        if(first==null){
            System.out.println("这是一个空链表");
            return;
        }
        Boy curBoy=first;
        while (true){
            System.out.printf("小孩的编号是：%d\n",curBoy.getNo());
            if (curBoy.getNext()==first){break;}
            curBoy=curBoy.getNext();
        }
    }
}


class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
