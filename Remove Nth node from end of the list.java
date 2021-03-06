/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *     Input: head = [1,2,3,4,5], n = 2
 *     Output: [1,2,3,5]            n <= listSize
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int counter = 0;
        HashMap<Integer,ListNode> storage = new HashMap<Integer,ListNode>();            //Could alternatively use arrayList. 
        
        while(temp!= null){
            storage.put(counter, temp);
            temp = temp.next;
            counter++;
        }
        
        if(counter == n){
            return head.next;
        }
        
        storage.get(counter-n-1).next = storage.get(counter-n+1);
        return head;
        
    }
}
