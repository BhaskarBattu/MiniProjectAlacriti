package com.alacriti.imdb.bo;

import com.alacriti.imdb.constraints.ErrorConstants;
import com.alacriti.imdb.dao.BaseException;


public class BOException extends BaseException {

	public BOException() {
	}

	public BOException(String msg, Throwable th, String errorCode) {
		super(msg, th, errorCode);
	}

	public BOException(Throwable th, String errorCode) {
		this(null, th, errorCode);
	}

	/*public BOException(String msg, Throwable th) {

		this(msg, th, ErrorConstants.ERR_GENERIC_DAO);
	}

	public BOException(Throwable th) {
		this(null, th, ErrorConstants.ERR_GENERIC_DAO);
	}*/

	public BOException(String msg, String errorCode) {
		this(msg, null, errorCode);
	}

	public BOException(String msg) {
		super(msg);
	}
}
