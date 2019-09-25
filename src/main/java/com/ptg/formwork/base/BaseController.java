/**
 * 
 */
package com.ptg.formwork.base;

import com.alibaba.fastjson.JSONObject;

import com.ptg.formwork.commons.RestResponseModel;
import com.ptg.formwork.enums.EnumMsgCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * Controller 的基类
 * @author DR XZT
 *
 */
public class BaseController {
	//token 名称
	public static final String AUTHORIZATION = "Authorization";

	/**
	 * logger类
	 * @author DR XZT
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * 业务处理成功
	 * @param resultData
	 * @return
	 */
	protected RestResponseModel success(Object resultData) {
		if (resultData == null) {
			resultData = new JSONObject();
		}
		return createResultModel(true,false, EnumMsgCode.MSG_SUCCESS, resultData,null);
	}

	/**
	 * 业务处理成功（加密）
	 * @param resultData
	 * @return
	 */
	protected RestResponseModel encryptSuccess(Object resultData,String systemId) {
		if (resultData == null) {
			resultData = new JSONObject();
		}
		return createResultModel(true,true, EnumMsgCode.MSG_SUCCESS, resultData,systemId);
	}


	/**
	 * 业务失败
	 * @param code
	 * @return
	 */
	protected RestResponseModel error(EnumMsgCode code) {
		return createResultModel(false,false, code, new JSONObject(),null);
	}

	/**
	 * 业务失败
	 * @param code
	 * @return
	 */
	protected RestResponseModel error(String code,String description) {
		return createResultModel(false,false, code,description, new JSONObject(),null);
	}

	/**
	 * 业务失败2
	 * @return
	 */
	protected RestResponseModel error() {
		return createResultModel(false,false, EnumMsgCode.MSG_SYS_ERROR, null,null);
	}


	/**
	 * 创建返回给客户端的结果对象
	 * @param isSuccess
	 * @param code
	 * @param resultData
	 * @return
	 */
	private RestResponseModel createResultModel(Boolean isSuccess,Boolean encrypt, EnumMsgCode code, Object resultData,String systemId) {
		
		RestResponseModel result = new RestResponseModel();
		result.setEncrypt(false);

		if ( isSuccess == null || !isSuccess ) {
			result.setSuccess(false);
			if ( code == null ) {
				result.setCode(EnumMsgCode.MSG_SYS_ERROR.getCode());
				result.setDescription(EnumMsgCode.MSG_SYS_ERROR.getDescription());
			}
			else {
				result.setCode(code.getCode());
				result.setDescription(code.getDescription());
			}
			
			
		}
		else {
			result.setSuccess(true);
			result.setCode(EnumMsgCode.MSG_SUCCESS.getCode());
			result.setDescription(EnumMsgCode.MSG_SUCCESS.getDescription());
		}
		
		
		if ( resultData == null ) {
			result.setResult(new JSONObject());
		}
		else {
			result.setResult(resultData);
		}

		if (systemId != null) {
			result.setSystemId(systemId);
		}
		result.setSystemTime(new Date());
		return result;
	}


	/**
	 * 创建返回给客户端的结果对象
	 * @param isSuccess
	 * @param code
	 * @param resultData
	 * @return
	 */
	private RestResponseModel createResultModel(Boolean isSuccess,Boolean encrypt, String code,String description, Object resultData,String systemId) {

		RestResponseModel result = new RestResponseModel();
		result.setEncrypt(false);

		if ( isSuccess == null || !isSuccess ) {
			result.setSuccess(false);
			if ( code == null ) {
				result.setCode(EnumMsgCode.MSG_SYS_ERROR.getCode());
				result.setDescription(EnumMsgCode.MSG_SYS_ERROR.getDescription());
			}
			else {
				result.setCode(code);
				result.setDescription(description);
			}
		}
		else {
			result.setSuccess(true);
			result.setCode(EnumMsgCode.MSG_SUCCESS.getCode());
			result.setDescription(EnumMsgCode.MSG_SUCCESS.getDescription());
		}


		if ( resultData == null ) {
			result.setResult(new JSONObject());
		}
		else {
			result.setResult(resultData);
		}

		if (systemId != null) {
			result.setSystemId(systemId);
		}
		result.setSystemTime(new Date());
		return result;
	}


	
}
