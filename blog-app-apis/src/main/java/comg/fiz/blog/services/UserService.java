package comg.fiz.blog.services;

import java.util.List;

import comg.fiz.blog.payloads.UserDto;


public interface UserService {

	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUser();
	void deleteUser(Integer id);
}
