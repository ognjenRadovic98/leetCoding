class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int runAmount = left - right;
        if(runAmount == 0) return head;
        
        return helper(head,null,left,right);
        
    }
    
    public ListNode helper(ListNode header, ListNode prev, int left, int right){
        if(right == 0){
            return prev;
        }
        
        if(left <= 1){
            if(left == 1) {ListNode storeFinalNode = header;} // this stores the new end so 4->3->2 it would store the 2 so i can make 2->5
            ListNode temp = header.next;        
            ListNode currentHead = header;
            currentHead.next = prev;
            ListNode currentPrevious = currentHead;            
           return helper(temp, currentPrevious, left, right-1);
        }
        
        return helper(header.next, header,left-1, right-1);
    }
