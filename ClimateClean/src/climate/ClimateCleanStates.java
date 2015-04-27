package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program will read in a large file containing many stations and states,
 * and output in order the stations to their corresponding state file.
 * 
 * Note: This take a long time depending on processor. It also appends data to
 * the files so you must remove all the state files in the current directory
 * before running for accuracy.
 * 
 * @author Marcus Lorenzana
 *
 */

public class ClimateCleanStates {

	public static void main(String[] args) throws IOException {
		String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC",
				"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
				"LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE",
				"NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR",
				"PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA",
				"WV", "WI", "WY" };

		String[] statesSpaced = new String[51];

		File statefile, dir, infile;

		// Create files for each states
		dir = new File("States");
		dir.mkdir();

		// Modify array so there is a space between state abbreviations.
		for (int i = 0; i < states.length; i++) {
			String state = states[i];
			String space_state = " " + state + " ";
			statesSpaced[i] = space_state;
			System.out.print(i + " : " + states[i] + "\n");
		}

		infile = new File("climatedata.csv");
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);

		String line;
		System.out.println();

		// Read in climatedata.csv
		// Probably need to implement ClimateRecord class
		while ((line = br.readLine()) != null) {
			// Remove instances of -9999
			if (!line.contains("-9999")) {
				for (int i = 0; i < states.length; i++) {

					if (line.contains(statesSpaced[i])) {

						// Create and select state file
						String stateFileName = states[i];
						stateFileName = "States/" + stateFileName + ".csv";
						statefile = new File(stateFileName);

						FileWriter stateWriter = new FileWriter(statefile, true);
						stateWriter.write(line + "\n");
						// Progress reporting
						System.out.printf("Writing [%s] to file [%s]\n", line,
								statefile);
						stateWriter.flush();
						stateWriter.close();

					}

				}

			}

		}
		br.close();
		fr.close();

	}

}
