package code;

/*
 * @author Andrew AcMoody
 */
public class RuleCreator {

	/*
	 * This class creates rules with the assumption that all rules follow the same
	 * format [*****,*****]
	 * This logic is separated from the RangeRule b/c the rules do not need to know anything about their creation
	 */
	public static RangeRule create(String rule) {

		int lower;
		int upper;

		//Ensure the proposed rule is proper length  to our agreed format
		if (rule.length() < 13) {
			return null;
		}

		String[] parts = rule.split(",");

		// If the data isn't in pair formated it will be rejected
		if (parts.length == 2) {
			
			//Try block used to catch malformed rules, a custom error can be thrown here.
			
			try {
				lower = Integer.parseInt(parts[0].substring(1));
				upper = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));

				if (upper < lower) {
					return null;
				}

				return new RangeRule(lower, upper);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
