import java.util.Arrays;
public class mvZeroLeft{
	/**
	 * This function moves all occurance of zeros in an array
	 * to the left while maintaining the relative order of the
	 * none-zero elements.
	 * @param arr : input integer array containing arbitrary numbers of zeros
	 * @return : a modified array
	 */
	public static int[] mvzeroleft(int[] arr){
		//scan the array element wise
		//count number of none-zero elements during each increment
		//if zero occurs, swap it leftward n times where n is the count of
		//previously seen none-zero elements. 
		int count = 0;
		for (int i = 0; i<arr.length; i++){
			if (arr[i] != 0) count++;
			else{
				int j = count;
				int k = i;
				while (j > 0) {
					int tmp_i = arr[k];
					int tmp_j = arr[k-1];
					arr[k] = tmp_j;
					arr[k-1] = tmp_i;
					k--;
					j--;
				}
			}
		}
		return arr;
	}
	//however the above method is not O(n)
	//here is an O(n) method
	public static int[] zlft(int[] arr){
		//keep read/write index at the end of the array
		//if read index is 0 decrement read, write stays
		//if read index is none-0 write it to write index
		//then decrement read and write
		int read = arr.length-1;
		int write = arr.length-1;
		while(write >= 0){
			if (read < 0){
				arr[write] = 0;
				write--;
			}
			else{
				if (arr[read]==0) read--;
				else{
					arr[write] = arr[read];
					write--;
					read--;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args){
		int[] arr = {1,1,0,1,0,2,1,9,9,3,0,2,0,1,1,1,1,4};
		//int[] result = mvzeroleft(arr);
		System.out.println("input array: "+Arrays.toString(arr));
		int[] result2 = zlft(arr);
		System.out.println("modified array: "+Arrays.toString(result2));
	}




}