/**
 * 
 */
package edu.wisc.student.finance;

import java.util.Collection;

import edu.wisc.student.finance.v1.ChargeType;

/**
 * @author zodrow
 *
 */
public interface ChargeService {
	/**
	 * 
	 * @param studentIdentifier
	 * @return never null, but potentially empty, collection of charges for a specified student
	 */
	Collection<ChargeType> getCharges( String studentIdentifier );
}
