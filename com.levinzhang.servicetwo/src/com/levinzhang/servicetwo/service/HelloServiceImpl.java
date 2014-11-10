package com.levinzhang.servicetwo.service;

import com.levinzhang.serviceinterface.HelloService;

public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHello() {
		System.out.println("The Content form Bundle two blabla");
	}

}
