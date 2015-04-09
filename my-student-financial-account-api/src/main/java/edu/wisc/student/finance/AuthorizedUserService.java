/**
 * 
 */
package edu.wisc.student.finance;

import java.util.List;

import edu.wisc.student.finance.v1.AuthorizedUser;

/**
 * @author Collin Cudd
 *
 */
public interface AuthorizedUserService {

	/**
	 * @return
	 */
	public List<AuthorizedUser> getAuthorizedUsers();
}
