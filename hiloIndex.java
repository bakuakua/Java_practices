import java.util.Arrays;
public class hiloIndex{
	/**
	 * The following function finds the lowest indice 
	 * of a given integer in a sorted array. Binary search will be used
	 * to preserve logn runtime
	 * @param: integer array, key
	 * @return: integer index
	 */
	public static int loInd(int[] arr, int key){
		int lo = 0;
		int hi = arr.length-1;
		int mid = lo + (hi-lo)/2;
		int rtn = -1;
		while (lo<=hi){
			if (arr[mid] >= key){
				hi = mid-1;
				mid = lo + (hi-lo)/2;
			}
			else {
				lo = mid + 1;
				mid = lo + (hi-lo)/2;
			}
		}
		if (lo < arr.length && arr[lo] == key) rtn = lo;
		return rtn;
	}
	/**
	 * The following function finds the highest indice 
	 * of a given integer in a sorted array. Binary search will be used
	 * to preserve logn runtime
	 * @param: integer array, key
	 * @return: integer index
	 */
	public static int hiInd(int[] arr, int key){
		int lo = 0;
		int hi = arr.length-1;
		int mid = lo + (hi-lo)/2;
		int rtn = -1;
		while (lo<=hi){
			if (arr[mid] > key){
				hi = mid-1;
				mid = lo + (hi-lo)/2;
			}
			else {
				lo = mid + 1;
				mid = lo + (hi-lo)/2;
			}
		}
		if (hi < arr.length && arr[hi] == key) rtn = hi;
		return rtn;
	}
	public static void testInd(int[] arr, int key){
		int result_lo = loInd(arr, key);
		int result_hi = hiInd(arr, key);
		System.out.println("Array of interest: "+ Arrays.toString(arr));
		System.out.println("key is: "+Integer.toString(key)+"\n"+"low index is: "+ Integer.toString(result_lo)+"\n"+"high index is: "+ Integer.toString(result_hi));
	}
	public static void main(String[] args){
		int[] arr = {1,2,2,4,4,4,5,5,5,20};
		int key1 = 4;
		int key2 = 9;
		int key3 = 1;
		testInd(arr, key1);
		testInd(arr, key2);
		testInd(arr, key3);
	}
}