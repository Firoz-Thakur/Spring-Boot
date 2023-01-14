package comg.fiz.blog.services.impl;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import comg.fiz.blog.entities.User;
import comg.fiz.blog.repositories.UserRepo;
import comg.fiz.blog.services.UserService;
import comg.fiz.blog.exceptions.ResourceNotFoundException;
import comg.fiz.blog.payloads.UserDto;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto dtoUser) {
		User user =  this.dtoTOUser(dtoUser);
		User savedUser = this.userRepo.save(user);	
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto dtoUser, Integer id) {

		User dbUser = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		dbUser.setName(dtoUser.getName());
		dbUser.setPassword(dtoUser.getPassword());
		dbUser.setEmail(dtoUser.getEmail());
		dbUser.setAbout(dtoUser.getAbout());
		this.userRepo.save(dbUser);
		return this.userToDto(dbUser);
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		
		List<User> users = this.userRepo.findAll();
		List<UserDto>dtoUsers= new ArrayList();
//		for(User user: users)
//		{
//			dtoUsers.add(this.userToDto(user));
//		}
// This can be also done using java 8 streams
		dtoUsers = users.stream().map(user->userToDto(user)).collect(Collectors.toList());
		return dtoUsers;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
		 User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","ID",id));
		 this.userRepo.delete(user);
	}
	
	public User dtoTOUser(UserDto dtoUser)
	{
		User user = this.modelMapper.map(dtoUser, User.class);
		return user;

//		user.setId(dtoUser.getId());
//		user.setName(dtoUser.getName());
//		user.setPassword(dtoUser.getPassword());
//		user.setEmail(dtoUser.getEmail());
//		user.setAbout(dtoUser.getAbout());
		
		
	}
	public UserDto userToDto(User user)
	{
		UserDto dtoUser = this.modelMapper.map(user, UserDto.class);
		return dtoUser;
//		dtoUser.setId(user.getId());
//		dtoUser.setName(user.getName());
//		dtoUser.setPassword(user.getPassword());
//		dtoUser.setEmail(user.getEmail());
//		dtoUser.setAbout(user.getAbout());
	}
	

}
