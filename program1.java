package salerecordpack;

import java.util.*;

public class program1 {

	/*
	*The main method will output the answers to the 4 questions & show how long it took
	*read the CSV file into program 1. It will also show the time taken.
	*
	*/
	
	public static void main(String[] args) {
		
		//Takes in file path from command line arguments
		if (args.length != 1) {
			System.out.println("No CSV File Path Detected.");
			return;
		}
		
		String csvFilePath = args[0];

		//Timers for each major event
		Timer csvReadingTimer = new Timer();
		Timer question1Timer  = new Timer();
		Timer question2Timer  = new Timer();
		Timer question3Timer  = new Timer();
		Timer question4Timer  = new Timer();
		
		//Timer start
		csvReadingTimer.start();
		
		//Method call to read and store the CSV file data in an ArrayList
		ArrayList<SaleRecord> saleRecordArrayList = CSVReader.readCSV(csvFilePath);
		
		//Converting the AL to an Array 
		SaleRecord[] saleRecordsArray = saleRecordArrayList.toArray(new SaleRecord[0]);
		
		//Timer end 
		csvReadingTimer.stop();
		
		System.out.println("Outputs: ");
		System.out.println(csvReadingTimer.getTimeTaken() + " seconds to read the file");
		
		
		//Questions 1 - 4 will be answered and timed in the following code
		
		//Question 1: The average Sale Price in 2022 & time elapsed calculating.
		//Start Timer
		//Using the calcAveSalePrice method to find the answer
		//Stop timer
		//Print the time and answer 
		question1Timer.start();
		double AveSalePrice2022 = SaleRecordAnalyzer.calcAveSalePrice2022(saleRecordsArray);
		question1Timer.stop();
		System.out.println(question1Timer.getTimeTaken() + " seconds to calculate average sale price in 2022");
		System.out.println("The average Sale Price in 2022: " + AveSalePrice2022 );
		
		
		
		//Question 2: The Maximum commission rate & how long it took to find
		//Start Timer
		//Finding maximum commission rate
		//Stop Timer
		question2Timer.start();
		double maxCommRate = SaleRecordAnalyzer.findMaxCommRate(saleRecordsArray);
		question2Timer.stop();
		System.out.println(question2Timer.getTimeTaken() + " seconds  to find maximum commission rate");
		System.out.println("The maximum commission rate: " + maxCommRate );
		
		
		//Question 3:The number of cars sold with car make “Honda” & the time taken to complete
		//Start Timer
		//Finding the number of Honda sold
		//Stop Timer
		question3Timer.start();
		int numOfHonda = SaleRecordAnalyzer.carCountByMake(saleRecordsArray, "Honda");
		question3Timer.stop();
		System.out.println(question3Timer.getTimeTaken() + " seconds to find the number of sales records for Honda");
		System.out.println("The number of cars sold with car make Honda: " + numOfHonda);
		
		
		//Question 4: The number of cars sold that the car was used for only two years or less & time required.
		//Start timer
		//Find number of young cars
		//Stop timer
		question4Timer.start();
		int totalYoungCars = SaleRecordAnalyzer.countOfYoungCars(saleRecordsArray, 2);
		question4Timer.stop();
		System.out.println(question4Timer.getTimeTaken() + " seconds to find the number of sales records for cars used for maximum of 2 years" );
		System.out.println("Number of cars sold with 2 years of usage: " + totalYoungCars);

	}//End of main method
}//End of program1
