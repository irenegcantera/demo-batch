package com.example.demo.writers;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

/**
 * Implementation of ItemWriter<T> interface
 * 
 * @author irene
 * @version 1.0, 6 April 2025
 */
public class DemoItemWriter implements ItemWriter<String> {
	
	/**
	 * Process the supplied data element
	 * 
	 * @param chunk the items to be written
	 * @throws Exception if there are errors
	 */
	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		
		for (String item : chunk) {
			System.out.println(item);
		}
		
	}

}
