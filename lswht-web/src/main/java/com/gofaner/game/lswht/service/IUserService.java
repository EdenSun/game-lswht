package com.gofaner.game.lswht.service;

import com.gofaner.game.lswht.dto.ViewDTO;
import com.gofaner.game.lswht.exception.ServiceException;
import com.gofaner.game.lswht.model.User;

public interface IUserService {

	void resetPlayTime()throws ServiceException;

	ViewDTO<Integer> getPlayTime(String loginToken)throws ServiceException;

	User getByAccount(String account)throws ServiceException;

	User saveUserByAccount(String account)throws ServiceException;

}
