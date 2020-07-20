//LEETCODE - 203. Remove Linked List Elements
//https://leetcode.com/problems/remove-linked-list-elements/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 //approach - simple linked list manipulation
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null) {
            if(temp.val == val && prev == null) { //for 1->1->1->2->3 , k=1 , to remove initial elements
                head = head.next;           //move head
                temp = head;                //also update the temp
            } else if ( temp.val == val) {  //to remove intermediate values or tail values
                prev.next = temp.next;      //change prev.next link
                temp = temp.next;           //update temp , dont update the prev as next val should also be deleted
            } else {                        //when there is no match move both temp and prev ahead
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
            
    }
}


//tc - 0(n)
//sc - 0(1)