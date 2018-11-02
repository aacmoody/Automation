package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import code.Consolidator;
import code.RangeRule;

/*
 * @author Andrew AcMoody
 */
public class ConsolidatorTest {

	@Test
	public void test00() {
		List<RangeRule> rules = new ArrayList<>();
		
		rules = Consolidator.consolidate(rules);
		
		Assertions.assertEquals(0, rules.size());
		
	}
	
	@Test
	public void test01() {
		
		List<RangeRule> rules = new ArrayList<>();
		
		rules.add(new RangeRule(12345, 23456));
		
		Assertions.assertEquals(1,  rules.size());
		
		rules = Consolidator.consolidate(rules);
		
		Assertions.assertEquals(1, rules.size());
		
	}
	
	@Test
	public void test02() {
		
		List<RangeRule> rules = new ArrayList<>();
		
		rules.add(new RangeRule(12345, 23455));
		rules.add(new RangeRule(23457,30000));
		
		Assertions.assertEquals(2,  rules.size());
		
		rules = Consolidator.consolidate(rules);

		Assertions.assertEquals(2, rules.size());
		
	}
	
	@Test
	public void test03() {
		
		List<RangeRule> rules = new ArrayList<>();
		
		rules.add(new RangeRule(12345, 23456));
		rules.add(new RangeRule(23455,30000));
		
		Assertions.assertEquals(2,  rules.size());
		
		List<RangeRule> result = Consolidator.consolidate(rules);
		
		Assertions.assertEquals(1, result.size());
		
	}
	
	@Test
	public void test04() {
		
		List<RangeRule> rules = new ArrayList<>();
		
		rules.add(new RangeRule(12345, 23456));
		rules.add(new RangeRule(23457,30000));
		
		Assertions.assertEquals(2,  rules.size());
		
		List<RangeRule> result = Consolidator.consolidate(rules);
		
		Assertions.assertEquals(1, result.size());
		
	}

	
	
}
