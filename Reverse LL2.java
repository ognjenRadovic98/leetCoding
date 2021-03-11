/*Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
class */ 
Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    	if(right-left == 0) return head; 
        ListNode header = head;
    	ListNode temp = head;
    	ListNode firstBeforeSwap = null;
    	ListNode firstSwap = null;
    	ListNode firstAfterSwap = null;
        
        
    	for(int i = 1; i <= right; i++) {
    		if(i == left) firstSwap = temp;
    		if(i == left - 1) firstBeforeSwap = temp;
    		if(i == right) firstAfterSwap = temp.next;
    		temp = temp.next;
    	}
        
    	if(left > 1) {
    	    firstBeforeSwap.next = helper(firstSwap,firstAfterSwap,right-left+1);
    	    return header;
    	}
    	else{
    		return helper(header,firstAfterSwap,right-left+1);
    	}
    }
    
    public ListNode helper(ListNode header, ListNode prev, int runAmount){
        if(runAmount == 0 || header == null){
            return prev;
        }
        ListNode temp = header;
        temp = temp.next;
        ListNode curHead =  header;
        curHead.next = prev; 
        return helper(temp,curHead, runAmount-1);        
    }
    
}
