package com.example.domain.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);
		user.setRole("ROLE_GENEAL");
		mapper.insertOne(user);
	}
	
	@Override
	public List<MUser> getUsers(MUser user){
		return mapper.findMany(user);
	}
	
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}
	
	/** Update user */
	// encoded for password
	@Override
	public void updateUserOne(String userId, String password, String userName) {
		String encoded = new BCryptPasswordEncoder().encode(password);
		mapper.updateOne(userId, encoded, userName);
	}
	/** Delete user */
	@Override
	public void deleteUserOne(String userId) {
		mapper.deleteOne(userId);
	}
	
	/** Get login user information */
	@Override
	public MUser getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}
}
