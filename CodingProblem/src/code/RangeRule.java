package code;

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
	 * Types of overlap (4)
	 * upper bound extends into this bound
	 * lower bound extends into this bound
	 * entire range is within this range
	 * this range is within other range
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
	
	@Override
	public String toString() {
		return "Rule[ lowerBound: " + lowerBound + " upperBound: " + upperBound + " ]";
	}
	
}
