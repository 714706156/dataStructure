import java.util.Stack;

/**
 * @Author: yangkai
 * @Date: 2022/2/10 16:54
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "卢俊义");
        HeroNode node3 = new HeroNode(3, "无用");
        HeroNode node4 = new HeroNode(4, "林冲");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.show();
        reverse(singleLinkedList.getHead());
        singleLinkedList.show();
    }

    public static void reverse(HeroNode head){
        if(head.next==null || head.next.next==null){
            return;
        }
        //定义一个辅助指针，帮助遍历原来的链表
        HeroNode cur=head.next;
        HeroNode next=null;
        HeroNode newhead=new HeroNode(0,"");
        while (cur!=null){
            next=cur.next;
            cur.next=newhead.next;
            newhead.next=cur;
            cur=next;
        }
        head.next=newhead.next;
    }

    public static void reversePrint(HeroNode head){
        if(head.next==null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
class SingleLinkedList{
    //初始化头结点
    private HeroNode head=new HeroNode(0,"");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode temp =head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp =head;
        boolean flag=false;
        while (true){
            if(temp.next==null){break;}
            if(temp.next.no>heroNode.no){break;}
            else if(temp.next.no==heroNode.no) {
                flag=true;
                break;}
            temp=temp.next;
        }
        if(flag){
            System.out.println("该节点已经存在");
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    public void update(HeroNode heroNode){
        if(head.next==null){
            System.out.println("链表为空");
        }
        HeroNode temp =head;
        boolean flag=false;
        while (true){
            //已经遍历完链表
            if(temp==null){
                break;
            }
            if(temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.name=heroNode.name;
        }else {
            System.out.println("没有找到节点");
        }
    }

    public void del(int no){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp.next==null){break;}
            if(temp.next.no==no){
                flag=true;
                break;
            }
            temp=temp.next;

        }
        if(flag){
            temp.next=temp.next.next;
        }
    }
    public void show(){
        if(head.next==null){
            System.out.println("链表为空");
        }
        HeroNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }

            temp=temp.next;
            System.out.println(temp);
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public HeroNode next;
    public HeroNode(int no,String name){
        this.no=no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' + '}';
    }
}