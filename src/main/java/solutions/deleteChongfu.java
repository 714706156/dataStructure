package solutions;

import java.util.LinkedList;

/**
 * @Author: yangkai
 * @Date: 2022/6/22 10:55
 */
public class deleteChongfu {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        if(cur==null){
            return head;
        }
        if(cur.val==cur.next.val){
            cur.next=cur.next.next;
        }else {
            cur=cur.next;
        }
        return head;

    }

    public static void main(String[] args) {

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
