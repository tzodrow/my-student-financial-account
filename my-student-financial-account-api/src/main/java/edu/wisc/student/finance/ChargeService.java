/**
 * 
 */
package edu.wisc.student.finance;

import java.util.Collection;

import edu.wisc.student.finance.v1.ChargeType;

/**
 * Service interface for interacting with {@link ChargeType}s.
 * 
 * @author zodrow
 */
public interface ChargeService {
	/**
	 * 
	 * @param studentIdentifier
	 * @return never null, but potentially empty, collection of charges for a specified student
	 */
	Collection<ChargeType> getCharges( String studentIdentifier );
}
