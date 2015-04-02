/**
 * 
 */
package edu.wisc.student.finance.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.access.prepost.PreAuthorize;

import edu.wisc.student.finance.ChargeDao;
import edu.wisc.student.finance.ChargeService;
import edu.wisc.student.finance.v1.ChargeType;

/**
 * Primary {@link ChargeService} implementation.
 * 
 * This class is responsible for integrating security, access control, and business logic
 * above the data access layer.
 * 
 * @author Nicholas Blair
 */
@Named
public final class ChargeServiceImpl implements ChargeService {

  @Inject 
  private ChargeDao chargeDao;
  /* (non-Javadoc)
   * @see edu.wisc.student.finance.ChargeService#getCharges(java.lang.String)
   */
  @Override
  @PreAuthorize("hasPermission(#studentIdentifier, 'viewCharges')")
  public Collection<ChargeType> getCharges(String studentIdentifier) {
    return chargeDao.getCharges(studentIdentifier);
  }

}
