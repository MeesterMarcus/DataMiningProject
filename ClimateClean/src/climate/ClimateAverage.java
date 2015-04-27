package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class essentially merges all the records with the same date by finding
 * the mean of all the temperature means for each station in each date.
 * 
 * @author Marcus Lorenzana
 *
 */

public class ClimateAverage {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter state (abbreviation all caps):");
		String state = scan.next();
		String stateIn = state + "Sort.csv";
		String stateOut = state + "Avg.arff";

		scan.close();

		File infile;
		infile = new File(stateIn);
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);

		String line;

		line = br.readLine();

		// First climate record for reference
		ClimateRecord firstRecord = new ClimateRecord(line);

		// Each bucket represents a date and all the records that fall into
		// said date.
		ArrayList<ClimateRecordList> allBuckets = new ArrayList<ClimateRecordList>();

		// cl is a bucket, that first represents the first date,
		// but a new one is created for the each following date.
		ClimateRecordList cl = new ClimateRecordList();

		while ((line = br.readLine()) != null) {

			ClimateRecord cr = new ClimateRecord(line);

			String date = cr.getDate();

			if (date.equals(firstRecord.getDate())) {
				if (cl.size() == 0) {
					cl.addClimateRecord(firstRecord);
				}
				cl.addClimateRecord(cr);
			}

			else {
				if (cl.size() == 0) {
					cl.addClimateRecord(firstRecord);
				}
				firstRecord = cr;
				allBuckets.add(cl);
				cl = new ClimateRecordList();

			}
		}

		File fileAverage = new File(stateOut);
		FileWriter fw = new FileWriter(fileAverage, false);

		// Output the appropriate headers for Weka .arff file
		// as well as the appropriate date format
		fw.write("@relation " + state + "\n\n");
		fw.write("@attribute timestamp DATE \"MM-yyyy\"\n");
		fw.write("@attribute MNTM numeric\n");
		fw.write("@attribute TPCP numeric\n\n");
		fw.write("@data\n");
		for (ClimateRecordList b : allBuckets) {

			// get mean temps and prec for this bucket
			double temp = b.getMeanTemps() / 10;
			temp = Math.round(temp * 100.0) / 100.0;

			double prec = b.getMeanPrec();
			prec = Math.round(prec * 100.0) / 100.0;

			String date = b.getDate();

			String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			date = month + "-" + year;
			fw.write(date + "," + temp + "," + prec + "\n");

		}

		fw.close();
		br.close();

	}

}
