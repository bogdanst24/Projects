package com.stupariu.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stupariu.Entity.LoggedInUser;
import com.stupariu.Entity.User;
import com.stupariu.Service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable("id") int id) {
		return this.userService.getUserById(id);
	}

	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserByUsername(@PathVariable("username") String username) {
		System.out.println(username);
		return this.userService.getUserByUsername(username);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateUser(@RequestBody User user) {
		this.userService.updateUser(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable("id") String id) {
		this.userService.deleteUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void insertUser(@RequestBody User user) {
		this.userService.insertUser(user);
	}
	
	@RequestMapping(value = "/check/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public LoggedInUser checkUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password){
		return this.userService.checkUsernameAndPassword(username,password);
	}

}