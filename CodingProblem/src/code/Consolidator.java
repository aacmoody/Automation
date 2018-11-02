package code;

import java.util.ArrayList;
import java.util.List;

public class Consolidator {

	
	public static List<RangeRule> consolidate(List<RangeRule> rules){
		
		List<RangeRule> finalList = new ArrayList<RangeRule>();
		
		if(rules.size() < 2) {
		
			return rules;
		} else {
			for(RangeRule rule: rules) {
				
				finalList = containsRule(rule, finalList);
			}
			return finalList;
		}
	}
	
	public static List<RangeRule> containsRule(RangeRule rule, List<RangeRule> rules){
		
		if(rules.isEmpty()) {
			rules.add(rule);
			return rules;
		}
		
		for(int i = 0; i < rules.size(); i++) {
			//if myList contains this rule merge else add it
			
			RangeRule currentRule = rules.get(i);
			if(currentRule.hasOverlap(rule)) {
				//these rules need to be merged
				
				int lower;
				int upper;
				
				if(currentRule.getLowerBound() < rule.getLowerBound()) {
					lower = currentRule.getLowerBound();
				}else {
					lower = rule.getLowerBound();
				}
				
				if(currentRule.getUpperBound() > rule.getUpperBound()) {
					upper = currentRule.getUpperBound();
				}else {
					upper = rule.getUpperBound();
				}
				
				rules.add(new RangeRule(lower, upper));
				rules.remove(currentRule);
				return rules;
			}
		}
		rules.add(rule);
		return rules;
	}
	

}
