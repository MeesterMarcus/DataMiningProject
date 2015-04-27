package climate;

import java.util.ArrayList;

/**
 * This class stores a list of all the climate records that share the same date.
 * It can then calculate the mean temps and mean precip of all these records and
 * store it in a bucket.
 * 
 * @author Marcus Lorenzana
 *
 */

public class ClimateRecordList {

	/* A list of records for the same date */
	private ArrayList<ClimateRecord> records;

	public ClimateRecordList() {
		records = new ArrayList<ClimateRecord>();
	}

	/**
	 * Add a climate record to this list
	 * 
	 * @param cr
	 */
	public void addClimateRecord(ClimateRecord cr) {
		records.add(cr);
	}

	/**
	 * Print out the record
	 */
	public String toString() {
		return records.toString();
	}

	/**
	 * Clear all records in this list
	 */
	public void clear() {
		records.clear();
	}

	/**
	 * Get the mean MNTM for all the records that fall in this date
	 * 
	 * @return mean MNTM
	 */
	public double getMeanTemps() {
		double sum = 0;
		for (int i = 0; i < records.size(); i++) {
			ClimateRecord cr = records.get(i);
			double t = Integer.parseInt(cr.getMntm());
			sum += t;

		}
		return sum / records.size();
	}

	/**
	 * Get the mean TPCP for all the records that fall in this date
	 * 
	 * @return mean TPCP
	 */
	public double getMeanPrec() {
		double sum = 0;
		for (int i = 0; i < records.size(); i++) {
			ClimateRecord cr = records.get(i);
			double t = Integer.parseInt(cr.getTpcp());
			sum += t;

		}
		return sum / records.size();
	}

	/**
	 * Get the date
	 * 
	 * @return date
	 */
	public String getDate() {
		return records.get(0).getDate();
	}

	/**
	 * Get the size of this list
	 * 
	 * @return size
	 */
	public int size() {
		return records.size();
	}

}
