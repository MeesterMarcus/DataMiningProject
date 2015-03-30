package climate;

import java.util.Comparator;

/**
 * Simple helper class used for sorting the records by date. 
 * @author Marcus Lorenzana
 *
 */

public class ClimateDateComparator implements Comparator<ClimateRecord> {

	
	public int compare(ClimateRecord o1, ClimateRecord o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
