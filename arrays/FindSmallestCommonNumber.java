public class FindSmallestCommonNumber{
	/**
	 * The following function takes 3 arrays of integers and 
	 * returns the smallest common integer amongst them 
	 * @param: 3 sorted integer arrays.
	 * @return: the smallest common integer if found, otherwise return -1
	 */
	public static int SCN(int[] arr1, int[] arr2, int[] arr3){
		//get the first elements of each of the three arrays
		//increment pointer for the smallest element till they converge

		int i = 0;
		int j = 0;
		int k = 0;
		while (i<arr1.length && j<arr2.length && k<arr3.length){
			//if i is the smallest pointer
			if (arr1[i]<arr2[j] && arr1[i]<arr3[k]) {
				i++;
			}
			//if j is the smallest pointer......
			else if(arr2[j]<arr1[i] && arr2[j]<arr3[k]){
				j++;
			}
			//if k is the smallest......
			else if(arr3[k]<arr1[i] && arr3[k]<arr2[j]){
				k++;
			}
			//if i,j tie 
			else if(arr1[i] == arr2[j] && arr1[i]<arr3[k]){
				j++;
			}
			//if j,k tie
			else if(arr2[j] == arr3[k] && arr2[j]<arr1[i]){
				j++;
			}
			//if i,k tie
			else if(arr3[k] == arr1[i] && arr1[i]<arr2[j]){
				k++;
			}
			else {
				return arr1[i];
			}

		}
		System.out.println("no common number found.");
		System.exit(0);
		return -1;
	}
	public static void main(String[] args){
		int[] arr1 = {6,7,10,25,30,63,64};
		int[] arr2 = {-1,4,5,6,7,8,50};
		int[] arr3 = {1,7,10,14};
		int result = SCN(arr1,arr2,arr3);
		System.out.println("The smallest common number is: "+Integer.toString(result));
	}
}