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
	 *  ���Bean���T�ؤ覡:
	 *  
	 *  	1. �ھ�Bean��id���
	 *  	
	 *  	2. �ھ�Bean���������
	 * 		   �`�N: �ھ��������Bean��, �����T�OIOC�t�m��󤺮e��
	 * 				 ���B�u���@��Bean��������.
	 * 		
	 * 		3. �ھ�Bean��Id�M�������
	 * 
	 * 		����: �}�o��, �覡2�̱`�Q�ϥ�.
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
		// ����Bean�L�k�ѥ~���ե�
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
		// ���ս�Ȭ�null
//		System.out.println(student.getGender());
//		System.out.println(student.getGender().toString());
		
	}
	
	@Test
	public void testDI() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_Ioc_config.xml");
		
		// �ھ�setter�`�J
//		Student student = ioc.getBean("studentTwo", Student.class);
//		System.out.println(student);
		
		// �ھ�constructor�`�J
		Student student = ioc.getBean("studentThree", Student.class);
		System.out.println(student);
		
	}
	
	@Test
	public void testPerson() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_ioc_config.xml");
		// �u�nIOC��󤤦����f�Ω�H������{��, �Y�i�H�ھڱ��f�Ω�H�������������{����Bean.
		// ���bIOC��󤤯S�w���f�Ω�H������{�������O�ߤ@
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
		
		// q. �p�G�������bIOC�t�m��󤣶ȥX�{�L�@��, �]��IOC�L�k�T�{��ߤ@����, 
		// 	  �G�|����NoUniqueBeanDefinitionException
		// w. �p�G�������bIOC�t�m���S�X�{�L
		// 	  �h�|����NoSuchBeanDefinitionException
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
