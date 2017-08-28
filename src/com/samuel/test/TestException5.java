package com.samuel.test;

public class TestException5 extends TestException4 {
	// compile error  ????
//	public void start() throws Exception{
//	}
	
	// no compile error
	@Override
	public void start() {
		
	}
	
	// no compile error ???
	public void foo() throws RuntimeException{
		
	}
}
