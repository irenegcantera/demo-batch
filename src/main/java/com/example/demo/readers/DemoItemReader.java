package com.example.demo.readers;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Implementation of ItemReader<T> interface
 * 
 * @author irene
 * @version 1.0, 6 April 2025
 */
public class DemoItemReader implements ItemReader<String> {
	
	private static final Logger logger = LogManager.getLogger();
	
	private int i = 0;
	private List<String> items = Arrays.asList("uno", "dos", "tres", "cuatro");
	
	/**
	 * Reads a piece of input data and advance to the next one and return <code>null</code> 
	 * at the end of the input data set. 
	 * @throws ParseException if there is a problem parsing the current record
	 * @throws NonTransientResourceException if there is a fatal exception in the
	 * underlying resource
	 * @throws UnexpectedInputException if there is an uncategorised problem with the
	 * input data
	 * @throws Exception if an there is a non-specific error
	 * @return the item to be processed or {@code null} if the data source is exhausted
	 */
	@Override
	public String read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		String item = null;
		
		if(i < items.size()) {
			item = items.get(i);
			logger.debug("Reading item: {}", item);
		}
		
		i++;
		
		return item;
		
	}

}
