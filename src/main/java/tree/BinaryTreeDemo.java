package tree;

import lombok.Data;

/**
 * @Author: yangkai
 * @Date: 2022/7/11 17:32
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode node2=new HeroNode(2,"吴用");
        HeroNode node3=new HeroNode(3,"卢俊义");
        HeroNode node4=new HeroNode(4,"林冲");
        HeroNode node5=new HeroNode(5,"顾三娘");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRootNode(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        binaryTree.delete(3);
        System.out.println("前序遍历");
        binaryTree.preOrder();
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
//        HeroNode resNode=binaryTree.postSearch(5);
//        if(resNode!=null){
//            System.out.println("找到该英雄！！！"+resNode.toString());
//        }else{
//            System.out.println("未找到该英雄！");
//        }

    }
}

@Data
class BinaryTree{
    private HeroNode rootNode;
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
