package tyj.exp.day03.mainClass;

import java.util.List;

import tyj.exp.day03.Person.Person;
import tyj.exp.day03.daoiml.PersonDaoImpl;

public class Demo_Person {
	public static void main(String[] args) {
		PersonDaoImpl daoImpl=new PersonDaoImpl();
		
		// 按id查询记录
		//findOne(daoImpl);
		
		// 修改id为5的记录
		//modify(daoImpl);		
		
		// 插入一条记录
		//insertTup(daoImpl);
		
		// 按照id删除
		//System.out.println("已删除"+daoImpl.deleteTupleByID(8)+"条记录");
		
		// 按照姓名删除
		//daoImpl.deleteTupleByName("亚索");
		
		// 查询person表中所有记录
		System.out.println();
		findAll(daoImpl);
	}

	public static void findOne(PersonDaoImpl daoImpl) {
		Person person = daoImpl.queryOnePerson(4);
		System.out.println(person);
	}

	public static void insertTup(PersonDaoImpl daoImpl) {
		int insertIntoPerson = daoImpl.insertIntoPerson("大嘴", "heliuking", "131315",45, "ADC, 中路，肉", 1.56);
		System.out.println(insertIntoPerson);
	}

	public static void modify(PersonDaoImpl daoImpl) {
		daoImpl.modifyTuple("女枪",24, 1.68, 5);
	}

	public static void findAll(PersonDaoImpl daoImpl) {
		List<Person> personList = daoImpl.queryAllPersons();
		for (Person person : personList) {
			System.out.println(person);
		}
	}
}
