/**
 * 
 */
package edu.wisc.student.web.rest;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import edu.wisc.student.finance.ChargeService;
import edu.wisc.student.finance.v1.ChargeType;

/**
 * {@link Controller} providing the REST methods for {@link ChargeService}.
 * 
 * @author zodrow
 *
 */

@Api("SPFP API")
@Controller
public class ChargeController {

		@Inject
		private ChargeService chargeService;
		
		/**
		 * 
		 * @param studentIdentifier
		 * @return all {@link ChargeType}s for the student
		 */
		@ApiOperation(value="Get all charges for Student",
				notes="Retreieve all the charges associated with the student", response=ChargeType.class)
		@RequestMapping(value="/charges", method=RequestMethod.GET)
		public Collection<ChargeType> getCharges( String studentIdentifier ){
			Collection<ChargeType> charges = chargeService.getCharges(studentIdentifier);
			return charges;
		}
}
