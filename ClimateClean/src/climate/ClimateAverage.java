package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClimateAverage {
	public static void main(String args[]) throws IOException {
		File infile;
		infile = new File("AKSort.csv");
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);

		String line;
		String header;

		header = br.readLine();
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

		System.out.println("DATE,TEMP\n");
		for (ClimateRecordList b : allBuckets) {

			System.out.printf("%s,%.2f\n", b.getDate(), b.getMeanTemps() / 10);

		}

		File fileAverage = new File("AKavg.csv");
		FileWriter fw = new FileWriter(fileAverage, false);
		fw.write("DATE,TEMP\n");
		for (ClimateRecordList b : allBuckets) {
			
			double temp = b.getMeanTemps()/10;
			temp = Math.round(temp*100.0)/100.0; 
			System.out.println(temp); 
			fw.write(b.getDate() + "," + temp+"\n");

		}

		fw.close();

	}

}
