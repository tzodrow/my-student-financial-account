/**
 *
 */
package edu.wisc.student.finance;

import java.util.List;

import edu.wisc.student.finance.v1.AuthorizedUser;
import edu.wisc.uwss.UWUserDetails;

/**
 * Simple Data Access interface for ...TODO
 *
 * This is not intended to be an exportable API; it is used underneath the
 * {@link AccountSettingsService} implementation and has a simple focus on data access.
 *
 * Implementations of this interface are not to apply business logic or security.
 * @author Collin Cudd
 *
 */
public interface AuthorizedUserDao {

	/**
	 * @param user
	 * @return never null, but potentially empty, collection of identifiers the user is authorized to view and pay bills for.
	 */
	List<AuthorizedUser> getAuthorizedUsers(String pvi);

	void addAuthorizedUser(String pvi, AuthorizedUser authorizedUser);

}
