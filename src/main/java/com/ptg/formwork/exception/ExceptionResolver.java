package com.ptg.formwork.exception;


import com.alibaba.fastjson.JSONObject;

import com.ptg.formwork.commons.MyException;
import com.ptg.formwork.commons.RestResponseModel;
import com.ptg.formwork.enums.EnumMsgCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author DR XZT
 *
 */
@ControllerAdvice
public class ExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);
	
	@ExceptionHandler(MyException.class)
	@ResponseBody
	public RestResponseModel handlerMyException(HttpServletRequest request, Exception ex) {
		
		MyException tempEX = (MyException)ex;

		EnumMsgCode code;
		String defineCode = tempEX.getCode();
		String msg = tempEX.getMsg();
		if (defineCode == null) {
			code = EnumMsgCode.MSG_SYS_ERROR;
		} else {
			code = EnumMsgCode.MSG_BIZ_ERROR;
			code.setCode(defineCode);
			code.setDescription(msg);
		}
		RestResponseModel model = new RestResponseModel();
		model.setSuccess(false);
        model.setResultInfo(code);
        model.setEncrypt(false);
		model.setResult(new JSONObject());
		
		logger.error("\npath : {}\n errorCode : {}\n msg:{}\n", request.getServletPath(), code, code.getDescription());
		
		return model;
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public RestResponseModel handlerException(HttpServletRequest request, Exception ex) { 
		
		RestResponseModel model = new RestResponseModel();
		model.setSuccess(false);
		model.setResultInfo(EnumMsgCode.MSG_SYS_ERROR);
		model.setResult(new JSONObject());
		
		logger.error("\npath : {}\n", request.getServletPath(), ex);
		
		return model;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public RestResponseModel handlerJSRException(HttpServletRequest request, MethodArgumentNotValidException ex) {
		RestResponseModel model = new RestResponseModel();
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		model.setSuccess(false);
		String message;
		if(errors != null && errors.size() > 0) {
			message = errors.get(0).getDefaultMessage();
			model.setResultInfo(EnumMsgCode.MSG_0005, message);
		} else {
			message = EnumMsgCode.MSG_0005.getDescription();
			model.setResultInfo(EnumMsgCode.MSG_0005);
		}
		model.setResult(new JSONObject());
		logger.error("\npath:{}\n msg:{}\n", request.getServletPath(), message);
		return model;
	}
	
	
	
	
	
	
	

}
