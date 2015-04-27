package climate;

import java.util.Comparator;

/**
 * Simple helper class used for sorting the records by date.
 * 
 * @author Marcus Lorenzana
 *
 */

public class ClimateDateComparator implements Comparator<ClimateRecord> {

	/**
	 * Return 0,1, or -1 depending on the comparison of this climate record to
	 * the other climate record.
	 */
	public int compare(ClimateRecord o1, ClimateRecord o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
