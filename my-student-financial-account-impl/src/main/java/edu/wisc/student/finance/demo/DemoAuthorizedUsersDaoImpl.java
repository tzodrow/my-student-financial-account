/**
 * 
 */
package edu.wisc.student.finance.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;

import edu.wisc.student.finance.AuthorizedUserDao;
import edu.wisc.student.finance.v1.AuthorizedUser;

/**
 * Demo implementation of {@link AuthorizedUserDao}.
 * @author Collin Cudd
 *
 */
@Named
public class DemoAuthorizedUsersDaoImpl extends GenericDemoDataDao<AuthorizedUser> implements AuthorizedUserDao {

	public static final String DEMO_AUTHZ_USERS_DATA = "edu/wisc/student/finance/demo/demo-authorized-users-service-data.json";
	
	/* (non-Javadoc)
	 * @see edu.wisc.student.finance.AuthorizedUserDao#getAuthorizedUsers(edu.wisc.uwss.UWUserDetails)
	 */
	@Override
	public List<AuthorizedUser> getAuthorizedUsers(String pvi) {
		return getDemoData(pvi);
	}
	
	/* (non-Javadoc)
	 * @see edu.wisc.student.finance.demo.GenericDemoDataDao#getDemoDataPath()
	 */
	@Override
	public String getDemoDataPath() {
		return DEMO_AUTHZ_USERS_DATA;
	}

	/* (non-Javadoc)
	 * @see edu.wisc.student.finance.demo.GenericDemoDataDao#readDemoData()
	 */
	@Override
	protected Map<String, List<AuthorizedUser>> readDemoData()
			throws IOException {
		try (InputStream is = new ClassPathResource(getDemoDataPath()).getInputStream()) {
			       return mapper.readValue(is, new TypeReference<Map<String, List<AuthorizedUser>>>() { });
			   }
		   }
}
