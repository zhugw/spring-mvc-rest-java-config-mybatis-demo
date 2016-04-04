package it.javavault.springMVC.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.javavault.springMVC.persistence.UsersMapper;

@RestController
@RequestMapping("/users")
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UsersMapper usersService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		return new ResponseEntity<List<Map<String, Object>>>(usersService.getUserList(), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable(value = "id") String userid) {
		return new ResponseEntity<Map<String, Object>>(usersService.getUserById(userid), HttpStatus.OK);
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserDetailById(@PathVariable(value = "id") String userid,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "nickname", required = true) String nickname) {
		Map<String, Object> params = new HashMap<>();
		params.put("userid", userid);
		params.put("username", username);
		params.put("nickname", nickname);
		return new ResponseEntity<Map<String, Object>>(usersService.getUserDetailById(params), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") String userid) {
		return new ResponseEntity<String>((usersService.deleteUserById(userid) == 1) ? "DELETE SUCCESS" : "DELETE FAILED",
				HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserById(@PathVariable(value = "id") String userid,
			@RequestParam(value = "email", required = true) String email) {
		return new ResponseEntity<String>(
				(usersService.updateUserEmailById(userid, email) == 1) ? "UPDATE SUCCESS" : "UPDATE FAILED",
				HttpStatus.OK);
	}

	@RequestMapping(value = "/update/detail/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserDetailById(@PathVariable(value = "id") String userid,
			@RequestParam(value = "nickname", required = true) String nickname,
			@RequestParam(value = "email", required = false) String email) {
		Map<String,Object> params = new HashMap<>();
		params.put("userid", userid);
		if (email != null && email != "") {
			params.put("email", email);
		}
		params.put("nickname", nickname);
		return new ResponseEntity<String>(
				(usersService.updateUserDetailsById(params) == 1) ? "UPDATE SUCCESS" : "UPDATE FAILED", HttpStatus.OK);
	}
}
