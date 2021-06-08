package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.concretes.UserManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("api/users")
public class UsersController {
	
	private UserManager userManager;
	
	@Autowired
	public UsersController(UserManager userManager) {
		this.userManager = userManager;
	}

	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userManager.getAll();
	}
}
