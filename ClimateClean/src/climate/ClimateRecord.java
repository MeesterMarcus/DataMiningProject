package climate;

/**
 * This class holds a record of climate data. Each record
 * is a line from the file, separated by the comma delimiter.
 * Holding each record within its own object allows for easy
 * sorting.
 * @author Marcus
 *
 */

public class ClimateRecord{
	String record; 
	private String station;
	private String station_name; 
	private String date; 
	private String tpcp;
	private String mntm; 
	
	public ClimateRecord(){
		station = ""; 
		station_name = "";
		date = "";
		tpcp = "";
		mntm = "";
	}
	
	public ClimateRecord(String s){
		String delims = ",";
		String[] tokens = s.split(delims); 
		station = tokens[0]; 
		station_name = tokens[1]; 
		date = tokens[2]; 
		tpcp = tokens[3]; 
		mntm = tokens[4]; 
	}
	
	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTpcp() {
		return tpcp;
	}

	public void setTpcp(String tpcp) {
		this.tpcp = tpcp;
	}

	public String getMntm() {
		return mntm;
	}

	public void setMntm(String mntm) {
		this.mntm = mntm;
	}

	public String toString() {
		return station+","+station_name+","+date+","+tpcp+","+mntm; 
	}




}
