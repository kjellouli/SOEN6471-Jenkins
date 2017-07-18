package com.descriptivestatistics.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Calculates Descriptive Statistics</h1>
 * The DescriptiveStatistics calculates mathematical statistics and
 * return result back to the Console {@link com.descriptivestatistics.view.Console}
 * @version 1.0
 */
public class DescriptiveStatistics 
{
	private int minimum;
	private int maximum;
	private int mode;
	private double median;
	private double arithmaticMean;
	private double standardDeviation;
	
	/**
	 * getter for minimum
	 * @return minimum
	 */
	public int getMinimum() 
	{
		return minimum;
	}
	
	/**
	 * setter for minimum
	 * @param minimum
	 */
	public void setMinimum(int minimum) 
	{
		this.minimum = minimum;
	}
	
	/**
	 * getter for Maximum
	 * @return maximum from the list
	 */
	public int getMaximum() 
	{
		return maximum;
	}
	
	/**
	 * setter for maximum
	 * @param maximum
	 */
	public void setMaximum(int maximum) 
	{
		this.maximum = maximum;
	}
	
	/**
	 * getter for mode
	 * @return mode from the list
	 */
	public int getMode() 
	{
		return mode;
	}

	/**
	 * setter for mode
	 * @param mode
	 */
	public void setMode(int mode) 
	{
		this.mode = mode;
	}

	/**
	 * getter for median
	 * @return median from the list
	 */
	public double getMedian() 
	{
		return median;
	}

	/**
	 * setter for median
	 * @param median
	 */
	public void setMedian(double median) 
	{
		this.median = median;
	}

	/**
	 * getter for arithmaticMean
	 * @return mean from the list
	 */
	public double getArithmaticMean() 
	{
		return arithmaticMean;
	}
	
	/**
	 * setter for arithmaticMean
	 * @param arithmaticMean
	 */
	public void setArithmaticMean(double arithmaticMean) 
	{
		this.arithmaticMean = arithmaticMean;
	}

	/**
	 * getter for standardDeviation
	 * @return standard deviation from the list
	 */
	public double getStandardDeviation() 
	{
		return standardDeviation;
	}

	/**
	 * setter for standardDeviation
	 * @param standardDeviation
	 */
	public void setStandardDeviation(double standardDeviation) 
	{
		this.standardDeviation = standardDeviation;
	}
	
