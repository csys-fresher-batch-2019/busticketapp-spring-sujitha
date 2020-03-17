package com.chainsys.busticketapp.exception;

public class DbException extends Exception {
	private static final long serialVersionUID = 1L;

	public DbException(String msg, Throwable e)
	{
	super(msg,e);	
	}

	public DbException(String msg) {
		super(msg);
	}
	
}
