package code;

public class RuleCreator {


	
	/*
	 * This class creates rules with the assumption that all rules follow the same format
	 * [*****,*****]
	 */
	public static RangeRule create(String rule) {
		
		int lower;
		int upper;
		
		if(rule.length() < 13) {
			return null;
		}
		
		String[] parts = rule.split(",");
		
		//If the data isn't in pair formated reject
		if(parts.length != 2) {
			return null;
		} else {

			lower = Integer.parseInt(parts[0].substring(1));
			upper = Integer.parseInt(parts[1].substring(0, parts[1].length()-1));
			
			//if the data range is backward reject
			if(upper < lower) {
				return null;
			}
		}
		
		return new RangeRule(lower, upper);
	}
}
