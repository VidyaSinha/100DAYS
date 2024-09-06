//today i solved a question where i was given a array called num and linked list called head where i had to remove all the alements of array found in linked list head. 
//so i 1st made a new modified linkedlist and keep on checking and comparing the array elements to the linkedlist element with the help of freq which gives boolean value true if the element is same then we skip that value if not same then we remove it and add to the modified linkedlist which only have values other than values matching from array.

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
       int max=-1;
        for(int num : nums ){
            max = num > max ? num : max;
        }
        boolean[] freq = new boolean[max+1];

        for(int num : nums) freq[num] = true;

        ListNode temp = new ListNode();
        ListNode current = temp;

        while(head != null){
            if( head.val >= freq.length || freq[head.val] == false){
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        current.next = null;
        return temp.next;
    }
}