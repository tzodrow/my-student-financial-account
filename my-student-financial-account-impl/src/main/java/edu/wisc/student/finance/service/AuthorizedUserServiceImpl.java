/**
 * 
 */
package edu.wisc.student.finance.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import edu.wisc.student.finance.AuthorizedUserDao;
import edu.wisc.student.finance.AuthorizedUserService;
import edu.wisc.student.finance.security.AbstractCurrentUserAwareComponent;
import edu.wisc.student.finance.v1.AuthorizedUser;
import edu.wisc.uwss.UWUserDetails;

/**
 * Primary {@link AccountSettingsService} implementation.
 * 
 * This class is responsible for integrating security, access control, and business logic
 * above the data access layer.
 * 
 * @author Collin Cudd
 *
 */
@Named
public class AuthorizedUserServiceImpl extends AbstractCurrentUserAwareComponent implements AuthorizedUserService{

	@Inject
	private AuthorizedUserDao authorizedUserDao;
	
	/* (non-Javadoc)
	 * @see edu.wisc.student.finance.AuthorizedUserService#getAuthorizedUsers()
	 */
	@Override
	public List<AuthorizedUser> getAuthorizedUsers() {
		UWUserDetails user = currentUserDetails();
		if(StringUtils.isNotBlank(user.getPvi())){
			
		}
		return authorizedUserDao.getAuthorizedUsers(user.getPvi());
	}
	
	
}
