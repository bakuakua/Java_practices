import java.util.*;
public class LinkedList{
	// node class for linkedlist elements
	public static class LinkedListNode{
		public int data;
		public LinkedListNode next;
		public LinkedListNode(int x){
			this.data = x;
			this.next = null;
		}
	}
	/**linkedlist builder from array
	 * @param a : integer array
	 * @return : LinkedListNode
	 */
	public static LinkedListNode buildList(int[] a) {
        if (a == null || a.length == 0) return null;
        LinkedListNode n = new LinkedListNode(a[0]);
        LinkedListNode head = n;
        for (int i = 1; i < a.length; ++i) {
            n.next = new LinkedListNode(a[i]);
            n = n.next;
        }
        return head;
    }
    /**linkedlist printer
     * @param n : head to linked list
     * @return : void
     */
    public static void printList(LinkedListNode n) {
        int i = 0;
       	while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }
    /**get length of the linkedlist
     * @param head : head of input list
     * @return : int length
     */
    public static int get_length(LinkedListNode head1){
    	if (head1 == null) return 0;
    	else {
    		LinkedListNode curr = head1;
    		int len = 0;
    		while (curr != null){
    			curr = curr.next;
    			len++;
    		}
    		return len;
    	}
    } 

    /** The following function reverse a singly linked 
	 *  list
	 *  @param head : Input linkedlist to be reversed
	 *  @return : new linkedlist
	 */
	public static LinkedListNode reverse(LinkedListNode head){
		if (head == null || head.next == null) return head;
		LinkedListNode reversed = head;
		LinkedListNode to_do = head.next;
		reversed.next = null;
		while (to_do != null){
			LinkedListNode tmp = to_do;
			to_do = to_do.next;
			tmp.next = reversed;
			reversed = tmp;
		}
		return reversed;
	}
	/** The following function reverse a singly linked 
	 *  list given a starting and ending position
	 *
	 *  @param head : Input linkedlist
	 *  @param start : starting Node index
	 *  @param end : ending node index
	 *  @return : reversed linkedlist
	 */
	public static LinkedListNode reverse_window(LinkedListNode head, int start, int end){
		if (head == null || head.next == null) return head;
		LinkedListNode begin = head;
		for (int i = 1; i<(start-1); i++){
			begin = begin.next;
		}
		
		LinkedListNode reversed = begin.next;
		LinkedListNode todo = reversed.next;
		
		LinkedListNode reversed_end = reversed;
		reversed.next = null;
		int count = 1;
	    while (count<= (end-start)){
	    	LinkedListNode tmp = todo;
	    	todo = todo.next;
	    	tmp.next = reversed;
	    	reversed = tmp;
	    	count++;	
	    }
	    begin.next = reversed;
	    reversed_end.next = todo;
	    return head;
	}
	/** The following function remove duplicate node from a singly linked list
	 *  @param head : input linklist
	 *  @return : new head;
	 */
	public static LinkedListNode removedup(LinkedListNode head){
		if (head == null || head.next == null) return head;
		HashSet<Integer> node_set=new HashSet<>();

		LinkedListNode prev = null;
		LinkedListNode curr = head;
		LinkedListNode after = head.next;
		while (curr != null){
			if (node_set.contains(curr.data)){
				if (curr.next == null){
					prev.next = null;
					break;
				}
				else{
					prev.next = after;
					curr = after;
					after = curr.next;
				}
			}
			else{
				node_set.add(curr.data);
				prev = curr;
				curr = after;
				if (after == null) break;
				else after = after.next;
			}
		}
		return head;
	}
	/** The following function removes a given key from the singly linked list
	 *  Note it should remove keys duplicate too
	 *  @param head : input linkedlist
	 *  @param key : the key top remove
	 *  @return : the modified input list
	 */
	public static LinkedListNode remove_key (LinkedListNode head, int key){
		//note check if the list if empty 
		if (head == null) return head;
		LinkedListNode curr = head;
		LinkedListNode prev = null;
		while (curr != null){
			if (curr.data == key){
				if (curr == head){
					head = head.next;
					curr = head;
				}
				else{
					prev.next = curr.next;
					curr = curr.next;
				}
			}
			else{
				prev = curr;
				curr = curr.next;			
			}
		}
		return head;
	}
	public static LinkedListNode insert_sorted(LinkedListNode head, LinkedListNode node){
		if (node == null) return head;
		if (head == null || node.data <= head.data) {
			node.next = head;
			head = node;
			return head;
		}
		LinkedListNode curr = head;
		while (curr.next != null && node.data>curr.next.data){
			curr = curr.next;
		} 
		node.next = curr.next;
		curr .next = node;
		return head;
	}
	/** The following function sort a unordered linkedlist from smallest to largest
	 *  @param head : head node
	 */
	public static LinkedListNode sort(LinkedListNode head){
		LinkedListNode sorted = null;
		LinkedListNode curr = head;
		if (head == null) return null;
		while (curr != null) {
			LinkedListNode tmp = curr.next;
			sorted = insert_sorted(sorted, curr);
			System.out.println(sorted.data);
			curr = tmp;
		}
		return sorted;
	}
	/** The following function finds the physical intersection between two linkedlist 
	 *  @param head1 : the first linkedlist
	 *  @param head2 : the second linkedlist
	 *  @return : the node at intersection
	 */
	public static LinkedListNode intersect(LinkedListNode h1, LinkedListNode h2){
		int len1 = get_length(h1);
		int len2 = get_length(h2);
		int d = Math.abs(len1 - len2);
		LinkedListNode curr1 = h1;
		LinkedListNode curr2 = h2;
		if (len1 > len2) {
			int c = 0;
			while (c < d){
				curr1 = curr1.next;
				c++;
			}
		}
		else {
			int c = 0;
			while (c < d){
				curr2 = curr2.next;
				c++;
			}
		}
	    while (curr1 != null){
	    	if (curr1 == curr2) return curr1;
	    	else{
	    		curr1 = curr1.next;
	    		curr2 = curr2.next;
	    	}
	    }
		return null;

	}
	/** The following function returns the nth node from last 
	 *  @param head : input list
	 *  @param n : interger N
	 *  @return : node 
	 */
	public static LinkedListNode NthFromLast(LinkedListNode head, int n){
		LinkedListNode start = head;
		LinkedListNode end = head;
		int c = 0;
		while (c < n){
			if (end == null) return null;
			else{
				end = end.next;
				c++;
			}
		}
		while (end != null){
			start = start.next;
			end = end.next;
		}
		return start;
	}
	/** The following function swaps the nth node with head
	 *  @param head : input list head node
	 *  @param n : the nth node to be swaped with head
	 *  @return : new head of linkedlist
	 */
	public static LinkedListNode swap_nth_with_head(LinkedListNode head, int n){
		LinkedListNode prev = null;
		LinkedListNode curr = head;
		if (head == null) return head;
		if (n == 1) return head;
		//move curr pointer to the N-1 position
		while (n>1 && curr!=null){
			prev = curr;
			curr = curr.next;
			n--;
		}
		prev.next = head;
		LinkedListNode temp = head.next;
		head.next = curr.next;
		curr.next = temp;
		return curr;
	}
	/** The following function merges two *SORTED linkedlist
	 *  @param head1 : linkedlist 1
	 *  @param head2 : linkedlist 2
	 *  @return : new head of the merged lists
	 */
	public static LinkedListNode mergeLists(LinkedListNode head1, LinkedListNode head2){
		//initialize returning merged list with a null head;
		LinkedListNode mergedhead = null;
		//add first node to merged list by comparing the starting nodes of input lists
		if (head1.data <= head2.data){
			mergedhead = head1;
			head1 = head1.next;
		}
		else{
			mergedhead = head2;
			head2 = head2.next;
		}
		//place mergedtail pointer at the merged head; 
		LinkedListNode mergedtail = mergedhead;
		//compare head nodes then increment heads and add the smaller node to merged tail
		while (head1!=null && head2!=null){
			LinkedListNode temp = null;
			if (head1.data<=head2.data){
				temp = head1;
				head1 = head1.next;
			}
			else{
				temp = head2;
				head2 = head2.next;
			}
			mergedtail.next = temp;
			mergedtail = temp;
		}
		if (head1 != null) mergedtail.next = head1;
		else if (head2 != null) mergedtail.next = head2;

		return mergedhead;
	}
	/** The following function reverses the even nodes of a linked list
	 *  @param head : input list to be reversed
	 *  @return : reversed list
	 */
	public static LinkedListNode reverse_even_nodes(LinkedListNode head){
		// extract even nodes into auxiliary list
		LinkedListNode curr = head;
		LinkedListNode even_list = null;
		while (curr != null && curr.next != null){
			LinkedListNode even = curr.next;
			curr.next = even.next;
			even.next = even_list;
			even_list = even;
			curr = curr.next;
		}
		//merge the lists alternatively
		return merge_alt(head,even_list);
	}
	/** The following function merges two lists alternatively
	 */
	public static LinkedListNode merge_alt(LinkedListNode list1, LinkedListNode list2){
		if (list1 == null){
			return list2;
		}
		if (list2 == null){
			return list1;
		}	
		if (list1.next == null) {
      		list1.next = list2;
    	}
		LinkedListNode head = list1;
		while (list1.next!= null && list2 != null){
			LinkedListNode temp = list2;
			list2 = list2.next;
			temp.next = list1.next;
			list1.next = temp;
			list1 = temp.next;
		}
		return head;
	}
	public static void main(String[] args){
		int[] arr = {5,2,3,4,1};
		LinkedListNode list = buildList(arr);
		System.out.println("input list is: ");
		printList(list);
		LinkedListNode sorted = sort(list);
		printList(sorted);
		System.out.println(get_length(sorted));
	}
		}
}