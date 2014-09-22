package com.gofaner.game.lswht.service;

import java.util.List;

import com.gofaner.game.lswht.dto.ExchangeCodeView;
import com.gofaner.game.lswht.dto.ViewDTO;
import com.gofaner.game.lswht.exception.ServiceException;

public interface IExchangeCodeService {

	ViewDTO<List<ExchangeCodeView>> listMyCodes(String userid)throws ServiceException;

	ViewDTO<ExchangeCodeView> deliverCode(String userid, Integer codeType, String remoteIP)throws ServiceException;


}
