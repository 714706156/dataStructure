package tree.ThreadedBinaryTree;

import lombok.Data;

/**
 * @Author: yangkai
 * @Date: 2022/7/13 14:24
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root=new HeroNode(1,"kim");
        HeroNode node2=new HeroNode(3,"tom");
        HeroNode node3=new HeroNode(6,"timi");
        HeroNode node4=new HeroNode(8,"jack");
        HeroNode node5=new HeroNode(10,"jimmy");
        HeroNode node6=new HeroNode(14,"chet");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRootNode(root);
        binaryTree.threadedNodes();
        HeroNode leftNode=node5.getLeft();
        System.out.println(leftNode);
        binaryTree.threadedList();
    }
}

@Data
class BinaryTree{
    private HeroNode rootNode;
    private HeroNode pre=null;
    public void threadedNodes(){
        this.threadedNodes(rootNode);
    }
    //遍历线索化二叉树
    public void threadedList(){
        HeroNode node=rootNode;
        while (node!=null){
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }
    //中序线索化
    public void threadedNodes(HeroNode node){
        if(node==null){
            return;
        }
        threadedNodes(node.getLeft());
        //处理当前节点
        //处理当前节点的前驱结点
        if(node.getLeft()==null){
            //让当前节点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前节点的左指针的类型，指向前驱结点
            node.setLeftType(1);
        }
        //处理后继节点
        if(pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        //让当前节点称为下一个节点的前驱结点
        pre=node;
        threadedNodes(node.getRight());
    }
    //删除节点
    public void delete(int no){
        if(this.rootNode!=null){
            if(this.rootNode.getNo()==no){
                this.rootNode=null;
            }else {
                this.rootNode.delete(no);
            }
        }else {
            System.out.println("这是空树");
        }
    }
    //前序遍历
    public void preOrder(){
        if(this.rootNode!=null){
            this.rootNode.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.rootNode!=null){
            this.rootNode.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.rootNode!=null){
            this.rootNode.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    //前序查找
    public HeroNode preSearch(int no){
        if(this.rootNode!=null){
            return this.rootNode.preSearch(no);
        }else {return null;}
    }
    //中序查找
    public HeroNode infixSearch(int no){
        if(this.rootNode!=null){
            return this.rootNode.infixSearch(no);
        }else {return null;}
    }
    //后序查找
    public HeroNode postSearch(int no){
        if(this.rootNode!=null){
            return this.rootNode.postSearch(no);
        }else {return null;}
    }
}
@Data
class HeroNode{
    private String name;
    private int no;
    private HeroNode left;
    private HeroNode right;
    //0表示左子树，1表示前驱节点
    private int leftType;
    //0表示右子树，1表示后继节点
    private int rightType;
    public HeroNode( int no,String name){
        this.no=no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
    //删除节点
    public void delete(int no){
        if(this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null && this.right.no==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delete(no);
        }
        if(this.right!=null){
            this.right.delete(no);
        }
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序查找
    public HeroNode preSearch(int no){
        System.out.println("进入前序查找");
        HeroNode resNode=null;
        if(this.no==no){
            return this;
        }
        if(this.left!=null){
            resNode=this.left.preSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.preSearch(no);
        }
        return resNode;
    }
    //中序查找
    public HeroNode infixSearch(int no){

        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.infixSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入中序查找");
        if(this.no==no){
            return this;
        }
        if(this.right!=null){
            resNode=this.right.infixSearch(no);
        }
        return resNode;
    }
    //后序查找
    public HeroNode postSearch(int no){

        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.postSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.infixSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后序查找");
        if(this.no==no){
            return this;
        }
        return resNode;
    }
}

