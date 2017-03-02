package com.lee.demo.testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Demo for TestNG
 * 
 * @author hzlifan
 *
 */
public class TestNGDemo {

	/**
	 * 断言
	 */
	@Test
	public void test0() {
		Assert.assertEquals("ok", "fail");
	}

	/**
	 * 使用DataProvider注入参数
	 * 
	 * @param user
	 * @param pass
	 */
	@Test(dataProvider = "kv")
	public void test1(String user, String pass) {
		System.out.println("user = " + user + ", pass = " + pass);
	}

	/**
	 * 配置文件的形式注入参数(<parameter name="XX" value="YY" />)
	 * 
	 * @param user
	 */
	@Test
	@Parameters("user")
	public void test2(String user) {
		System.out.println("user = " + user);
	}

	/**
	 * 忽略不执行
	 */
	@Test(enabled = false)
	public void test3() {
		System.out.println("This test case will be ignored");
	}

	/**
	 * 测试异常
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void test4() {
		System.out.println("test4()...");
		throw new IllegalArgumentException("NPE");
	}

	/**
	 * 指定依赖的方法，即依赖方法完成后才能调用本方法
	 */
	@Test(dependsOnMethods = "test4")
	public void test5() {
		System.out.println("depends on method test4()");
	}

	/**
	 * 独立执行，无需配置在xml中，直接右键该方法名并运行
	 */
	@Test
	public void test6() {
		System.out.println("run standalone, not configured in xml");
	}

	@Test(groups = { "testGroup1" })
	public void test10() {
		System.out.println("hello");
	}

	@Test(groups = { "testGroup1" })
	public void test11() {
		System.out.println("world");
	}

	@Test(groups = { "testGroup2" })
	public void test12() {
		System.out.println("yes");
	}

	@Test(groups = { "testGroup3" })
	public void test13() {
		System.out.println("no");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest...");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest...");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod...");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod...");
	}

	@DataProvider
	public Object[][] kv() {
		return new Object[][] { new Object[] { "fl", "123" },
				new Object[] { "mj", "789" }, };
	}

}
