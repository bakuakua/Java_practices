import java.util.ArrayList;
public class MergeOverlappingIntervals{
	static class Tuple<X, Y> { 
  		public X x; 
  		public Y y; 

  		public Tuple(X x, Y y) { 
    		this.x = x; 
    		this.y = y; 
  		} 
	}
	/** The following function merges an array off tuples that represent 
	 *  lower and upper bound of an interval. For instance: [1,5],[3,8] -> [1,8]
	 *  Be mindful that the ouput is not necessarily one tuple. It should
	 *  also be an list of tuples because intervals may not always overlap.
	 *  Note: input intervals are sorted 
	 *  @param arr : ArrayList of integer tuples
	 *  @return : ArrayList of integer tuples
	 */
	public static ArrayList<Tuple<Integer,Integer>> merge(ArrayList<Tuple<Integer,Integer>> arr){
		ArrayList<Tuple<Integer,Integer>> rtn = new ArrayList<Tuple<Integer,Integer>>();
		//iterate over the input array
		//compare the upper bound of the current tuple to the lower bound of the next
		//if current upper bound is greater than or equal to the next lower bound, then we can merge
		//otherwise we can't merge so we scan next
		
		rtn.add(new Tuple<Integer,Integer>(arr.get(0).x,arr.get(0).y));
		for (int i = 1; i<arr.size(); i++){
			if ((rtn.get(rtn.size()-1).y) >= arr.get(i).x){
				rtn.set(rtn.size()-1,new Tuple<Integer,Integer>(Math.min(rtn.get(rtn.size()-1).x,arr.get(i).x), Math.max(rtn.get(rtn.size()-1).y,arr.get(i).y)));
			}
			else{
				rtn.add(arr.get(i));
			}
		}
		return rtn;
	}
	public static void main(String[] args){
		ArrayList<Tuple<Integer,Integer>> v1 = new ArrayList<Tuple<Integer,Integer>>();

	    Tuple<Integer,Integer> t1 = new Tuple<Integer,Integer>(2,10);
	    Tuple<Integer,Integer> t2 = new Tuple<Integer,Integer>(4,12);
	    Tuple<Integer,Integer> t3 = new Tuple<Integer,Integer>(13,16);
	    Tuple<Integer,Integer> t4 = new Tuple<Integer,Integer>(19,20);
	    Tuple<Integer,Integer> t5 = new Tuple<Integer,Integer>(20,24);

	    v1.add(t1);
	    v1.add(t2);
	    v1.add(t3);
	    v1.add(t4);
	    v1.add(t5);
	    ArrayList<Tuple<Integer,Integer>> v2 = merge(v1);
	    for(int i=0 ; i < v2.size() ; i++){
      		System.out.print(String.format("{%d,%d) ",v2.get(i).x,v2.get(i).y));
    	}
	}

}