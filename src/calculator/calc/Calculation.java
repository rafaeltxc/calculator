package calculator.calc;

import java.util.ArrayList;
import java.util.List;

public class Calculation {	

	public boolean verifNumber(String str) {
		try {
			Float.parseFloat(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public float operations(List<String> lst) {
		float result = 0f;
		
		float nm1 = 0f;
		String operation = null;
		float nm2 = 0f;
				
		while(lst.contains("*") || lst.contains("/")) {
			
			int idxNm = 0;
			
			for(int i=0; i<lst.size(); i++) {
				if(lst.get(i).equals("*") || lst.get(i).equals("/")) {
					idxNm = i - 1;
					nm1 = Float.valueOf(lst.remove(idxNm)).floatValue();
					operation = lst.remove(idxNm);
					nm2 = Float.valueOf(lst.remove(idxNm)).floatValue();
					break;
				}
			}
			
			if(operation.equals("*")) {
				result = nm1 * nm2;
			} else if(operation.equals("/")) {
				result = nm1 / nm2;
			}
			
			lst.add(idxNm, Float.toString(result));			
		}
				
		while(lst.size() > 1) {
			
			nm1 = Float.valueOf(lst.remove(0)).floatValue();
			operation = lst.remove(0);
			nm2 = Float.valueOf(lst.remove(0)).floatValue();
			
			if(operation.equals("+")) {
				result = nm1 + nm2;
			} else {
				result = nm1 - nm2;
			}
			
			lst.add(0, Float.toString(result));
		}
		
		try {
			if(lst.size() == 1) {
				result = Float.valueOf(lst.get(0)).floatValue();
				return result;
			}
		} catch(Exception e) {
			System.out.println("The length of the list is higher than one");
		}
		return 0;
	}
	
	public float result(List<String> lst) {
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).equals("(") && i != 0) {
				if(verifNumber(lst.get(i-1)) == true) {
					lst.add(i, "*");
				}
			}
		}
		
		int indexStart = 0;
		int indexFinal = 0;
		
		float result = 0f;
		
		List<String> temp = new ArrayList<String>();
		
		while(lst.contains("(")) {
			indexStart = lst.indexOf("(");
			indexFinal = lst.indexOf(")");
			
			for(int i=indexStart; i<=indexFinal; i++) {
				if(i != indexStart && i != indexFinal) {
					temp.add(lst.get(indexStart));
				}
				lst.remove(indexStart);
			}
			
			result = operations(temp);
			lst.add(indexStart, Float.toString(result));
			
		}
		
		if(lst.size() > 0) {
			result = operations(lst);
		}
		
		return result;
	}
}
