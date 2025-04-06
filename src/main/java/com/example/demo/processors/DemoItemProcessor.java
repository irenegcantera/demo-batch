package com.example.demo.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

/**
 * Implementation of ItemProcessor<I, O> interface
 * 
 * @author irene
 * @version 1.0, 6 April 2025
 */
public class DemoItemProcessor implements ItemProcessor<String, String> {
	
	private static final Logger logger = LogManager.getLogger();
	
	/**
	 * Process the provided item, returning a potentially modified or new item for
	 * continued processing. If the returned result is {@code null}, it is assumed that
	 * processing of the item should not continue.
	 * 
	 * @param item the item to be processed
	 * @return the modified or new item for continued processing, {@code null} if
	 * processing of the provided item should not continue
	 * @throws Exception thrown if exception occurs during processing
	 */
	@Override
	public String process(String item) throws Exception {
		
		logger.debug("Processing item: {}", item);
		
		return item;
		
	}

}
