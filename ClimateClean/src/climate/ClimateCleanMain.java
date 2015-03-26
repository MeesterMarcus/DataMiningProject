package climate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




public class ClimateCleanMain {

	public static void main(String[] args) throws IOException {
		String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DC", "DE", "FL", "GA", 
		          "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", 
		          "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", 
		          "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", 
		          "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
		
		//Create files for each states
		File dir = new File("States");
		dir.mkdir(); 
		
		File statefile;
		
		String[] statesSpaced = new String[51];
		
		for (int i = 0; i < states.length; i++) {
			String stateFileName = states[i]; 
			stateFileName = "States/"+stateFileName+".csv";
			statefile = new File(stateFileName);
			if (statefile.createNewFile()){
				System.out.println("File created!");
			} else {
				System.out.println("File already exists."); 
			}
			
		}
		
		
		
		//Modify array so there is a space between state abbreviations.
		for (int i = 0; i < states.length; i++) {
			String state = states[i]; 
			String space_state = " "+state+" ";
			statesSpaced[i] = space_state; 
			System.out.print(i+" : "+states[i]+"\n");
		}
		
		
		File infile = new File("climatedata.csv");
	    FileReader fr = new FileReader(infile);
	    
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine()) != null){
	        if(!line.contains("-9999")){

	            for (int i = 0; i < states.length; i++) {
	            	
	            	if (line.contains(statesSpaced[i])){
	            		
	            		String stateFileName = states[i]; 
	        			stateFileName = "States/"+stateFileName+".csv";
	        			statefile = new File(stateFileName);
	        			
	        			FileWriter stateWriter = new FileWriter(statefile,true); 
	        			stateWriter.write(line+"\n");
	        			
	        			System.out.printf("Writing [%s] to file [%s]\n",line,statefile);
	        			stateWriter.flush(); 
	        			stateWriter.close(); 

	            	}
	            	
	            	
	            }
	        } 
	        
	    }
	    br.close();
	    fr.close();
	    //fw.close(); 
	    
	    /*
		//Read from unclean data file and output new file with no -9999 values
		//Need to implement state file ouput.
		File infile = new File("climatedata.csv");
		File outfile = new File ("climatedataclean.csv");
	    FileReader fr = new FileReader(infile);
	    FileWriter fw = new FileWriter(outfile);
	    
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine()) != null){
	        if(!line.contains("-9999")){
	            fw.write(line);
	            fw.write("\n");
	            
	            if (line.contains(states[43])){
		        	System.out.println(line); 
		        }
	        } 
	        
	    }
	    */
	   
	    

	}

}
