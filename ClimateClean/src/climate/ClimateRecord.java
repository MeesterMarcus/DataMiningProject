package climate;

/**
 * This class holds a record of climate data. Each record is a line from the
 * file, separated by the comma delimiter. Holding each record within its own
 * object allows for easy sorting.
 * 
 * @author Marcus Lorenzana
 *
 */

public class ClimateRecord {
	/* Global variables */
	String record;
	private String station;
	private String station_name;
	private String date;
	private String tpcp;
	private String mntm;

	/**
	 * Initialization
	 */
	public ClimateRecord() {
		station = "";
		station_name = "";
		date = "";
		tpcp = "";
		mntm = "";
	}

	/**
	 * Assign values to this record
	 * 
	 * @param s
	 */
	public ClimateRecord(String s) {
		String delims = ",";
		String[] tokens = s.split(delims);
		station = tokens[0];
		station_name = tokens[1];
		date = tokens[2];
		tpcp = tokens[3];
		mntm = tokens[4];
	}

	/**
	 * 
	 * @return station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * Set station
	 * 
	 * @param station
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * 
	 * @return station name
	 */
	public String getStation_name() {
		return station_name;
	}

	/**
	 * Set station name
	 * 
	 * @param station_name
	 */
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	/**
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set date
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 
	 * @return tpcp
	 */
	public String getTpcp() {
		return tpcp;
	}

	/**
	 * Set tpcp
	 * 
	 * @param tpcp
	 */
	public void setTpcp(String tpcp) {
		this.tpcp = tpcp;
	}

	/**
	 * 
	 * @return mntm
	 */
	public String getMntm() {
		return mntm;
	}

	/**
	 * Set mntm
	 * 
	 * @param mntm
	 */
	public void setMntm(String mntm) {
		this.mntm = mntm;
	}

	/**
	 * @return toString
	 */
	public String toString() {
		return station + "," + station_name + "," + date + "," + tpcp + ","
				+ mntm;
	}

}
