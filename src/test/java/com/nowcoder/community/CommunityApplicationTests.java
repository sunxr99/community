package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.AlphaDaoHibernateImpl;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;

	}
	@Test
	public void testBeanManagement(){
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		AlphaService alphaService1=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void contextLoads() {
		AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());
	}
	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	@Autowired
	private AlphaDao alphaDao;
	@Test
	public void testDI(){
		System.out.println(alphaDao);
	}
	@Test
	public void test(){
		AlphaDaoHibernateImpl alphaDaoHibernate=new AlphaDaoHibernateImpl();
		System.out.println(alphaDaoHibernate.select());
	}
	@Test
	public  void testQue()
	{
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(null);
		if(queue.isEmpty())
		{
			System.out.println("空");
		}


	}


}
