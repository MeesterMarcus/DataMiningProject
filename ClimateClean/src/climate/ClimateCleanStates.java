package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		Scanner in = new Scanner(System.in);
		System.out
				.println("It is not necessary to run as state files are in this directory.");
		System.out
				.println("But if you would like to see how it works, you may continue.");
		System.out.println("Please remove state files before running.");
		System.out.println("\nIs the States directory empty? (y/n)");
		String answer = in.nextLine();
		answer = answer.toLowerCase(); 

		if (answer.equals("n")) {
			in.close();
			System.exit(0);
			
		}
		System.out.println("Would you like to run the program? (y/n)");
		String answer2 = in.nextLine();
		answer2 = answer2.toLowerCase(); 
		if (answer2.equals("n")) {
			in.close();
			System.exit(0);
			
		}


		File dir, infile;

		// Create files for each states
		dir = new File("States");
		dir.mkdir();

		infile = new File("climatedata.csv");
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);

		String line;
		line = br.readLine();
		System.out.println();

		// Read in climatedata.csv
		final long start = System.currentTimeMillis();
		Pattern p = Pattern.compile(".* ([A-Z][A-Z]) US");
		Map<String, FileWriter> fileMap = new HashMap<String, FileWriter>();
		String stateFileName=null;

		while ((line = br.readLine()) != null) {
		    if (!line.contains("-9999")) {
		    	Matcher m = p.matcher(line);
		        if (m.find()) {
		            stateFileName = m.group(1); 
		            stateFileName = "States/" + stateFileName + ".csv";
		            FileWriter stateFileWriter = fileMap.get(stateFileName);
		            if (stateFileWriter == null) {
		                stateFileWriter = new FileWriter(stateFileName, true);
		                fileMap.put(stateFileName, stateFileWriter);
		            }

		            stateFileWriter.write(line + "\n");
		        }
		    }
		}

		// flush the writers and close once you have parsed the entire file
		for(Map.Entry<String, FileWriter> entry : fileMap.entrySet()) {
		    FileWriter writer = entry.getValue();
		    writer.flush();
		    writer.close();
		}
		System.out.println("Elapsed " + (System.currentTimeMillis() - start)
				+ " ms");
		br.close();
		fr.close();
		in.close();


	}

}
