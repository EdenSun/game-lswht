package com.gofaner.game.lswht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofaner.game.lswht.dao.ExchangeCodeMapper;
import com.gofaner.game.lswht.dto.ExchangeCodeView;
import com.gofaner.game.lswht.dto.ViewDTO;
import com.gofaner.game.lswht.exception.ServiceException;
import com.gofaner.game.lswht.model.ExchangeCode;
import com.gofaner.game.lswht.model.ExchangeCodeExample;
import com.gofaner.game.lswht.model.ExchangeCodeExample.Criteria;
import com.gofaner.game.lswht.model.User;
import com.gofaner.game.lswht.service.IExchangeCodeService;
import com.gofaner.game.lswht.service.IUserService;
import com.gofaner.game.lswht.util.ExchangeCodeConst;

@Service
public class ExchangeCodeServiceImpl implements IExchangeCodeService {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ExchangeCodeMapper exchangeCodeMapper;
	
	@Override
	public ViewDTO<List<ExchangeCodeView>> listMyCodes(String userid)
			throws ServiceException {
		ViewDTO<List<ExchangeCodeView>> view = new ViewDTO<List<ExchangeCodeView>>();
		if( userid == null ){
			view.setMsg("参数不能为空");
			view.setCode(ViewDTO.CODE_ERROR);
			return view;
		}
		
		String account = userid;
		User user = userService.getByAccount(account);
		
		if( user == null ){
			view.setMsg("用户不存在");
			view.setCode(ViewDTO.CODE_ERROR);
			return view;
		}
		
		ExchangeCodeExample example = new ExchangeCodeExample();
		Criteria criteria = example.createCriteria();
		criteria.andOwnerIdEqualTo(user.getId());
		
		List<ExchangeCode> codeList = exchangeCodeMapper.selectByExample(example);
		
		List<ExchangeCodeView> codeViewList = trans2ExchangeCodeViewList(codeList);
		view.setData(codeViewList);
		
		return view;
	}

	private List<ExchangeCodeView> trans2ExchangeCodeViewList(
			List<ExchangeCode> codeList) {
		if( codeList == null ){
			return null;
		}
		List<ExchangeCodeView> viewList = new ArrayList<ExchangeCodeView>();
		ExchangeCodeView view = null;
		for(int i=0;i<codeList.size() ;i++){
			ExchangeCode code = codeList.get(i);
			
			view = trans2ExchangeCodeView(code);
			if( view != null ){
				viewList.add(view);
			}
		}
		return viewList;
	}

	private ExchangeCodeView trans2ExchangeCodeView(ExchangeCode code) {
		if( code == null ){
			return null;
		}
		ExchangeCodeView view = new ExchangeCodeView();
		
		BeanUtils.copyProperties(code, view);
		
		return view;
	}

	/*@Override
	public ViewDTO<ExchangeCodeView> deliverCode(String userid, Integer codeType)
			throws ServiceException {
		ViewDTO<ExchangeCodeView> view = new ViewDTO<ExchangeCodeView>();
		if( userid == null || codeType == null){
			view.setMsg("参数不正确");
			view.setCode(ViewDTO.CODE_ERROR);
			return view;
		}
		
		ExchangeCodeExample example = new ExchangeCodeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(codeType);
		criteria.andStatusEqualTo(ExchangeCodeConst.STATUS_NEW);
		
		List<ExchangeCode> codeList = exchangeCodeMapper.selectByExample(example);
		
		if( codeList == null || codeList.size() == 0 ){
			return view;
		}
		
		ExchangeCode code = codeList.get(0);
		ExchangeCodeView codeView = this.trans2ExchangeCodeView(code);
		view.setData(codeView);
		
		// check current user whether is exists 
		String account = userid;
		User user = userService.getByAccount(account);
		if( user == null ){
			// if user is not exists,create user
			user = userService.saveUserByAccount(account);
		}
		
		//update code to delivered
		code.setStatus(ExchangeCodeConst.STATUS_DELIVERED);
		code.setOwnerId(user.getId());
		exchangeCodeMapper.updateByPrimaryKey(code);
		
		return view;
	}*/
	@Override
	public ViewDTO<ExchangeCodeView> deliverCode(String userid, Integer codeType,String remoteIP)
			throws ServiceException {
		ViewDTO<ExchangeCodeView> view = new ViewDTO<ExchangeCodeView>();
		if( userid == null || codeType == null){
			view.setMsg("参数不正确");
			view.setCode(ViewDTO.CODE_ERROR);
			return view;
		}
		
		/*
		 *  same ip can not get code for more than 10 times 
		 */
		Integer count = exchangeCodeMapper.getCountByOwnerIPForUpdate(remoteIP);
		if( count != null && count >= 10 ){
			view.setMsg("已达到IP次数限制");
			view.setCode(ViewDTO.CODE_ERROR);
			return view;
		}
		
		// check current user whether is exists 
		String account = userid;
		User user = userService.getByAccount(account);
		if( user == null ){
			// if user is not exists,create user
			user = userService.saveUserByAccount(account);
		}
				
		int status = ExchangeCodeConst.STATUS_NEW;
		ExchangeCode code = exchangeCodeMapper.getUniqueCode(codeType,status);
		
		if( code == null ){
			view.setMsg("兑换码发放完毕");
			view.setCode(ViewDTO.CODE_ERROR);
			return view;
		}
		
		ExchangeCodeView codeView = this.trans2ExchangeCodeView(code);
		view.setData(codeView);
		
		//update code to delivered
		code.setStatus(ExchangeCodeConst.STATUS_DELIVERED);
		code.setOwnerId(user.getId());
		code.setOwnerIp(remoteIP);
		exchangeCodeMapper.updateByPrimaryKey(code);

		return view;
	}
	
}
