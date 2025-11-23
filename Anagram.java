/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("aabc","abcc"));

		// Tests the preProcess function.
		System.out.println(preProcess("Good:MorNing!G"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String preStr1 = preProcess(str1);
		String preStr2 = preProcess(str2);
		String temp = preStr2;
		boolean ans = false;

		if (preStr1.length() == preStr2.length()){

			for (int i = 0; i < preStr1.length(); i++){
				char ch = preStr1.charAt(i);

				int j = 0;
				while ( j < temp.length()){
					char ch2 = temp.charAt(j);
					 
					if (ch == ch2) {
						temp = temp.substring(0, j) + temp.substring(j + 1);
						break;
					} 
					else {
						j++;
					}
				}
			}
			if (temp.length() == 0){
					ans = true;
				} 
				else {
					ans = false;
				}
		} 
			else {
			ans = false;
		}

		return ans;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String ans = "";
		int i = 0;

		while (i < str.length()){
			char ch = str.charAt(i);

			if ( ch == ' '){
				i++;
			}

			else if ( ch >= (char)(65) && ch <= (char)(90)){
				ch = (char) (ch +32); 
				ans = ans + ch;
				i++;
			}

			else if (ch >= (char)(33) && ch <= (char)(64)){
					i++;
			}

			else {
				ans = ans + ch;
				i++;
			}
			
		}
		return ans;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String copyString = str;
		String ans = "";

		for (int i = 0; i < str.length(); i++){
			int temp = (int) (Math.random() * (copyString.length()));
			char ch = copyString.charAt(temp);
			ans += ch;
			copyString = copyString.substring(0, temp) + copyString.substring(temp + 1);
		}
		
		return ans;
	}
}
