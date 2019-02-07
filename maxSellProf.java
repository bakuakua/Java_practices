public class maxSellProf{
	static class Tuple<X, Y> { 
  		public X x; 
  		public Y y; 

  		public Tuple(X x, Y y) { 
    		this.x = x; 
    		this.y = y; 
  	} 
}
	/**
	 * This function takes an array of stock prices and find
	 * the buy and sell date that maximizes profit
	 * @param arr : input array of integers signifying daily price
	 * @return : a tuple of buy and sell prices
	 */
    public static Tuple maxProf(int[] arr){
    	//starting from the first element
    	//initialize current buy, current sell, and max profit
    	//if current profit is greater than max profit, update current
    	//sell to the current array element
    	//if current buy price is greater than the current array element
    	//update it to current array element

    	//edge case where input arr is null or less than 2
    	if (arr == null || arr.length < 2) return null;
    	int current_buy = arr[0];
    	int current_sell = arr[1];
    	int max_profit = arr[1]-arr[0];
    	for (int i = 1; i<arr.length; i++){
    		int current_profit = arr[i] - current_buy;
    		if (current_profit > max_profit){
    			max_profit = current_profit;
    			current_sell = arr[i];
    		}
    		if (current_buy > arr[i]){
    			current_buy = arr[i];
    		}
    	}
    	Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(current_sell-max_profit, current_sell);
    	return result;
    }
    public static void main(String[] args){
    	Tuple result = null;
    	int[] arr = {12,5,9,19,8};
    	result = maxProf(arr);
    	System.out.println(String.format("Best buy price at: %d \nBest sell price at: %d",result.x, result.y));
    }

}