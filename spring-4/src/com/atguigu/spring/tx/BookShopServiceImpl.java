package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	
	//�������ע��
	//1.ʹ��propagation����ָ������Ĵ�����Ϊ
	//2.ʹ��isolation����ָ������ĸ��뼶��
	//3.Ĭ�������Spring������ʽ��������е�����ʱ�쳣���лع���Ҳ����ͨ����Ӧ�����Խ������� noRollbackFor
	//4.����ͨ��readOnly����ָ�������Ƿ�Ϊֻ��(Ϊֻ��ʱ���ݿ�ɶ�ֻ����������Ż�(������)�����Ч��)
	//5.����ʹ��timeout����ָ��ǿ�ƻع�֮ǰ�����ռ�õ�ʱ��
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, readOnly = false)
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}

}
