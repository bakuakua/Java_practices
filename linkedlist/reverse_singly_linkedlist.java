public class reverse_singly_linkedlist{
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
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		LinkedListNode list = buildList(arr);
		System.out.println("input list is: ");
		printList(list);
		LinkedListNode reversed = reverse(list);
		System.out.println("reversed list is: ");
		printList(reversed);
	}
}	