package com.beanDAO;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		//ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		//ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		/*
		 * StudentDAO dao=context.getBean("StudentDAO",StudentDAO.class);
		 * dao.selectAllRows(); // close method is not available in Applicationcontext
		 * it is available in ClassPathXmlApplicationContext class.so,we have
		 * downcasted.. //((ClassPathXmlApplicationContext)context).close();
		 * //((ClassPathXmlApplicationContext)context).registerShutdownHook();
		 * //context.close(); context.registerShutdownHook(); StudentDAO
		 * dao1=context.getBean("StudentDAO",StudentDAO.class);
		 */
		//commenting from line no 14 to 22 to just implement third method by implementing interface
		Hello dao=context.getBean("hello",Hello.class);
		dao.sample();
	    context.close();
	    
	    
	    //There are 3 ways to configure life cycle methods in spring.
	   /* 1.Annotation approach
	    2.XML approach
	    3.By implementing interface*/
	}
}
