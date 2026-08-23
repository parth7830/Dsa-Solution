class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode i = list1;
        ListNode j = list2;

        while (i != null && j != null) {
            if (i.val <= j.val) {
                tail.next = i;
                i = i.next;
            } else {
                tail.next = j;
                j = j.next;
            }
            tail = tail.next;
        }

        // attach whichever list still has leftover nodes
        tail.next = (i != null) ? i : j;

        return dummy.next;
    }
}