package com.gofaner.game.lswht.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofaner.game.lswht.dao.UserMapper;
import com.gofaner.game.lswht.dto.ViewDTO;
import com.gofaner.game.lswht.exception.ServiceException;
import com.gofaner.game.lswht.model.User;
import com.gofaner.game.lswht.model.UserExample;
import com.gofaner.game.lswht.model.UserExample.Criteria;
import com.gofaner.game.lswht.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void resetPlayTime() throws ServiceException {
		userMapper.resetPlayTime();
	}

	@Override
	public ViewDTO<Integer> getPlayTime(String loginToken)
			throws ServiceException {
		User user = this.getByLoginToken(loginToken);

		ViewDTO<Integer> view = new ViewDTO<Integer>();
		if( user == null ){
			view.setMsg("user is not exists.");
			return view;
		}
		view.setData(user.getPlayTimes());
		
		return view;
	}

	private User getByLoginToken(String loginToken) throws ServiceException {
		UserExample example = new UserExample();

		Criteria criteria = example.createCriteria();
		criteria.andLoginTokenEqualTo(loginToken);
		List<User> userList = userMapper.selectByExample(example);
		
		if( userList == null || userList.size() == 0 ){
			return null;
		}
		return userList.get(0);
	}

	@Override
	public User getByAccount(String account) throws ServiceException {
		UserExample example = new UserExample();

		Criteria criteria = example.createCriteria();
		criteria.andAccountEqualTo(account);
		List<User> userList = userMapper.selectByExample(example);
		
		if( userList == null || userList.size() == 0 ){
			return null;
		}
		return userList.get(0);
	}

	@Override
	public User saveUserByAccount(String account) throws ServiceException {
		if( account == null ){
			throw new ServiceException("参数错误");
		}
		User user = new User();
		user.setAccount(account);
		user.setCreateTime(new Date());
		userMapper.insertSelective(user);
		
		return user;
	}
	
	
}
