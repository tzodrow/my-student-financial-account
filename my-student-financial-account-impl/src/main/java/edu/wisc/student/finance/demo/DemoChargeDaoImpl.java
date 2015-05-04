/**
 * 
 */
package edu.wisc.student.finance.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.wisc.student.finance.ChargeDao;
import edu.wisc.student.finance.v1.ChargeType;

/**
 * Demo implementation of {@link ChargeDao}.
 * 
 * @author Nicholas Blair
 */
@Named
public class DemoChargeDaoImpl extends GenericDemoDataDao<ChargeType> implements ChargeDao {
	
	public static final String DEMO_CHARGE_DATA = "edu/wisc/student/finance/demo/demo-charge-service-data.json";
  
  /*
   * (non-Javadoc)
   * @see edu.wisc.student.finance.ChargeDao#getCharges(java.lang.String)
   */
  @Override
  public Collection<ChargeType> getCharges(String studentIdentifier) {
    return getDemoData(studentIdentifier);
  }

	/* (non-Javadoc)
	 * @see edu.wisc.student.finance.demo.GenericDemoDataDao#getDemoDataPath()
	 */
	@Override
	public String getDemoDataPath() {
		return DEMO_CHARGE_DATA;
	}

	/* (non-Javadoc)
	 * @see edu.wisc.student.finance.demo.GenericDemoDataDao#readDemoData()
	 */
	@Override
	protected Map<String, List<ChargeType>> readDemoData() throws IOException {
	   try (InputStream is = new ClassPathResource(getDemoDataPath()).getInputStream()) {
		       return mapper.readValue(is, new TypeReference<Map<String, List<ChargeType>>>() { });
		   }
	   }
}
