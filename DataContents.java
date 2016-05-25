package postal.service;

/**
 * The Class DataContents.
 */
public class DataContents {

	/** The first destination. */
	private String firstDestination;

	/** The second destination. */
	private String secondDestination;

	/** The distance. */
	private int distance;


	/**
	 * Instantiates a new data contents.
	 */
	public DataContents() {
		super();
	}

	/**
	 * Gets the first destination.
	 * 
	 * @return the first destination
	 */
	public String getFirstDestination() {
		return firstDestination;
	}

	/**
	 * Sets the first destination.
	 * 
	 * @param firstDestination
	 *            the new first destination
	 */
	public void setFirstDestination(String firstDestination) {
		this.firstDestination = firstDestination;
	}

	/**
	 * Gets the second destination.
	 * 
	 * @return the second destination
	 */
	public String getSecondDestination() {
		return secondDestination;
	}

	/**
	 * Sets the second destination.
	 * 
	 * @param secondDestination
	 *            the new second destination
	 */
	public void setSecondDestination(String secondDestination) {
		this.secondDestination = secondDestination;
	}

	/**
	 * Gets the distance.
	 * 
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Sets the distance.
	 * 
	 * @param distance
	 *            the new distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

}
