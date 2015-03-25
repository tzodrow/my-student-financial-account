/**
 * 
 */
package edu.wisc.student.finance;

import java.util.Collection;

import edu.wisc.student.finance.v1.ChargeType;

/**
 * Simple Data Access interface for Charges.
 * 
 * This is not intended to be an exportable API; it is used underneath the 
 * {@link ChargeService} implementation and has a simple focus on data access.
 * 
 * Implementations of this interface are not to apply business logic or security.
 * 
 * @author Nicholas Blair
 */
public interface ChargeDao {

  /**
   * 
   * @param studentIdentifier
   * @return never null, but potentially empty, collection of charges for a specified student
   */
  Collection<ChargeType> getCharges( String studentIdentifier );
}
