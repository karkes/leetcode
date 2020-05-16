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
class Solution {
    public ListNode oddEvenList(ListNode head) {
                             
        if (head == null || head.next == null || head.next.next == null)
            return head;
        
        // we've atleast 3 nodes
        int count = 0;
        ListNode evenHead = head.next;
        ListNode first = head;
        ListNode second = evenHead;
        
        while (true) {
            count++;
            first.next = second.next;
            first = second;
            second = second.next;
            if (second.next == null) {
                if (count % 2 == 0) {
                    // break the last link btw f -> s to connect to head
                    first.next = evenHead; 
                }
                else {
                    second.next = evenHead;
                    // break the last link btw f -> s
                    first.next = null; 
                }
                break;
            }
        }
        return head;
    }
}
