import java.util.HashMap;


public class LRUCache {
	int l_capacity;
	HashMap<Integer, ListNode> map;
	
	
	public class ListNode
	{
		int val;
		int key;
		ListNode pre;
		ListNode next;
		ListNode(int value, int nodekey)
		{
			val = value;
			key = nodekey;
			pre = null;
			next = null;
		}
	}
	
	ListNode l_head;
	ListNode l_nail;
	
	 public LRUCache(int capacity) {
		 l_capacity = capacity;
		 map = new HashMap<Integer, ListNode>(); 
		 ListNode l_head = null;
		 ListNode l_nail = null;
	    }
	    
	    public int get(int key) {
	    	
	    	if(map.containsKey(key))
	    	{
	    		if(map.size()==1)
	    			return map.get(key).val;
	    	    ListNode temp = map.get(key);
	    	    if(temp.pre!=null)
	    	      	temp.pre.next = temp.next;  
	    	    if(temp.next!=null)
	    	    	temp.next.pre = temp.pre;
	    	    if(temp==l_nail)
	    	    	l_nail = temp.pre;
	    	    l_head.pre = temp;
	    	    temp.next = l_head;
	    	    l_head = temp;
	    	    
	    	    if(l_nail == null)
	    	    {
	    	    	l_nail = l_head;
	    	    	while(l_nail.next!=null)
	    	    		l_nail = l_nail.next;
	    	    }
	    	   	    
	    		return l_head.val;
	    	}
	    	return -1;
	        
	    }
	    
	    public void set(int key, int value) {
	    	
	    	if(map.containsKey(key))
	    	{
	    		map.get(key).val = value;   
	    		ListNode temp = map.get(key);
	 
	    	    if(temp.pre!=null)
	    	      	temp.pre.next = temp.next;  
	    	    if(temp.next!=null)
	    	    	temp.next.pre = temp.pre;
	    	    l_head.pre = temp;
	    	    temp.next = l_head;
	    	    l_head = temp;    		
	    		
	    	}
    		
	    	
	    	else if(map.size()<l_capacity)
	    	{	    	
	    		ListNode temp = new ListNode(value, key);
	    		if(l_head == null)
	    		{
	    			l_head = temp;
	    			l_nail = temp;
	    		}
	    		else
	    		{
	    			l_head.pre = temp;
	    		    temp.next = l_head;
	    		    l_head = temp;
	    		    
	    		}
	    		
	    		map.put(key, l_head);
	    		
	    	}
	    	else
	    	{
	    		if(l_nail.pre!=null)
	    		{
	    			l_nail.pre.next = null;
	    			map.remove(l_nail.key);
	    			l_nail = l_nail.pre;
	    		}
	    		
	    		ListNode temp = new ListNode(value, key);
	    		l_head.pre = temp;
	    		temp.next = l_head;
	    		l_head = temp;
	    		map.put(key, l_head);
	    		if(l_nail == null)
	    			l_nail = l_head;
	    			
	    	}        
	    }
	    
	
 public void test()
 {
	 LRUCache cache = new LRUCache(1);
	 cache.set(2, 1);
	 cache.get(2);
/*	 cache.set(3, 2);
	 cache.get(3);
	 cache.get(2);
	 cache.set(4,3);
	 cache.get(2);
	 cache.get(3);
	 cache.get(4);
 */
	 }
	    
	 
	

}
