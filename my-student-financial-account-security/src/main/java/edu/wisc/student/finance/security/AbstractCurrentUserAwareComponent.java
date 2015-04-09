/**
 * 
 */
package edu.wisc.student.finance.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.wisc.uwss.UWUserDetails;

/**
 *  Abstract super type which provides common functionality sensitive to the currently logged in user.
 * 
 * @author Collin Cudd
 *
 */
public class AbstractCurrentUserAwareComponent {
	
	/**
	 * @return the currently logged in users pvi value.
	 */
	protected String currentUser(){
		UWUserDetails currentUser = currentUserDetails();
		return currentUser.getPvi();
	}
	
	/**
	 * @return the currently logged in users {@link UWUserDetails}
	 */
	protected UWUserDetails currentUserDetails() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if(authentication == null) {
			throw new AuthenticationCredentialsNotFoundException("Authentication is required");
		}
	    if(authentication.getPrincipal() instanceof UWUserDetails){
	    	return  (UWUserDetails) authentication.getPrincipal();
	    }else{
	    	//principal is just a string if the user not logged in.
	    	throw new AuthenticationCredentialsNotFoundException("Authentication is required");
		}
	  }
}
