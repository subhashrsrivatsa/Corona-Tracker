/**
 * 
 */
package com.subhash.coronatracker.model;

/**
 * @author Subhash
 *
 */
public class LocationStats {

	private String state;
	private String country;
	private int latestTotalCases;
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the latestTotalCases
	 */
	public int getLatestTotalCases() {
		return latestTotalCases;
	}
	/**
	 * @param latestTotalCases the latestTotalCases to set
	 */
	public void setLatestTotalCases(int latestTotalCases) {
		this.latestTotalCases = latestTotalCases;
	}
	
	
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", latestTotalCases=" + latestTotalCases
				+ "]";
	}
	
	
	
	
}
