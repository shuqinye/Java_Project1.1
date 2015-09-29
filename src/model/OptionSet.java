package model;

import java.io.Serializable;
/**
 * This class is an option set of an automobile, containing all options available.
 * @author ShuqinYe
 *
 */

public class OptionSet implements Serializable{

	private String name; // The name of the car property.
	private Option[] options; // The possible options of the property (OptionSet).
	
	/**
	 * This class represents the possible option a car can have within a specific
	 * OptionSet(property).
	 * @author ShuqinYe
	 *
	 */
	private class Option implements Serializable{
		
		private String name; // Name of the option.
		private float price; // Price of the option.
		
		/**
		 * Default constructor without formal parameters.
		 */
		protected Option() {
			this("noNameYet", 0);
		}
		
		protected Option(String name, float price) {
			this.name = name;
			this.price = price;
		}
		
		protected String getName() {
			return name;
		}
		
		protected float getPrice() {
			return price;
		}
		
		protected void setName(String name) {
			this.name = name;
		}
		
		protected void setPrice(float price) {
			this.price = price;
		}
		
		/**
		 * This method displays the information of the option as a String.
		 * @return a String that describes the option.
		 */
		protected String getOption() {
			StringBuffer str = new StringBuffer();
			str.append(name);
			int i = 46 - str.length();
			for (int c = 0; c < i; ++c) str.append(" ");
			
			str.append(price);
			str.append("\n");
			
			return str.toString();
		}
		
	}
	
	/**
	 * Constructor is the name is unknown.
	 * @param opSize the number of options in one option set.
	 */
	protected OptionSet(int opSize) {
		this("noNameYet", opSize);
	}
	
	/**
	 * Construct the OptionSet
	 * @param opSize the number of options within one OptionSet
	 * @param name the name of the OptionSet.
	 */
	protected OptionSet(String name, int opSize) {
		this.name = name;		
				
		// Create the array of options
		options = new Option[opSize];
		
		for (int i = 0; i < opSize; ++i) 
			options[i] = new Option();

	}
	
	/**
	 * Get the OptionSet name.
	 * @return the name of the OptionSet.
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Gets the whole OptionSet with an array of Options.
	 * @return the OptionSet with all options.
	 */
	protected Option[] getfAllOptions() {
		return options;
	}
	
	/**
	 * Get an option with a certain index.
	 * @param opIndex the index of the option that needs to be found.
	 * @return the Option with an index of opIndex.
	 */
	protected Option getOpByIndex(int opIndex) {
		return options[opIndex];
	}
	
	/**
	 * Find an option with a certain name.
	 * @param name the name of the Option that needs to be found.
	 * @return the Option with a certain name.
	 */
	protected Option getOpByName(String name) {
		int i = 0;
		while (!options[i].name.equals(name)) ++i;
		return options[i];
	}
	
	/**
	 * Find the index of an option
	 * @param name the name of the option to be found.
	 * @return -1 if the option is not found, returns the index if found.
	 */
	protected int findOpByName(String name) {
		int i = 0;
		while (!options[i].name.equals(name)) ++i;
		return i < options.length ? i : -1;
	}
	
	/**
	 * Find the index of an option of a certain price.
	 * @param price the price of the option to be found.
	 * @return -1 if not found, returns the index if found.
	 */
	protected int findOpByPrice(float price) {
		int i = 0;
		while (options[i].price != price) ++i;
		return i < options.length ? i : -1;
	}
	
	
	/**
	 * Sets the name of OptionSet.
	 * @param name the name of the OptionSet we need to set to.
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the options for the OptionSet.
	 * @param options the new set of options available for the OptionSet.
	 */
	protected void setOptions(String[] opNames, float[] prices) {
		for (int i = 0; i < options.length; ++i) {
			options[i].setName(opNames[i]);
			options[i].setPrice(prices[i]);
		}
	}
	
	
	/**
	 * Update a certain Option in the OptionSet.
	 * @param option the option to be updated into the new option.
	 * @param opIndex the index in the OptionSet the option needs to updated.
	 */
	protected void setOp(int opIndex, String opName, float price) {
		options[opIndex].setName(opName);
		options[opIndex].setPrice(price);
	}
	
	
	/**
	 * Delete the option at a certain index.
	 * @param opIndex the index of the option to be deleted.
	 */
	protected void deleteOpByIndex(int opIndex) {
		options[opIndex] = null;
	}
	
	/**
	 * Delete the option that has a certain name.
	 * @param name the name of the option to be deleted.
	 */
	protected void deleteOpByName(String name) {
		int i = 0;
		while (!options[i].name.equals(name)) ++i;
		options[i] = null;
	}
	
	/**
	 * Get the whole OptionSet with details of its name and options.
	 * @return a String representation of the OptionSet.
	 */
	protected String getOpSet() {
		StringBuffer str = new StringBuffer();
		str.append("You can choose the following options and prices for ");
		str.append(name);
		str.append(":\n");
		str.append("Option");
		
		// Insert 40 spaces to separate the options and prices.
		for (int i = 0; i < 40; ++i) str.append(" ");

		str.append("Price($)\n");
		
		for (int i = 0; i < options.length; ++i) {
			str.append(options[i].getOption());
		}
		
		str.append("\n");
		return str.toString();
	}

}
