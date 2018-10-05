package com.sigma.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigma.builder.WebUserBuilder;
import com.sigma.dto.ApiResponse;
import com.sigma.dto.LoginRequest;
import com.sigma.dto.WebUserRegistrationRequest;
import com.sigma.exception.AlreadyExistException;
import com.sigma.exception.BadRequestException;
import com.sigma.exception.NoContentException;
import com.sigma.exception.NotFoundException;
import com.sigma.exception.UnauthorizedException;
import com.sigma.model.WebUser;
import com.sigma.service.UserService;
import com.sigma.util.Constant;

@RestController
@RequestMapping("/web")
public class WebUserController {

	@Autowired
	private UserService<WebUser> webUserService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest req) {
		WebUser user = webUserService.findOneByKeyVal("username", req.getUsername());
		if (user == null) {
			throw new NotFoundException("User does not exist");
		}
		if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
			throw new UnauthorizedException("Invalid password");
		}
		return new ResponseEntity<Object>(new ApiResponse<Void>().success(), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> createWebUser(@RequestBody WebUserRegistrationRequest req) {
		WebUser user = webUserService.findOneByKeyVal("username", req.getUsername());
		if (user != null) {
			throw new AlreadyExistException("Web User is already existing");
		}
		
		boolean created = webUserService.create(new WebUserBuilder()
														.username(req.getUsername())
														.password(passwordEncoder.encode(req.getPassword()))
														.email(req.getEmail())
														.status(Constant.ACTIVE)
														.dateCreated(new Date())
														.build()
												);
		if (!created) {
			throw new BadRequestException("Unable to create web user");
		}
		
		return new ResponseEntity<Object>(new ApiResponse<Void>().success(), HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> findUserById(@PathVariable("id") long id) {
		WebUser user = webUserService.findOneById(id);
		if (user == null) {
			throw new NotFoundException("User does not exists");
		}
		return new ResponseEntity<Object>(new ApiResponse<WebUser>().success(user), HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> findAllUsers() {
		List<WebUser> users = webUserService.findAll();
		if (users.size() <= 0) {
			throw new NoContentException("No users found");
		}
		return new ResponseEntity<Object>(new ApiResponse<List<WebUser>>().success(users), HttpStatus.OK);
	}

}
