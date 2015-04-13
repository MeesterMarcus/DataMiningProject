package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Climate cleaning for individual State files (or other). 
 * Sorts the records by month and year and outputs to an arbitrary file. 
 * @author Marcus Lorenzana
 *
 */

public class ClimateCleanDatesAscending {

	public static void main(String[] args) throws IOException {

		/*
		 * Read in an arbitrary file, for this example, using AK which contains
		 * all records pertaining to the state Arkansas
		 */
		File infile;
		infile = new File("States/AK.csv");
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);
		
		/*
		 * Create a list of data which will hold the line of each record
		 * Create a list of data which will hold in ClimateRecord objects
		 */
		ArrayList<ClimateRecord> records = new ArrayList<ClimateRecord>() ;
		

		
		//Read from the file, and remove instances of -9999
		 
		String line;
		line = br.readLine(); 
		while ((line = br.readLine()) != null) {
			if (!line.contains("-9999")) {
				ClimateRecord record = new ClimateRecord(line); 
				records.add(record); 
				

			}

		}
		
		
		
		//Sort the records by date and write to AKSort.csv
		Collections.sort(records, new ClimateDateComparator());
		File sortFile = new File("AKSort.csv");
		FileWriter sortWriter = new FileWriter(sortFile,false); 
		sortWriter.write("STATION,STATION_NAME,DATE,TPCP,MNTM\n"); 
		for (ClimateRecord s : records) {
		
			sortWriter.write(s.toString());
			sortWriter.write("\n"); 		
			
		}
		
		sortWriter.close(); 
		br.close();
		fr.close();

	}

}
