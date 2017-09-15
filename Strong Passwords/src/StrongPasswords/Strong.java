/*Strong.java
David Woelfel
Programming Fundamentals II
COSC 1337
Detect the relative strength of a list of passwords from a file 
 */

package StrongPasswords;
//import java.util.regex.Pattern;


public class Strong {

	//Data fields
	boolean validity = true;
	//Pattern specialChar = Pattern.compile("[!@#\\$%\\^&\\*\\(\\)_\\+\\=]");
	//Pattern upperCase = Pattern.compile("[A-Z+]");
	//Pattern number = Pattern.compile("[\\d+]");
	String password;
	public static final String specials = "!@#$%^&*()_+=";
	char [] conv = specials.toCharArray();


	//Constructors
	public Strong(){
		validity = false;
	}

	public Strong(String pw){
		password = pw.trim();
	}


	//Methods
	public boolean minimum(){
		int up = 0;
		int low = 0;
		int sp = 0;
		int dig = 0;
		char[] array = password.toCharArray();
		for(char a : array){
			if (Character.isUpperCase(a)){
				up += 1;
			} else
				if (Character.isLowerCase(a)){
					low += 1;
				} else
					if (Character.isDigit(a)){
						dig += 1;
					} else
						for (int i = 0; i < array.length; i++){
							for (int d = 0; d < conv.length; d++) {
								if (array[i] == conv[d]){
									sp  += 1;
								}
							}	
						}
		} if (!(dig >=1) || !(up >= 1) || !(low >= 1) || !(sp >= 1)){
			validity = false;
		} 
		return validity;
	}

//A few other methods that failed one way or another but are good snippets
	/*public int checkSpecial (){
		int sp = 0;
		char[] array = password.toCharArray();
		for (int i = 0; i < array.length; i++){
			for (int d = 0; d < conv.length; d++) {
				if (array[i] == conv[d]){
					sp  += 1;
				}
			}	
		} return sp;
	}*/


	/*public boolean validationn(){
		char[] array = password.toCharArray();
		for(char a : array){
			if (!Character.isUpperCase(a) &&
					!(Character.isLowerCase(a)) &&
					!(Character.isDigit(a)) &&
					!(checkSpecial() >= 1)) {
				validity = false;
			}
		} if (!(password.length() >= 8)){
			validity = false;
		} return validity;
	}*/
	
	
	/*public boolean validation(){
	if (!(upperCase.matcher(password).find())){
		validity = false;
	}
	else
		if (!(specialChar.matcher(password).find())){
			validity = false;
		}
		else
			if (!(number.matcher(password).find())){
				validity = false;
			}
			else
				if (password.length() < 8){
					validity = false;
				}

	return validity;
}*/

	
	public String output(){
		String valid = "";
		if (validity == false){
			valid = "\nINVALID";
		}

		if (validity == true){
			valid = "\nSTRONG";
		}
		return valid;
	}
}