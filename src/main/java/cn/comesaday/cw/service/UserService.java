package cn.comesaday.cw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.comesaday.cw.domain.User;
import cn.comesaday.cw.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User login(String account, String password) {
		
		return userMapper.login(account, password);
	}
}
