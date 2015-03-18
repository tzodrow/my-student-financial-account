/**
 * 
 */
package edu.wisc.student.web.rest;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping(value="/v1", produces={ MediaType.APPLICATION_JSON_VALUE})
public class ChargeController {

  @Inject
  private ChargeService chargeService;

  /**
   * 
   * @return all {@link ChargeType}s for the current authenticated student
   */
  @ApiOperation(value="Get all charges for Student",
      notes="Retreieve all the charges associated with the student", response=ChargeType.class)
  @RequestMapping(value="charges", method=RequestMethod.GET)
  public @ResponseBody Collection<ChargeType> getCharges(){
    Collection<ChargeType> charges = chargeService.getCharges(currentUser());
    return charges;
  }
  
  /**
   * TODO: replace this with current UserDetails from Spring Security once integrated.
   * 
   * @return the id of the current user
   */
  protected String currentUser() {
    return "bbadger";
  }
}
