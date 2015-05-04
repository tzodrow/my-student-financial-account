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

	List<AuthorizedUser> getAuthorizedUsers();

	// TODO: this process would have to be broken into 'invite' and 'accept' steps; PVIs could only be added directly with existing accounts.
	void addAuthorizedUser(AuthorizedUser authorizedUser);

}
