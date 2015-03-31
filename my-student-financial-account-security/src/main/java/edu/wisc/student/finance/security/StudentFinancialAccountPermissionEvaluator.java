/**
 *
 */
package edu.wisc.student.finance.security;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import edu.wisc.uwss.UWUserDetails;

import javax.inject.Named;

/**
 * {@link PermissionEvaluator} implementing access control for Spring Security
 * annotated methods.
 *
 * @author Nicholas Blair
 */
@Named
public class StudentFinancialAccountPermissionEvaluator implements PermissionEvaluator {

  public static final String VIEW_CHARGES = "viewCharges";
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /* (non-Javadoc)
   * @see org.springframework.security.access.PermissionEvaluator#hasPermission(org.springframework.security.core.Authentication, java.lang.Object, java.lang.Object)
   */
  @Override
  public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    Object principal = authentication.getPrincipal();
    if(principal instanceof UWUserDetails) {
      UWUserDetails user = (UWUserDetails) principal;
      if(targetDomainObject instanceof String) {
        // treat string as PVI
        if(user.getPvi().equals(targetDomainObject)) {
          logger.debug("{} has permission '{}' on id {} because the authenticated user has that id", user, permission, targetDomainObject);
          return true;
        }
        // TODO if we get here, the id being requested is different from the authenticated user
        // TODO integrate with relationship management service to see if this user has the specified permission for the target user
        // this would represent an authorized payer requesting data for a student
      }
    }
    logger.debug("{} DOES NOT have permission '{}' on object {}", principal, permission, targetDomainObject);
    return false;
  }

  /* (non-Javadoc)
   * @see org.springframework.security.access.PermissionEvaluator#hasPermission(org.springframework.security.core.Authentication, java.io.Serializable, java.lang.String, java.lang.Object)
   */
  @Override
  public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
    throw new UnsupportedOperationException("use hasPermission(Authentication, Object, Object) instead");
  }

}
