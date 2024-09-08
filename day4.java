//today i solved a question of singly linkedlist where i waas asked to split the linked list in k parts such that no 2 parts should have size diff of more than 1 , null parts are allowed. the result should be in order of input list .
//approach: lets split the list into parts after determining its size.For the first size % k parts, the size will be splitSize + 1. For the remaining parts, the size will be splitSize.
//time complexity: o(n) n is no. of nodes in list.
//space complexity: o(k): k is the number of parts 

class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // minimum size for the k parts
        int splitSize = size / k;

        // Remaining nodes after splitting the k parts evenly.
        // These will be distributed to the first (size % k) nodes
        int numRemainingParts = size % k;

        current = head;
        ListNode prev = current;
        for (int i = 0; i < k; i++) {
            // create the i-th part
            ListNode newPart = current;
            // calculate size of i-th part
            int currentSize = splitSize;
            if (numRemainingParts > 0) {
                numRemainingParts--;
                currentSize++;
            }

            // traverse to end of new part
            int j = 0;
            while (j < currentSize) {
                prev = current;
                current = current.next;
                j++;
            }
            // cut off the rest of linked list
            if (prev != null) {
                prev.next = null;
            }

            ans[i] = newPart;
        }

        return ans;
    }
}