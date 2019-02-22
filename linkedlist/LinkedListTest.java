import java.util.*;
public class LinkedListTest{
	public static boolean TestBuild(){
		boolean result = true;
		int[] arr1 = {1,2,3,4,5};
		LinkedList.LinkedListNode head = LinkedList.buildList(arr1);
		System.out.println("checking buildList correctness for: \n"+ Arrays.toString(arr1));	
		System.out.println("resulting linkedlist is: ");
		LinkedList.printList(head);
		for (int i:arr1){
			if (i == head.data){
				head = head.next;
			}
			else{
				result = false;
				return result;
			} 
		}
		if (head !=null) result = false;
		System.out.println("Is the result correct?: \n"+ result);
		return result;
	}
	public static boolean TestRemoveDup(){
		boolean result = true;
		int[] arr1 = {1,2,3,3,5};
		LinkedList.LinkedListNode head = LinkedList.buildList(arr1);
		LinkedList.LinkedListNode list = LinkedList.removedup(head);
		System.out.println("checking removeDup correctness for: \n"+ Arrays.toString(arr1));	
		System.out.println("resulting linkedlist is: ");
		LinkedList.printList(list);
		int[] expected = {1,2,3,5};
		for(int i : expected){
			if (list.data == i) list=list.next;
			else {
				result = false;
				return result;
			} 
		}
		if (list!=null) result = false;
		System.out.println("Is the result correct?: \n"+ result);

		int[] arr2 = {1,2,3,5,3};
		LinkedList.LinkedListNode head2 = LinkedList.buildList(arr2);
		LinkedList.LinkedListNode list2 = LinkedList.removedup(head2);
		System.out.println("checking removeDup correctness for: \n"+ Arrays.toString(arr2));	
		System.out.println("resulting linkedlist is: ");
		LinkedList.printList(list2);
		int[] expected2 = {1,2,3,5};
		for(int i : expected2){
			if (list2.data == i) list2=list2.next;
			else {
				result = false;
				return result;
			} 
		}
		if (list2!=null) result = false;
		System.out.println("Is the result correct?: \n"+ result);
		return result;
	}
	public static void main(String[] args){
		TestBuild();
		TestRemoveDup();
	}
}