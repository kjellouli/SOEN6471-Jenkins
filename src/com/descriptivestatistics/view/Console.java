package com.descriptivestatistics.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.descriptivestatistics.core.DescriptiveStatistics;
import com.descriptivestatistics.core.RandomGeneratorUtility;
/**
 * <h1>This class represents TUI for Descriptive Statistics {@link com.descriptivestatistics.core.DescriptiveStatistics}</h1>
 * @version 1.0
 */
public class Console 
{
    private int resultType1;
    private double resultType2;
    private ArrayList<Integer> resultType3;
    private int selection;
    private int range;
    private int count;
    private Scanner input = new Scanner(System.in);
    private boolean exitCalculator = false;
    ArrayList<Integer> randomNumberList;
    private DescriptiveStatistics descriptiveStatistics;
	
     /**
      * This is the main method of application
      * @param args
      */
	 public static void main(String[] args) 
	 {
		   Console console = new Console();
		   console.startApplication();
	 }
	 
	 /**
	  * Method to start console application
	  */
	 public void startApplication() 
	 {		
		 	//continue asking user until exit is pressed
	        while (!exitCalculator) 
	        {
	        	callMenu();
	 		    selection = input.nextInt();
	 		    if(selection!=0)
	 		    {
	 		    	System.out.print("Provide Range: ");
	 		    	range = input.nextInt();
	 		    	System.out.print("Provide Count: ");
	 		    	count = input.nextInt();
	 		    	inIt(range, count);	//Initialize basic data 
	 		    	System.out.println("Generated random number list: "+randomNumberList);
	 		    }
	 
	            switch (selection) 
	            {
	            case 1:
	            	showMinimum();
	                break;
	 
	            case 2:
	            	showMaximum();
	                break;
	 
	            case 3:
	            	showMode();
	                break;
	 
	            case 4:
	            	showMedian();
	                break;
	                
	            case 5:
	            	showMean();
	                break;
	 
	            case 6:
	            	showSD();
	                break;
	            
	            case 7:
	            	showALL();
	                break;
	 
	            case 0:
	                exitCalculator = true;
	                System.out.println("Application Terminated. Thank You. \n");
	                break;
	 
	            default:
	                System.out.println("Please provide proper input \n");
	            }
	        }
	  }
	 
	 /**
	  * This method runs user interactive menu
	  */
	  public void callMenu()
	  {
		    System.out.println("\n        #*#*#*# Descriptive Statistics Calculator #*#*#*#            ");
		    System.out.println("--------------- --------------------------------- ------------------ ");
		  	System.out.println("                  ============================");
 		    System.out.println("                  |      MENU SELECTION      |");
 		    System.out.println("                  ============================");
 		    System.out.println("                  | Options:                 |");
 		    System.out.println("                  |        1. Minimum        |");
 		    System.out.println("                  |        2. Maximum        |");
 		    System.out.println("                  |        3. Mode           |");
 		    System.out.println("                  |        4. Median         |");
 		    System.out.println("                  |        5. Mean           |");
 		    System.out.println("                  |        6. Stand Dev      |");
 		    System.out.println("                  |        7. All            |");
 		    System.out.println("                  |        0. Exit           |");
 		    System.out.println("                  ============================");
 		    System.out.print("Select option: ");
	  }
	  
	  /**
	   * This method initializes application and gets random number list 
	   * on selection of valid option
	   * @param range specifies the maximum number to be generated
       * @param count specifies size of random number list
	   */
	  public void inIt(int range, int count)
	  {
		  randomNumberList=RandomGeneratorUtility.generateRandomNumbers(range, count);
		  descriptiveStatistics=new DescriptiveStatistics();
	  }
	  
	  /**
	   * Method to show minimum value from random number list
	   */
	  public void showMinimum()
	  {
		  resultType1 = descriptiveStatistics.computeMinimum(randomNumberList);
          System.out.println("Minimum is: " + resultType1);
	  }
	  
	  /**
	   * Method to show maximum value from random number list
	   */
	  public void showMaximum()
	  {
		  resultType1 = descriptiveStatistics.computeMaximum(randomNumberList);
          System.out.println("Maximum is: " + resultType1);
	  }
	  
	  /**
	   * Method to show mode value from random number list
	   */
	  public void showMode()
	  {
		  resultType3 = descriptiveStatistics.computeMode(randomNumberList);
		  if(resultType3.size()==1)
          System.out.println("Mode is: " + resultType3.get(0));
		  else
		  {
			  System.out.print("Modes are: ");
			  for(int mode:resultType3)
			  {
				  System.out.print(mode+" ");
			  }
		  }
	  }
	  
	  /**
	   * Method to show median value from random number list
	   */
	  public void showMedian()
	  {
		  resultType2 = descriptiveStatistics.computeMedian(randomNumberList);
          System.out.println("Median is: " + resultType2);
	  }
	  
	  /**
	   * Method to show mean from random number list
	   */
	  public void showMean()
	  {
		  resultType2 = descriptiveStatistics.computeArithmaticMean(randomNumberList);
          System.out.println("Mean is: " + resultType2);
	  }
	  
	  /**
	   * Method to show standard deviation from random number list
	   */
	  public void showSD()
	  {
		  resultType2 = descriptiveStatistics.computeStandardDeviation(randomNumberList);
          System.out.println("Standard Deviation is: " + resultType2);
	  }
	  
	  /**
	   * Method to show all statistics
	   */
	  public void showALL()
	  {
		  showMinimum();
		  showMaximum();
		  showMode();
		  showMedian();
		  showMean();
		  showSD();
	  }
}