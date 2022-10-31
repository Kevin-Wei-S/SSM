package com.kwei.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.pojo.Clazz;
import com.kwei.spring.pojo.Person;
import com.kwei.spring.pojo.Student;

public class IOCByXmlTest {

	/**
	 *  獲取Bean的三種方式:
	 *  
	 *  	1. 根據Bean的id獲取
	 *  	
	 *  	2. 根據Bean的類型獲取
	 * 		   注意: 根據類型獲取Bean時, 必須確保IOC配置文件內容中
	 * 				 有且只有一個Bean為此類型.
	 * 		
	 * 		3. 根據Bean的Id和類型獲取
	 * 
	 * 		結論: 開發中, 方式2最常被使用.
	 */
	
	@Test
	public void testPRestrict() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Student student = ioc.getBean("studentSeven", Student.class);
		System.out.println(student);
		
	}
	
	@Test
	public void testProfessorMap() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Student student = ioc.getBean("studentWithProfessorMap", Student.class);
		System.out.println(student);
		
	}
	
	
	@Test
	public void testStudentList() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Clazz clazz = ioc.getBean("clazzThree", Clazz.class);
		List<Student> list = clazz.getStudents();
		list.forEach(System.out::println);
		
	}
	
	@Test
	public void testStudentsOfClazz() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Clazz clazz = ioc.getBean("clazzThree", Clazz.class);
		List<Student> students = clazz.getStudents();
		System.out.println(clazz);
		System.out.println();
		students.forEach(System.out::println);
//		for(Student s : students) {
//			System.out.println(s);
//		}
		
	}
	
	@Test
	public void testHobby() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Student student = ioc.getBean("studentSix", Student.class);
		System.out.println(student);
		
	}
	
	@Test
	public void testInnerClazz() {
		// 內部Bean無法由外部調用
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Clazz clazz = ioc.getBean("innerClazz", Clazz.class);
		System.out.println(clazz);
		
	}
	
	@Test
	public void testClazz() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Student student = ioc.getBean("studentFive", Student.class);
		System.out.println(student);
		
	}
	
	@Test
	public void testDI1() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Student student = ioc.getBean("studentFour", Student.class);
		System.out.println(student);
		// 測試賦值為null
//		System.out.println(student.getGender());
//		System.out.println(student.getGender().toString());
		
	}
	
	@Test
	public void testDI() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		
		// 根據setter注入
//		Student student = ioc.getBean("studentTwo", Student.class);
//		System.out.println(student);
		
		// 根據constructor注入
		Student student = ioc.getBean("studentThree", Student.class);
		System.out.println(student);
		
	}
	
	@Test
	public void testPerson() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_ioc_config.xml");
		// 只要IOC文件中有接口或抽象類的實現類, 即可以根據接口或抽象類的類型獲取實現類的Bean.
		// 但在IOC文件中特定接口或抽象類的實現類必須是唯一
		Person p = ioc.getBean(Person.class);
		System.out.println(p);
		
//		Creature c = ioc.getBean(Creature.class);
//		System.out.println(c);
		
	}
	
	@Test
	public void testStudent() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		Student studentOne = (Student) ioc.getBean("studentOne");
		System.out.println(studentOne);
		
		// q. 如果此類型在IOC配置文件不僅出現過一次, 因為IOC無法確認到唯一類型, 
		// 	  故會報錯NoUniqueBeanDefinitionException
		// w. 如果此類型在IOC配置文件沒出現過
		// 	  則會報錯NoSuchBeanDefinitionException
//		Student studentTwo = ioc.getBean(Student.class);
//		System.out.println(studentTwo);		
		
//		Student studentThree = ioc.getBean("studentTwo", Student.class);
//		System.out.println(studentThree);
		
	}
	
	@Test
	public void test() {
		
//		Student s = new Student();
//		System.out.println(s instanceof Creature);
		System.out.println(null == null);
		System.out.println();
		
	}
	
}
