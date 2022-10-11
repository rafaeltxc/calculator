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
	
	public List<String> addMultplicationOperation(List<String> lst) {
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).equals("(") && i != 0) {
				if(verifNumber(lst.get(i-1))) {
					lst.add(i, "*");
				}
			}
		}
		return lst;
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
		return result;
	}
	
	public List<String> verifParenthesis(List<String> lst) {
		if(lst.contains("(")) {
			int indexStart = lst.indexOf("(");
			int indexEnd = lst.lastIndexOf(")");
			List<String> temp = new ArrayList<>();
			float result;
			
			lst.remove(indexEnd);
			lst.remove(indexStart);
			for(int i=0; i<indexEnd-indexStart-1; i++) {
				temp.add(lst.get(indexStart));
				lst.remove(indexStart);
			}
			
			temp = verifParenthesis(temp);
			result = operations(temp);
			lst.add(indexStart, String.valueOf(result));
		}
		return lst;
	}
	
	public float result(List<String> lst) {
		float result = 0;
		if(lst.size() > 0) {
			result = operations(lst);
		} else {
			return 0;
		}
		return result;
	}
}
