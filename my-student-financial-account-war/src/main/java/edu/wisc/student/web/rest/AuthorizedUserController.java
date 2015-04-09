/**
 * 
 */
package edu.wisc.student.web.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import edu.wisc.student.finance.AuthorizedUserService;
import edu.wisc.student.finance.v1.AuthorizedUser;
import edu.wisc.student.finance.v1.ChargeType;

/**
 * {@link Controller} 
 * @author Collin Cudd
 *
 */
@Api("SPFP Authorized Users API")
@Controller
@RequestMapping(value="/v1/authorized_users", produces={ MediaType.APPLICATION_JSON_VALUE})
public class AuthorizedUserController {

	@Inject
	private AuthorizedUserService authzService;
	
	@ApiOperation(value="Get the AuthorizedUsers for the currently authenticated user",
		      notes="Retrieve the AuthorizedUsers for the  currently authenticated user", response=ChargeType.class)
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody List<AuthorizedUser> getAccountSettings(){
		List<AuthorizedUser> accountSettings = authzService.getAuthorizedUsers();
		return accountSettings;
	}
}
