package com.chainsys.busticketapp.util;

public class Logger {
	public static Logger getInstance()
	{
		Logger log=new Logger();
		return log;
	}
	public void getInput(Object message) {
		System.out.println(message);
	}
	public void debug(Object message) {
		System.out.println(message);
	}
	public void error(Object message) {
		System.err.println(message);
	}
	public void error(Exception e) {
		System.out.println(e.getMessage());
		
	}

}
