/**
 * Compare two strings s1, s2. Find the longest common
 * subsequence 
 * @param: String s1 
 * @param: String s2
 * @return: String cmnSubstr
 */

public class longestCommonString{
	public static String getCommonSubstring(String s1, String s2){
    	int maxlength = 0;
    	String maxCommon = "";
    	for(int i = 0; i<s1.length(); i++){
    		char tmp = s1.charAt(i);
    		for(int j = 0; j<s2.length(); j++){
    			if (s2.charAt(j)==tmp){
                   String common = "";
                   int offset = 0;
                   while ((i+offset)<s1.length() && (j+offset)<s2.length()){
                   	   char tmpchars1 = s1.charAt(i+offset);
                   	   char tmpchars2 = s2.charAt(j+offset);
                       if(tmpchars2==tmpchars1){
                       		common += tmpchars1;
                       		offset++;
                       }
                       else break;
                   }
                   if(common.length()>maxlength) {
                   		maxlength = common.length();
                   		maxCommon = common;
                   }
    		    }
    		}
    	}
    	return maxCommon;
	}
	public static void testLCS(String s1, String s2, String expected){
		String actual = getCommonSubstring(s1,s2);
		System.out.println("------------------------------------------------------");
		System.out.println("Input strings are: "+s1+", "+s2+"\n"+"Expected longest common substring: "+expected+"\n"+"Actual result: "+actual);
		if (expected.equals(actual)) System.out.println("Test passed!");
		else System.out.println("Test failed!");
		System.out.println("------------------------------------------------------");
	}
	public static void main(String[] arg){
        testLCS("cappled","happleties","apple");
        testLCS("GeeksforGeeks","GeeksQuiz","Geeks");
        testLCS("abcdxyz","xyzabcd","abcd");
        testLCS("","","");
        testLCS("","abc","");
        testLCS("def","def","def");
        testLCS("zxabcdezy", "yzabcdezx", "abcdez");
	}
}