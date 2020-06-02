/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Since we can't reach prev node in single LL; copy the val of next node to given node and delete next node.
 * Time : O(1)
 * Space : O(1)
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode tmp = node.next;
        node.next = tmp.next;
        tmp.next = null;
    }
}
