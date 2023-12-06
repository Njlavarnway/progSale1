package salerecordpack;

import java.io.*;
import java.util.*;

public class CSVReader {

	public static ArrayList<SaleRecord> readCSV(String filePath){
		ArrayList<SaleRecord> saleRecord = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			//Skipping the header
			String line = reader.readLine();
			
			while((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				SaleRecord record = new SaleRecord(
						data[0], data[1], data[2], data[3], data[4],
						Integer.parseInt(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), 
						Double.parseDouble(data[8]));
				saleRecord.add(record);
			}
		}catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
			e.printStackTrace();
		}
		
		return saleRecord;
	}
	
	
	
}
