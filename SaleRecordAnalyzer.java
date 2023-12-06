package salerecordpack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SaleRecordAnalyzer {
	
	//Method handling question 1: 2022 Ave Sale Price
	public static double calcAveSalePrice2022(SaleRecord[] saleRecord) {
		//Check for empty array
		if(saleRecord == null || saleRecord.length == 0) {
			return 0.0;
		}
		
		double totalSalePrice2022 = 0.0; //Sum of all 2022 sales
		int count2022 = 0; //Total number of sales in 2022
		
		// Define a date format to parse the "dd-mm-yy" string
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

		// Iterate over the array
		for (SaleRecord record : saleRecord) {
			// Parse the date string to a Date object
			Date saleDate;
			try {
				saleDate = dateFormat.parse(record.getDate());
			} catch (ParseException e) {
				// Handle parsing exception if needed
				continue; // Skip to the next iteration
			}

			// Check if the year of the sale is 2022
			if (getYearFromDate(saleDate) == 2022) {
				totalSalePrice2022 += record.getSalePrice();
				count2022++;
			}
		}
		
		//Calculating the mean sale price 
		return (count2022 > 0) ? totalSalePrice2022/count2022 : 0.0;
	}
	
	// Helper method to extract the year from a Date object
	private static int getYearFromDate(Date date) {
		// Create a Calendar instance and set it to the provided date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		//Extracting the year
		return calendar.get(Calendar.YEAR);
	}
	
	//Method to find Max Commission Rate
	public static double findMaxCommRate(SaleRecord[] saleRecord) {
		//Null check
		if(saleRecord == null || saleRecord.length == 0) {
			return 0.0;// returns 0 if empty
		}
		
		//Initializes with smallest value possible 
		double maxRate = Double.MIN_VALUE;
		
		//walk the array
		for(SaleRecord record : saleRecord) {
			double commRate = record.getCommissionRate();
			//Compare commission rates, store the greater value
			if(commRate > maxRate) {
				maxRate = commRate;
			}
		}
		
		return (maxRate == Double.MIN_VALUE) ? 0.0 : maxRate;
	}
	
	//Method to find number of Honda sold
	public static int carCountByMake(SaleRecord[] saleRecord, String make) {
		//Null check
		if(saleRecord == null || saleRecord.length == 0) {
			return 0;
		}
		
		int carsCounted = 0;
		
		//Walking the array
		for(SaleRecord record : saleRecord) {
			//Checking the cars make
			if(record.getCarMake().equalsIgnoreCase(make)) {
				carsCounted++;
			}
		}
		
		return carsCounted;
	}
	
	//Method to find number of young cars
	public static int countOfYoungCars(SaleRecord[] saleRecord, int maxAge) {
		//Null check
		if(saleRecord == null || saleRecord.length == 0) {
			return 0;
		}
		
		int countedCars = 0;
		int currentYear = 2023;
		
		//Walking the array
		for(SaleRecord record : saleRecord) {
			//comparing the model year to current year
			if(currentYear - record.getCarYear() <= maxAge) {
				countedCars++;
			}
		}
		
		return countedCars;
	}
}
