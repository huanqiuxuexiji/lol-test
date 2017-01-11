package com.java2.web.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java2.web.Dto.AddressDto;
import com.java2.web.Dto.UserDto;
import com.java2.web.Entity.Address;
import com.java2.web.Entity.User;
import com.java2.web.Repository.AddressRepository;
import com.java2.web.Repository.UserRepository;

@Service
@Transactional
public class UserServicelmp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public UserDto getUser(long id) { // 获取单个用户数据
		return convertToDTO(userRepository.findOneUser(id));
	}

	public List<UserDto> getAllUsers() { // 得到用户列表
		List<UserDto> users = null;
		users = new ArrayList<UserDto>();
		List<User> list = userRepository.findAllUsers();

		for (User user : list) {
			users.add(convertToDTO(user));
		}
		return users;
	}

	public UserDto removeUser(long id) { // 删除某个用户
		return convertToDTO(userRepository.deleteUser(id));
	}

	public UserDto createUser(UserDto userDto) { // 创建单个用户
		User user = userRepository.addUser(convertToEntity(userDto));
		if (userDto.getAddress() != null) {
			Address address = convertToEntity(userDto.getAddress(),user);
			addressRepository.addAddress(address);			
		}
		return userDto;
	}

	public UserDto refreshUser(long id, UserDto user) { // 刷新用户数据
		return convertToDTO(userRepository.updateUser(id, convertToEntity(user)));
	}

	// 转换成Dto
	private static UserDto convertToDTO(User user) {
		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setNickName(user.getNickName());
		userDto.setSex(user.getSex());
		userDto.setEmail(user.getEmail());
		for (Address address : user.getAddresses()) {
			if ("true".equals(address.getIsDefault())) {
				userDto.setAddress(convertToDTO(address));
			}
		}
		return userDto;
	}

	// 转换成Entity
	private static User convertToEntity(UserDto userDto) {
		User user = new User();
		user.setNickName(userDto.getNickName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setSex(userDto.getSex());

		return user;
	}
	
	private static AddressDto convertToDTO(Address address) {
		AddressDto addressDto = new AddressDto();

		addressDto.setId(address.getId());
		addressDto.setAddress(address.getAddress());
		addressDto.setIsDefault(address.getIsDefault());
		addressDto.setTelphone(address.getTelphone());
		
		return addressDto;
	}
	
	private static Address convertToEntity(AddressDto addressDto, User user) {
		Address address = new Address();

		address.setAddress(addressDto.getAddress());
		address.setIsDefault(addressDto.getIsDefault());
		address.setTelphone(addressDto.getTelphone());
		address.setUser(user);

		return address;
	}

}
