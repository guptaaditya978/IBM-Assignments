package com.parallel.spring_parallelproject_adityagupta;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.parallel.test.bean.Wallet;
import com.parallel.test.service.ServiceParallel;
import com.parallel.test.ui.Menu;



/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
	
    public static void main( String[] args )
    {
    	
    	
    	
    	
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
//        JDBCDao eng = context.getBean("dao",JDBCDao.class);
    		Menu ms = context.getBean("menu",Menu.class);
    		ms.menuDriven();
    		
//        NamedParamDemo nd = context.getBean("namedDao",NamedParamDemo.class);
//        //System.out.println(nd.getName(101));
//        Student student = new Student(103,"Aman","Kolkata");
//        //eng.updateRecord(student, "Mumbai");
//        //eng.insertRecord(student);
//        eng.deleteRecord(student);
//        //System.out.println(eng.names(101));
//       //System.out.println(eng.different("peehu"));
//        //System.out.println(eng.allUsers());
    }
    
    
}
