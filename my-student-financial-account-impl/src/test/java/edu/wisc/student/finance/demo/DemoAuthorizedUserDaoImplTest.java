/**
 * 
 */
package edu.wisc.student.finance.demo;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import edu.wisc.student.finance.v1.AuthorizedUser;

/**
 * @author Collin Cudd
 *
 */
public class DemoAuthorizedUserDaoImplTest {

  /**
   * Confirm properly initialized {@link DemoAuthorizedUsersDaoImpl} has expected data.
   * 
   * @throws IOException 
   */
	@Test
	public void getAuthorizedUsers_control() throws IOException{
		DemoAuthorizedUsersDaoImpl authUserService =  new DemoAuthorizedUsersDaoImpl();
		authUserService.init();
		
		List<AuthorizedUser> authorizedUsers = authUserService.getAuthorizedUsers("UW000A000");
		assertEquals(3, authorizedUsers.size());
		
		for(AuthorizedUser authzUser: authorizedUsers){
			if("UW000A001".equals(authzUser.getPvi())){
				assertEquals("Jane Doe", authzUser.getFullName());
				assertEquals("jane.doe@demo.wisc.edu", authzUser.getEmailAddress());
				
			}else if("UW000A002".equals(authzUser.getPvi())){
				assertEquals("John Doe", authzUser.getFullName());
				assertEquals("john.doe@demo.wisc.edu", authzUser.getEmailAddress());
			}else{
				assertEquals("UW000A003", authzUser.getPvi());
				assertEquals("Jim Doe", authzUser.getFullName());
				assertEquals("jim.doe@demo.wisc.edu", authzUser.getEmailAddress());
			}
		}
		
	}
}
