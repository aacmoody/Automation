package code;

import java.util.ArrayList;
import java.util.List;

public class RangeRunner {

	
	
	public static void main(String[] args) {
		
		List<RangeRule> rules = new ArrayList<>();
		
		for(String rule: args) {
			
			RangeRule newRule = RuleCreator.create(rule);
			
			if(null != newRule) {
				rules.add(newRule);
			}	
		}
		
		rules = Consolidator.consolidate(rules);
		
		System.out.println(rules.toString());
		
		//Rules is a complete list of all rules reduced to the smallest number
		
	}
}
