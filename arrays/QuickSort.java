import java.util.Arrays;
public class QuickSort{
	/** The following function recursively partition the input array
	 * so that the each time the pivote is placed at the correct position
	 * @param arr : input integer array
	 * @param lo : lower bound of the partition range
	 * @param hi : upper bound of the partition range
	 * @return : corret index position of the current pivot 
	 */
	public static int partition(int[] arr, int lo, int hi){
		int pivot_val = arr[lo];
		int i = lo;
		int j = hi;
		while (i<j){
			while (i<=hi && arr[i]<=pivot_val) i++;
			while(arr[j]>pivot_val) j--;
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[lo] = arr[j];
		arr[j] = pivot_val;
		return j;
	}
	/** The following function calls the partition function recursively
	 *  to partition the input array into sub search array
	 *  @param arr : input integer array
	 *  @param lo : lower bound
	 *  @param hi : higher bound
	 */
	public static void quicksort_rec(int[] arr, int lo, int hi){
		if (lo < hi){
			int pivot = partition(arr, lo, hi);
			quicksort_rec(arr, lo, pivot-1);
			quicksort_rec(arr, pivot+1, hi);
		}
	}
	public static int[] quicksort(int[] arr){
		int lo = 0;
		int hi = arr.length-1;
		quicksort_rec(arr, lo, hi);
		return arr;
	}
	public static void main(String[] args){
		int[] arr1 = {10,80,90,30,40,20,70,5};
		int[] result1 = quicksort(arr1);
		System.out.println(Arrays.toString(result1));
	}
}