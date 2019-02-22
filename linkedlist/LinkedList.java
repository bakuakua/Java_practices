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
	public static void main(String[] args){
		int[] arr = {1,2,3,5,3};
		LinkedListNode list = buildList(arr);
		System.out.println("input list is: ");
		printList(list);
		LinkedListNode removed = removedup(list);
		printList(removed);
	}
}