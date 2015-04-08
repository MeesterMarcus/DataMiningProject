package climate;

import java.util.ArrayList;

public class ClimateRecordList {
	
	private ArrayList<ClimateRecord> records;
	
	public ClimateRecordList(){
		records = new ArrayList<ClimateRecord>(); 
	}
	
	public void addClimateRecord(ClimateRecord cr){
		records.add(cr); 
	}
	
	public String toString(){
		return records.toString(); 
	}
	
	public void clear(){
		records.clear(); 
	}
	
	public double getMeanTemps(){
		double sum = 0; 
		for (int i = 0; i < records.size(); i++) {
			ClimateRecord cr = records.get(i); 
			double t = Integer.parseInt(cr.getMntm()); 
			sum += t; 
			
		}
		return sum/records.size(); 
	}
	
	public String getDate(){
		return records.get(0).getDate(); 
	}

}
