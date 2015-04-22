package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClimateAverage {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Name of state (all caps): "); 
		String state = scan.next(); 
		String stateIn = state+"Sort.csv";
		String stateOut = state+"Avg.arff";
		
		scan.close(); 
		
		File infile;
		infile = new File(stateIn);
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);

		String line;

		line = br.readLine();

		ClimateRecord firstRecord = new ClimateRecord(line);

		ArrayList<ClimateRecordList> allBuckets = new ArrayList<ClimateRecordList>();
		ClimateRecordList cl = new ClimateRecordList();

		while ((line = br.readLine()) != null) {

			ClimateRecord cr = new ClimateRecord(line);

			String date = cr.getDate();

			if (date.equals(firstRecord.getDate())) {
				cl.addClimateRecord(cr);
			}

			else {
				firstRecord = cr;
				allBuckets.add(cl);
				cl = new ClimateRecordList();

			}
		}


		File fileAverage = new File(stateOut);
		FileWriter fw = new FileWriter(fileAverage, false);
		
		fw.write("@relation state\n\n");
		fw.write("@attribute timestamp DATE \"MM-yyyy\"\n");
		fw.write("@attribute MNTM numeric\n");
		fw.write("@attribute TPCP numeric\n\n");
		fw.write("@data\n");
		for (ClimateRecordList b : allBuckets) {
			
			double temp = b.getMeanTemps()/10;
			temp = Math.round(temp*100.0)/100.0; 
			
			double prec = b.getMeanPrec();
			prec = Math.round(prec*100.0)/100.0;
			
			String date = b.getDate(); 
			
			String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			date = month+"-"+year;
			fw.write(date + "," + temp+","+prec+"\n");
			
			

		}

		fw.close();

	}
	
	

}
