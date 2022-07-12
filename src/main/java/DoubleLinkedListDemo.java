/**
 * @Author: yangkai
 * @Date: 2022/2/11 14:41
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 node1 = new HeroNode2(1, "宋江");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义");
        HeroNode2 node3 = new HeroNode2(3, "无用");
        HeroNode2 node4 = new HeroNode2(4, "林冲");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node2);
        doubleLinkedList.show();
        HeroNode2 newnode4 = new HeroNode2(4, "公孙胜");
        doubleLinkedList.update(newnode4);
        doubleLinkedList.show();
    }
}
class DoubleLinkedList{
    private HeroNode2 head=new HeroNode2(0,"");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void show(){
        if(head.next==null){
            System.out.println("链表为空");
        }
        HeroNode2 temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
            System.out.println(temp);
        }
    }

    //添加节点
    public void add(HeroNode2 heroNode){
        HeroNode2 temp =head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
        //heroNode.pre=temp;
    }

    //按照顺序添加节点
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp =head;
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

    //修改节点
    public void update(HeroNode2 heroNode){
        if(head.next==null){
            System.out.println("链表为空");
        }
        HeroNode2 temp =head;
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

    //删除节点
    public void del(int no){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null){break;}
            if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else {
            System.out.println("该节点不存在");
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int no,String name){
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