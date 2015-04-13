/**
 *
 */
package edu.wisc.student.web.rest;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import edu.wisc.student.finance.AuthorizedUserService;
import edu.wisc.student.finance.v1.AuthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

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

	@ApiOperation(
			value="Get the AuthorizedUsers for the currently authenticated user",
			notes="Retrieve the AuthorizedUsers for the currently authenticated user"
	)
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody List<AuthorizedUser> getAccountSettings(){
		List<AuthorizedUser> accountSettings = authzService.getAuthorizedUsers();
		return accountSettings;
	}

	@ApiOperation(
			value="Add the AuthorizedUser for the currently authenticated user",
			notes="Add the AuthorizedUsers for the currently authenticated user"
	)
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseStatus(HttpStatus.OK) void addAuthorizedUser(@RequestBody AuthorizedUser authorizedUser){
		authzService.addAuthorizedUser(authorizedUser);
	}

}
