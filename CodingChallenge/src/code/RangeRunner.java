package code;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Andrew AcMoody
 * This class runs the project
 * 
 * Project uses smaller classes with ownership to keep code clear, add flexibility and maintainability
 */
public class RangeRunner {

		public static void main(String[] args) {
		
		List<RangeRule> rules = new ArrayList<>();

		//Create/Parse a list of all rules from possible different locations
		for(String rule: args) {
			
			RangeRule newRule = RuleCreator.create(rule);
			
			if(null != newRule) {
				rules.add(newRule);
			}	
		}

		//Once rules have been established, rules can be reduced if there is any overlap or redundancies
		rules = Consolidator.consolidate(rules);
		//Rules is a reduced list
		System.out.println(rules.toString());
		
	}
}
