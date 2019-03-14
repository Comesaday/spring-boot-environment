package cn.comesaday.cw.service;

import java.util.List;

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

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	public void del(int id) {
		// TODO Auto-generated method stub
		userMapper.del(id);
	}

	public List<User> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		int pageSize = 10;
		int beginCount = (currentPage - 1) * pageSize;
		return userMapper.findByPage(beginCount, pageSize);
	}
}
