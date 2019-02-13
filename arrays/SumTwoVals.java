import java.util.Hashtable;
public class SumTwoVals{
	/** The following function takes an integer array
	 *  and check if any of the two values withoin 
	 *  sum up to a given integer.
	 *  @param arr : input integer array
	 *  @param sum : target sum
	 *  @return : void
	 */
	 public static boolean checkTwoSum(int[] arr, int sum){
	 	//use a hash table to store the elements of arr 
	 	//into the table. Each iteration check if the difference
	 	//between val in arr and sum exists in table, then 
	 	//put that val into table;
	 	boolean rtn = false;
	 	Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>(arr.length);
	 	for (int i = 0; i<arr.length; i++){
	 		int dif = sum - arr[i];
	 		if (table.containsKey(dif)){
	 			rtn = true;
	 			System.out.println(String.format("Match Found! %d + %d = %d", dif,arr[i],sum));
	 		}
	 		table.put(arr[i], 0);
	 	}
	 	return rtn; 
	 }
	 public static void test(int[] v, int val) {
    	boolean output = checkTwoSum(v, val);
    	
  	 }

  	 public static void main(String[] args) {
     	int[] v = new int[]{2, 1, 8, 4, 7, 3,2};
    	test(v, 3);
    	test(v, 20);
    	test(v, 1);
    	test(v, 2);
    	test(v, 7);
    	test(v,4);
  	 }	

}