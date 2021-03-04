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
            if(left == 1) {ListNode storeFinalNode = header;} 
                  // this keeps to stored 2
            ListNode temp = header.next;        // this keeps 3 stored
            ListNode currentHead = header;
            currentHead.next = prev;
            ListNode currentPrevious = currentHead;
            
            //this makes 2 point backwards
            
            helper(temp, currentPrevious, left, right-1);
        }
        
        return helper(header.next, header,left-1, right-1);
    }
