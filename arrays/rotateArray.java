import java.util.Arrays;
public class rotateArray{
	/**
	 * the following function rotate a given integer array by N 
	 * as specified by the input 
	 * @param: integer array; rotation N
	 * @return: rotated array 
	 */
	public static int[] rotate(int[] arr, int N){
		//check for sign of N; if negative, wrap end to front
		//if positive, wrap front to end 
		//1. front swap. starting from (|N| - 1) till |N| - 1 element, swap it arr.length - |N| times ascending index;
		//2. end swap. starting from arr.length - N till arr.length - 1 element, swap it arr.length - |N| times descending index; 
		if (N<0) {
			for (int i = Math.abs(N) - 1; i >= 0; i--){
				int c = 0;
				int j = i+1;
				while (c<(arr.length-Math.abs(N))){
					c++;
					int tmp_i = arr[j-1];
					int tmp_j = arr[j];
					arr[j-1] = tmp_j;
					arr[j] = tmp_i;
					j++;
				}
			}
		}
		else{
			for (int i = arr.length - N; i<arr.length; i++){
				int c = 0;
				int j = i-1;
				while (c<(arr.length-Math.abs(N))){
					c++;
					int tmp_i = arr[j+1];
					int tmp_j = arr[j];
					arr[j+1] = tmp_j;
					arr[j] = tmp_i;
					j--;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		int N = 2;
		int[] result = rotate(arr, N);
		System.out.println(Arrays.toString(result));
	}






}