	/**
	 * This method finds minimum from the list
	 * @param randomNumberList the list from which minimum value to be found
	 * @return minimum value from the list
	 */
	public int computeMinimum(ArrayList<Integer> randomNumberList)
	{
		 //handle base case
		 if (randomNumberList == null || randomNumberList.isEmpty()) 
		 {
			 return -1;
		 }
		//handle base case
		 else if(randomNumberList.size()==1)
		 {
			 return randomNumberList.get(0);
		 }
		 try
		 {
			 minimum = randomNumberList.get(0);
			 for (int i = 0; i < randomNumberList.size(); i++) 
			 {
				 if (minimum > randomNumberList.get(i)) 
				 {
					 minimum = randomNumberList.get(i);
				 }
			 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 
		 return minimum;
	}
	
	/**
	 * This method finds maximum from the list
	 * @param randomNumberList the list from which maximum value to be found
	 * @return maximum value from the list
	 */
	public int computeMaximum(ArrayList<Integer> randomNumberList)
	{
		 //handle base case
		 if (randomNumberList == null || randomNumberList.isEmpty()) 
		 {
			 return -1;
		 }
		 //handle base case
		 else if(randomNumberList.size()==1)
		 {
			 return randomNumberList.get(0);
		 }
		 try
		 {
			 maximum = randomNumberList.get(0);
			 for (int i = 0; i < randomNumberList.size(); i++) 
			 {
				 if (maximum < randomNumberList.get(i)) 
				 {
					 maximum = randomNumberList.get(i);
				 }
			 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 
		 return maximum;
	}
	
	/**
	 * This method calculates most frequently occurred value(mode) from the list
	 * @param randomNumberList the list from which mode to be found
	 * @return mode(s) from the list
	 */
	public ArrayList<Integer> computeMode(ArrayList<Integer> randomNumberList)
	{
		final ArrayList<Integer> modeList = new ArrayList<Integer>();
	    final HashMap<Integer, Integer> modeMap = new HashMap<Integer, Integer>();
		 
		 //handle base cases
		 if (randomNumberList == null || randomNumberList.isEmpty()) 
		 {
			 modeList.add(-1);
			 return modeList;
		 }
		 else if(randomNumberList.size()<=2)
		 {
			 modeList.addAll(randomNumberList);
			 return modeList;
		 }
		 try
		 {
			 int max = 1;
			    for (int n : randomNumberList) 
			    {
			        int count = 0;      
			        //increment count if key already present
			        if (modeMap.containsKey(n)) 
			        {
			            count = modeMap.get(n)+1;
			            modeMap.put(n, count);
			        } 
			        //count is set to 1 if new key found
			        else 
			        {
			            count = 1;
			            modeMap.put(n, count);
			        }

			        if (count > max) 
			        {
			            max = count;
			        }
			    }
			    //find key corresponding to maximum values from map
			    for (final Map.Entry<Integer, Integer> map : modeMap.entrySet()) 
			    {
			        if (map.getValue() == max) 
			        {
			            modeList.add(map.getKey());
			        }
			    }

			    return modeList;
		 }
	 	catch(Exception ex)
	    {
		  ex.printStackTrace();
	    }
		 
		 return modeList;
	}
	
	/**
	 * This method calculates median from the list
	 * @param randomNumberList the list from which median to be calculated
	 * @return median from the list
	 */
	public double computeMedian(ArrayList<Integer> randomNumberList)
	{
		 //handle base case
		 if (randomNumberList == null || randomNumberList.isEmpty()) 
		 {
			 return -1;
		 }
		 //handle base case
		 else if(randomNumberList.size()==1)
		 {
			 return randomNumberList.get(0);
		 }
		 try
		 {
			 bubbleSort(randomNumberList);
			 double middle = randomNumberList.size()/2;
			 //middle number if list size is odd
			 if (randomNumberList.size()%2 == 1) 
			 {
				 median = randomNumberList.get((int) middle);
			 }
			 //Arithmetic mean if list size is even
			 else
			 {
				median = (randomNumberList.get((int) (middle - 1)) + randomNumberList
						.get((int) middle)) / 2d; // saves precision of answer
			 }
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 
		 return median;
	}
	
	/**
	 * This method calculates arithmetic mean(average) of all values from the list
	 * @param randomNumberList the list from which mean to be calculated
	 * @return mean of all values from the list
	 */
	public double computeArithmaticMean(ArrayList<Integer> randomNumberList)
	{
		 //handle base case
		 if (randomNumberList == null || randomNumberList.isEmpty()) 
		 {
			 return -1;
		 }
		 //handle base case
		 else if(randomNumberList.size()==1)
		 {
			 return randomNumberList.get(0);
		 }
		 try
		 {
			 double sum = 0;
			 for (Integer number : randomNumberList) 
			 {
				 sum += number;
			 }
			 arithmaticMean=(double)sum / (double)randomNumberList.size();
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 
		 return arithmaticMean;
	}
	
    /**
     * This method calculates standard deviation of all values from the list
     * References: @see <a href="https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance/">
	 * Algorithms for calculating variance</a> reference for variance algorithm.
     * @param randomNumberList the list from which mean to be calculated
     * @return standard deviation of all values from the list
     */
	public double computeStandardDeviation(ArrayList<Integer> randomNumberList)
	{
		//handle base case
		if (randomNumberList == null || randomNumberList.isEmpty()) 
		{
			 return (double)-1;
		}
		//handle base case
		else if(randomNumberList.size()==1)
		{
			 return (double)0;
		}
		try
		{
			arithmaticMean = computeArithmaticMean(randomNumberList);
			double meanDiff = 0;
			double temp = 0;
			//take each difference, square it, and then average the result to get variance
			for (Integer number : randomNumberList) 
			{
				meanDiff = (number - arithmaticMean);
				temp= meanDiff * meanDiff;
				temp += temp;
			}
			double variance = (double) temp / (double) (randomNumberList.size());
			standardDeviation=sqrt(variance);
		}
		catch(Exception ex)
		{
			 ex.printStackTrace();
		}
		
	    return standardDeviation;
	}
	
	/**
	 * This method sorts the list using bubble sort algorithm
	 * References: @see <a href="http://www.javatechblog.com/java/java-program-to-sort-arraylist-without-using-collections/">
	 * </a> reference for bubbleSort algorithm.
	 * @param randomNumberList the list to be sorted
	 * @return sorted list in ascending order
	 */
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> randomNumberList) 
	{
		try
		{
			for (int i = 0; i < randomNumberList.size(); i++) 
		    	{
	            	for (int j = 0; j < randomNumberList.size() - i - 1; j++) 
	                {
	            		if (randomNumberList.get(j) > randomNumberList.get(j + 1)) 
	            		{
	            			int temp = randomNumberList.get(j);
	            			//Replaces the element at the specified position in this list with the specified element
	            			randomNumberList.set(j, randomNumberList.get(j + 1));
	            			randomNumberList.set(j + 1, temp);
	            		}
	                }
		    	}
		}
		catch(Exception ex)
		{
			 ex.printStackTrace();
		}
		
		return randomNumberList;
	}
	
	/**
	 * This method calculates the square root of a number
	 * References: @see <a href="https://en.wikipedia.org/wiki/Methods_of_computing_square_roots">
	 * Methods of computing square roots</a> reference for square roots algorithm.
	 * @param number for square root to be calculated
	 * @return square root
	 */
	public double sqrt(double number) 
	{
		double temp;
		double sqrt = number / 2;
		do 
		{
			temp = sqrt;
			sqrt = (temp + (number / temp)) / 2;
		} 
		while (temp != sqrt);
	 
		return sqrt;
	}
}
