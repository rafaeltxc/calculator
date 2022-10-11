package calculator.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

	public boolean input(String st) {	

		String regex = ".*[a-zA-Z].*";
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(st);
		boolean matches = mt.matches();
		if(matches) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<String> expression(String st) {
        String regex = "(?<=[-+*/()])|(?=[-+*/()])";
		List<String> lst = new ArrayList<String>(Arrays.asList(st.split(regex)));
        return lst;
	}
	
}
