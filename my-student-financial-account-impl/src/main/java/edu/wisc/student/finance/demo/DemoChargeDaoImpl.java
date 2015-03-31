/**
 * 
 */
package edu.wisc.student.finance.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.wisc.student.finance.ChargeDao;
import edu.wisc.student.finance.v1.ChargeType;

/**
 * Demo implementation of {@link ChargeDao}.
 * 
 * @author Nicholas Blair
 */
@Named
public class DemoChargeDaoImpl implements ChargeDao {

  private Map<String, List<ChargeType>> data = Collections.emptyMap();
  
  /**
   * Initialization method called {@link PostConstruct}.
   * 
   * @see #readDemoData()
   * @throws IOException
   */
  @PostConstruct
  protected void init() throws IOException {
    data = Collections.unmodifiableMap(readDemoData());
  }
  /*
   * (non-Javadoc)
   * @see edu.wisc.student.finance.ChargeDao#getCharges(java.lang.String)
   */
  @Override
  public Collection<ChargeType> getCharges(String studentIdentifier) {
    List<ChargeType> charges = data.get(studentIdentifier);
    if(charges == null) {
      return Collections.emptyList();
    } else {
      // clone the list so mutations don't go back to persistence
      return new ArrayList<>(charges);
    }
  }

  /**
   * Reads the demo data and returns it as a {@link Map}.
   * 
   * @return
   * @throws IOException
   */
  Map<String,List<ChargeType>> readDemoData() throws IOException {
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    
    try (InputStream is = new ClassPathResource("edu/wisc/student/finance/demo/demo-charge-service-data.json").getInputStream()) {
      Map<String, List<ChargeType>> result = mapper.readValue(is, new TypeReference<Map<String, List<ChargeType>>>() { });
      return result;
    }
  }
}
