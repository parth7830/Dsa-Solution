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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> al = new ArrayList<>();
        for(ListNode ls: lists){
            while(ls != null){
                al.add(ls.val);
                ls = ls.next;
            }
        }
        Collections.sort(al);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int val : al){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}