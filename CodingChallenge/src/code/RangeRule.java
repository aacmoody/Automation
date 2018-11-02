package code;

/*
 * @author Andrew AcMoody
 * Simple model that can contain properties of rule
 * Will allow for rules to grow in complexity and maintain readability throughout code
 */
public class RangeRule {

	private int lowerBound;
	private int upperBound;
	
	public RangeRule(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}
	
	
	/*
	 * @param RangeRule
	 * Types of overlap (4) and adjacent numbers
	 * Logic is left as a series of if statements rather than a complex boolean statement for
	 * clarity and ability to add additional rules
	 */
	public boolean hasOverlap(RangeRule otherRule) {
		if(otherRule.upperBound > this.lowerBound && otherRule.upperBound < this.upperBound) {
			return true;
		} else if (otherRule.lowerBound > this.lowerBound && otherRule.lowerBound < this.upperBound){
			return true;
		} else if(otherRule.lowerBound < this.lowerBound && otherRule.upperBound > this.upperBound) {
			return true;
		} else if(otherRule.lowerBound == this.upperBound+1 || otherRule.upperBound +1 == this.lowerBound) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Simple method to show model of object 
	 * Good for debugging
	 */
	@Override
	public String toString() {
		return "Rule[ lowerBound: " + lowerBound + " upperBound: " + upperBound + " ]";
	}
	
}
