package com.beanDAO;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertiesSet method");

	}

	/*
	 * public void init() { System.out.println("Hello class init method"); }
	 * 
	 * public void destroy() { System.out.println("Hello class destroy method"); }
	 */
	public void sample() {
		System.out.println("Actual coding starts from here..");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside destroy method");
	}

}
