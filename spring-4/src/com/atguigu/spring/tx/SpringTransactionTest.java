package com.atguigu.spring.tx;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringTransactionTest {
	
	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao = (BookShopDao)ctx.getBean("bookShopDao");
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testTransactionPropagation() {
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
	
//	@Test
//	public void testBookShopService() {
//		bookShopService.purchase("AA", "1001");
//	}
	
//	@Test
//	void testUpdateUserAccount() {
//		bookShopDao.updateUserAccount("AA", 200);
//	}
	
//	@Test
//	void testUpdateBookStock() {
//		bookShopDao.updateBookStock("1001");
//	}
//	
//	@Test
//	void testFindBookPriceByIsbn() {
//		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
//	}
}
