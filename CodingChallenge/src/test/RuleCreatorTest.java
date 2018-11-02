package test;



import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import code.RangeRule;
import code.RuleCreator;

/*
 * @author Andrew AcMoody
 */
public class RuleCreatorTest {

	@Test
	public void testBadRule() {
		RangeRule rule = RuleCreator.create("[1234,2234]");
		
		Assertions.assertNull(rule);
	}
	
	@Test
	public void testValid() {
		
		RangeRule rule = RuleCreator.create("[12345,23456]");
	
		Assertions.assertEquals(12345, rule.getLowerBound());
		Assertions.assertEquals(23456, rule.getUpperBound());
		
	}
	
	@Test
	public void testOrder() {
		RangeRule rule = RuleCreator.create("[23456,12345]");
		
		Assertions.assertNull(rule);
	}
	
	@Test
	public void testNull() {
		
		RangeRule rule = RuleCreator.create("");
		Assertions.assertEquals(null, rule);
		
	}
	
	@Test 
	public void testError() {
		
		RangeRule rule = RuleCreator.create("[12345,12345,12345]");
		Assertions.assertNull(rule);
		
	}
	
	@Test
	public void testCharacters() {
		RangeRule rule = RuleCreator.create("[12345,123we]");
		
		Assertions.assertNull(rule);
	}
	
	@Test
	public void testOverlap01() {
		RangeRule rule = RuleCreator.create("[10000,10100]");
		RangeRule otherRule = RuleCreator.create("[10050,10150]");
		
		Assertions.assertTrue(rule.hasOverlap(otherRule));
	}
	
	
	@Test
	public void testOverlap02() {
		RangeRule rule = RuleCreator.create("[20000,20100]");
		RangeRule otherRule = RuleCreator.create("[19000,20001]");
		
		Assertions.assertTrue(rule.hasOverlap(otherRule));
		
	}
	
	@Test
	public void testOverlap03() {
		RangeRule rule = RuleCreator.create("[20000,20100]");
		RangeRule otherRule = RuleCreator.create("[10000,30000]");
		
		Assertions.assertTrue(rule.hasOverlap(otherRule));

	}
	
	@Test
	public void testOverlap04() {
		RangeRule rule = RuleCreator.create("[10000,10100]");
		RangeRule otherRule = RuleCreator.create("[10050,10055]");
		
		Assertions.assertTrue(rule.hasOverlap(otherRule));

	}

	@Test
	public void testNoOverlap01() {
		RangeRule rule = RuleCreator.create("[50000,50100]");
		RangeRule otherRule = RuleCreator.create("[10050,10055]");
		
		Assertions.assertFalse(rule.hasOverlap(otherRule));
		
	}
	
	@Test
	public void testNoOverlap02() {
		RangeRule rule = RuleCreator.create("[10000,10100]");
		RangeRule otherRule = RuleCreator.create("[50050,50055]");
		
		Assertions.assertFalse(rule.hasOverlap(otherRule));
		
	}
}
