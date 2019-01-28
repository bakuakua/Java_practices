import java.util.*;
public class RotatedArray{
	/**
	 * This function searches a number from a rotated array
	 * @param: an array of integer 
	 * @param: the integer to be searched
	 * @return: the index of the number if found, -1 if not found.
	 */
	public static int binary_search_mod(int[] arr, int key, int high, int low){
		int mid = low + (high-low)/2;
		if (key == arr[mid]) return mid;
		//if the key lies within the sorted half, always search in that half
        if (key > arr[mid] && key <= arr[high] && arr[mid]<arr[high]) return binary_search_mod(arr, key, high, mid+1);
        else if (key < arr[mid] && key >= arr[low] && arr[mid]>arr[low]) return binary_search_mod(arr,key, mid-1,low);
        //if the key lies within the unsorted half, look for the sorted half within that half
        else if (arr[mid]>arr[high]) return binary_search_mod(arr,key, high, mid+1);
        else if (arr[mid]<arr[low]) return binary_search_mod(arr,key, mid-1,low);
        else return -1;
	}
	public static int search_rotated_array(int[] arr, int key){
		return binary_search_mod(arr,key, arr.length-1,0);
	}
	public static void testSRA(int[] arr, int key, int expected){
		System.out.println("-----------------------------------");
		int result = search_rotated_array(arr,key);
		System.out.println("Array to be searched: "+Arrays.toString(arr));
		System.out.println("Expected output index: "+Integer.toString(expected));
		System.out.println("Actual output index: "+Integer.toString(result));
		System.out.println("-----------------------------------");
	}
	public static void main(String[] args){
		int[] arr1 = {6,7,1,2,3,4,5};
		int[] arr2 = {11, 12, 13, 14, 15 ,16, 17,1,3};
		testSRA(arr1, 7, 1);
		testSRA(arr2, 16,5);
		testSRA(arr1, 8, -1);
		testSRA(arr2, 1, 7);
	}
}