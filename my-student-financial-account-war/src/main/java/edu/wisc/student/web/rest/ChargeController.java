/**
 *
 */
package edu.wisc.student.web.rest;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import edu.wisc.student.finance.ChargeService;
import edu.wisc.student.finance.security.AbstractCurrentUserAwareComponent;
import edu.wisc.student.finance.v1.ChargeType;
import edu.wisc.uwss.UWUserDetails;

/**
 * {@link Controller} providing the REST methods for {@link ChargeService}.
 *
 * @author zodrow
 */
@Api("SPFP Charges API")
@Controller
@RequestMapping(value="/v1/charges", produces={ MediaType.APPLICATION_JSON_VALUE})
public class ChargeController extends AbstractCurrentUserAwareComponent {

  @Inject
  private ChargeService chargeService;

  /**
   *
   * @return all {@link ChargeType}s for the current authenticated student
   */
  @ApiOperation(value="Get all charges for the current authenticated user",
      notes="Retrieve all the charges current authenticated user", response=ChargeType.class)
  @RequestMapping(value="", method=RequestMethod.GET)
  public @ResponseBody Collection<ChargeType> getCharges(){
    Collection<ChargeType> charges = chargeService.getCharges(currentUser());
    return charges;
  }

  /**
   *
   * @param id the id of the student
   * @return all {@link ChargeType}s for the specified student
   */
  @ApiOperation(value="Get all charges for Student",
      notes="Retrieve all the charges associated with the student", response=ChargeType.class)
  @RequestMapping(value="/{id}", method=RequestMethod.GET)
  public @ResponseBody Collection<ChargeType> getCharges( @PathVariable String id ){
    Collection<ChargeType> charges = chargeService.getCharges(id);
    return charges;
  }
}
