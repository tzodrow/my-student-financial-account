/**
 *
 */
package edu.wisc.student.finance.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Collin Cudd
 *
 */
public abstract class GenericDemoDataDao<T> {
	/**
	 * The {@link ObjectMapper} used to serialize/unserialize the data
	 */
	protected ObjectMapper mapper = new ObjectMapper();
	protected Map<String, List<T>> data = Collections.emptyMap();

	  /**
	   * Initialization method called {@link PostConstruct}.
	   *
	   * @see #readDemoData()
	   * @throws IOException
	   */
	  @PostConstruct
	  protected void init() throws IOException {
	    data = readDemoData();
	  }

	/**
	 * @param key
	 * @return a {@link List} of values for the given key.
	 */
	protected List<T> getDemoData(String key){
		  List<T> list = data.get(key);
		  if(list == null){
			  return Collections.<T>emptyList();
		  }else{
			// clone the list so mutations don't go back to persistence
			return new ArrayList<T>(list);
		  }
	  }

	  /**
	   * Reads the demo data and returns it as a {@link Map}.
	   *
	   * @return
	   * @throws IOException
	   */
	   protected abstract Map<String, List<T>> readDemoData() throws IOException;

	/**
	 * @return the path to the file containing the demo data
	 */
	public abstract String getDemoDataPath();
}
