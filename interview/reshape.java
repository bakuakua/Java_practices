public class reshape{
	public static String reshape(int n, String str){
		str = str.replaceAll("\\s+", "");
		System.out.println(str);
		String rtn = "";
		for (int i  = 0; i<str.length();i++){
			if (i%n == 0 && i !=0 && i>n-1) {
				rtn+= "\n";
		    }
			rtn += str.charAt(i);
		}
		return rtn;
	}
	public static void main(String args[]){
		System.out.println(reshape(4,"1 2 3 4 56 789"));
	}
}