package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClimateCleanMain {

	public static void main(String[] args) throws IOException {
		String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA", 
		          "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", 
		          "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
		          "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", 
		          "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
		
		String[] statesSpaced = new String[51];
		
		ArrayList<String> climateData = new ArrayList<String>(); 
		boolean writeToFiles = false; 
		File statefile,dir,infile;
		
		//Create files for each states
		dir = new File("States");
		dir.mkdir(); 
		
		//Modify array so there is a space between state abbreviations.
		for (int i = 0; i < states.length; i++) {
			String state = states[i]; 
			String space_state = " "+state+" ";
			statesSpaced[i] = space_state; 
			System.out.print(i+" : "+states[i]+"\n");
		}
		
		
		infile = new File("climatedata.csv");
	    FileReader fr = new FileReader(infile);
	    BufferedReader br = new BufferedReader(fr);
	    
	    String line;
	    System.out.println(); 
	    
	    //Read in climatedata.csv
	    Scanner in = new Scanner(System.in); 
	    System.out.println("[1. Save to ArrayList] [2. Save To Individual State Files]:");
	    String answer = in.nextLine(); 
	    if (answer.equals("1")) {
	    	System.out.println("Selected Save to List"); 
	    	writeToFiles = false; 
	    } else if (answer.equals("2")) {
	    	System.out.println("Selected Save to Files"); 
	    	writeToFiles = true; 
	    }
	    
	    while((line = br.readLine()) != null){
	        if(!line.contains("-9999")){
	        	climateData.add(line); 
	        	
	        	if (writeToFiles == true) {
	            for (int i = 0; i < states.length; i++) {
	            	
	            	if (line.contains(statesSpaced[i])){
	            		
	            		
	            		String stateFileName = states[i]; 
	        			stateFileName = "States/"+stateFileName+".csv";
	        			statefile = new File(stateFileName);
	        			
	        			FileWriter stateWriter = new FileWriter(statefile,true); 
	        			if (statefile.length() == 0){
	            			stateWriter.write("STATION,STATION_NAME,DATE,TPCP,MNTM\n"); 
	            		}
	        			stateWriter.write(line+"\n");
	        			
	        			System.out.printf("Writing [%s] to file [%s]\n",line,statefile);
	        			stateWriter.flush(); 
	        			stateWriter.close(); 
	        			

	            	}
	            	
	            	
	            }
	        	}
	        } 
	        
	    }
	    br.close();
	    fr.close();
	    
	    //printDataFromList(climateData); 
	    
	}
	
	public static void printDataFromList(ArrayList<String> data) {
		for (String line : data) {
			System.out.println(line); 
		}
	}

}
