import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.descriptivestatistics.core.DescriptiveStatistics;
import com.descriptivestatistics.core.RandomGeneratorUtility;

/**
 * <h1>Test suite to test functionality of DescriptiveStatistics
 * {@link com.descriptivestatistics.core.DescriptiveStatistics}</h1>
 * @author Yogesh Thakare, Gaurav Amrutkar
 * @version 1.0
 */
public class DescriptiveStatisticsTest 
{
	private DescriptiveStatistics descriptiveStatistics;
	
	 @Before
	 public void setUp() throws Exception 
	 {
	    descriptiveStatistics = new DescriptiveStatistics();
	 }
	 
	 @Test
	 public void testDefaultValuesForStatistics() 
	 {
		 int actualMin=0;
		 int actualMax=0;
		 int actualMode=0;
		 double actualMedian=0.0d;
		 double actualMean=0.0d;
		 double actualSD=0.0d;
		 
		 assertEquals(actualMin, descriptiveStatistics.getMinimum());
		 assertEquals(actualMax, descriptiveStatistics.getMaximum());
		 assertEquals(actualMode, descriptiveStatistics.getMode());
		 assertEquals(actualMedian, descriptiveStatistics.getMedian(),0.0);
		 assertEquals(actualMean, descriptiveStatistics.getArithmaticMean(),0.0);
		 assertEquals(actualSD, descriptiveStatistics.getStandardDeviation(),0.0);
	 }
	 
	 @Test
	 public void testResultsAreMinusOneForEmptyList() 
	 {
		 int expResult= -1;
		 ArrayList<Integer> expmodeList=new ArrayList<Integer>(Arrays.asList(-1));
		 
		 int actualMin=descriptiveStatistics.computeMinimum(new ArrayList<Integer>());
		 int actualMax=descriptiveStatistics.computeMaximum(new ArrayList<Integer>());
		 ArrayList<Integer> actualmodeList=descriptiveStatistics.computeMode(new ArrayList<Integer>());
		 double actualMedian=descriptiveStatistics.computeMedian(new ArrayList<Integer>());
		 double actualMean=descriptiveStatistics.computeArithmaticMean(new ArrayList<Integer>());
		 double actualSD=descriptiveStatistics.computeStandardDeviation(new ArrayList<Integer>());
		 
		 assertEquals(expResult, actualMin);
		 assertEquals(expResult, actualMax);
		 assertEquals(expmodeList, actualmodeList);
		 assertEquals(expResult, actualMedian,0.0);
		 assertEquals(expResult, actualMean,0.0);
		 assertEquals(expResult, actualSD,0.0);
	 }
	 
	 @Test
	 public void testMinimumNumberIsZero() 
	 {
		 int expResult= 0;
		 int actualMin=descriptiveStatistics.computeMinimum(getTestArray());
		 
		 assertEquals(expResult, actualMin);
	 }
	 
	 @Test
	 public void testMaximumNumberIsHundered() 
	 {
		 int expResult= 100;
		 int actualMax=descriptiveStatistics.computeMaximum(getTestArray());
		 
		 assertEquals(expResult, actualMax);
	 }
	 
	 @Test
	 public void testModeHasTwoValues() 
	 {
		 ArrayList<Integer> expmodeList=new ArrayList<Integer>(Arrays.asList(99,15));
		 ArrayList<Integer> actualMode=descriptiveStatistics.computeMode(getTestArray());
		 
		 assertEquals(expmodeList, actualMode);
	 }
	 
	 @Test
	 public void testModeWhenElemtsAreUnique() 
	 {
		 ArrayList<Integer> expmodeList=new ArrayList<Integer>(Arrays.asList(99,15,23,55));
		 ArrayList<Integer> actualModeList=descriptiveStatistics.computeMode(expmodeList);
		 
		 assertTrue(expmodeList.containsAll(actualModeList) && actualModeList.containsAll(expmodeList));	
	 }
	 
	 @Test
	 public void testMedianWhenListSizeIsEven() 
	 {
		 double expResult= 25.5;
		 ArrayList<Integer> evenList =getTestArray();
		 double actualMedian=descriptiveStatistics.computeMedian(evenList);
		 
		 assertEquals(expResult, actualMedian, 0.0);
	 }
	 
	 @Test
	 public void testMedianWhenListSizeIsOdd() 
	 {
		 double expResult= 33.0;
		 ArrayList<Integer> evenList =getTestArray();
		 evenList.remove(0);
		 double actualMode=descriptiveStatistics.computeMedian(evenList);
		 
		 assertEquals(expResult, actualMode,0.0);
	 }
	 
	 @Test
	 public void testArithmaticMeanComputation() 
	 {
		 double expResult= 47.80;
		 double actualMean=descriptiveStatistics.computeArithmaticMean(getTestArray());
		 
		 assertEquals(expResult, actualMean,0.0);
	 }
	 
	 @Test
	 public void testStandardDeviationComputation() 
	 {
		 double tolerance = 1e-10;
		 double expDeviation=23.344549685097807;
		 double actualDeviation=descriptiveStatistics.computeStandardDeviation(getTestArray());
		 double deviationDiff = Math.abs(expDeviation-actualDeviation);
		 
		 assertTrue(deviationDiff < tolerance);
	 }
	 
	 public ArrayList<Integer> getTestArray() 
	 {
		return new ArrayList<Integer>(Arrays.asList(18,0,99,15,15,98,99,33,1,100));
	 }
	 
	 @After
	 public void tearDown() throws Exception 
	 {
		 descriptiveStatistics = null;
	 }
}
