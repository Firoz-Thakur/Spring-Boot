package comg.fiz.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comg.fiz.blog.payloads.ApiResponse;
import comg.fiz.blog.payloads.UserDto;
import comg.fiz.blog.services.UserService;
import comg.fiz.blog.services.impl.UserServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUsr(@Valid @RequestBody UserDto userDto)
	{
		
		UserDto userDto2 = this.userService.createUser(userDto);
		return new ResponseEntity<>(userDto2,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		
		List<UserDto> userDto2 = this.userService.getAllUser();
		return new ResponseEntity<>(userDto2,HttpStatus.OK);
	}
	@GetMapping("/{user_id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int user_id)
	{
		
	    UserDto userDto = this.userService.getUserById(user_id);
		return ResponseEntity.ok(userDto);
	}	
	

	@PutMapping("/{user_id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable int user_id)
	{
		
		UserDto updatedUser = this.userService.updateUser(userDto,user_id);
		return ResponseEntity.ok(updatedUser);
	}
	@DeleteMapping("/{user_id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int user_id)
	{
		
	    this.userService.deleteUser(user_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}	
}
