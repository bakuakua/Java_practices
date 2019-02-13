import java.util.*;
public class MaximumSlidingWindow{
	/**
	 * MaxSW is a function that slides a window of size w across 
	 * an input array while printing the maximum of each window
	 * @param w: size of the window
	 * @param arr: input array to be scanned
	 * @return: an array consisting all the max element from each window
	 */
	public static LinkedList<Integer> MaxSW(int w, int[] arr){
		//initialize 
		//initialize first window
		LinkedList<Integer> result = new LinkedList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < w; i++){
			while (list.size()!=0 && list.peekLast()<arr[i]) list.removeLast();
			list.addLast(i);
		}
		//slide the window 
		for (int j = w; j < arr.length; j++){
			//add current max to result
			result.addLast(list.peekFirst());
			//remove from tail if the entering value is greater than the tail indices
			while (list.size()!=0 && arr[list.peekLast()] < arr[j]) list.removeLast();
			//remove indices from head is its no longer in the current window
			while (list.size()!=0 && list.peek() <= (j-w)) list.removeFirst();
			list.addLast(j);
		}
		result.addLast(list.peek());
		return result; 
	}
	public static void testMaxSW(int w, int[] arr, int[] expected){
		System.out.println("-------------------------------------");
		LinkedList<Integer> result = new LinkedList<Integer>();
		result = MaxSW(w, arr);
		String output = "[";
		while (result.size()!=0){
			output+=arr[result.remove()];
			if (result.size()!=0) output+=", ";
			else output+="]";
		}

		System.out.println("input array: " + Arrays.toString(arr));
		System.out.println("window size: " + Integer.toString(w));
		System.out.println("expected result: " + Arrays.toString(expected));
		System.out.println("actual result: " + output);
		System.out.println("-------------------------------------");
	}
	public static void main(String args[]){
		int[] arr0 = {-4,2,-5,1,-1,6};
		int w0 = 2;
		int w01 = 3;
		int[] exp0 = {2,2,1,1,6};
		int[] exp01 = {2,2,1,6};
		testMaxSW(w0, arr0, exp0);
		testMaxSW(w01,arr0,exp01);
	} 
}