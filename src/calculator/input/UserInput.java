package calculator.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

	private Scanner sc = new Scanner(System.in);
	
	public String input() {	
		System.out.println("Insert your calc");
		String stringInput = sc.nextLine();

		String regex = ".*[a-zA-Z].*";
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(stringInput);
		boolean matches = mt.matches();
		
		while(matches == true) {
			System.out.println("Invalid operation!");
			stringInput = sc.nextLine();
			
			mt = pt.matcher(stringInput);
			matches = mt.matches();
		}
		
		sc.close();
		return stringInput;
	}
	
	public List<String> expression(String st) {
		String finalWord = "";

		for(int i=0; i<st.length(); i++) {
			if(st.charAt(i) != ' ') {
				finalWord += st.charAt(i);
			}
		}
		
        String regex = "(?<=[-+*/()])|(?=[-+*/()])";
		List<String> lst = new ArrayList<String>(Arrays.asList(finalWord.split(regex)));
        return lst;
	}
	
}
