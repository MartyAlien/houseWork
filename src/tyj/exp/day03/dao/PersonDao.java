package tyj.exp.day03.dao;

import java.util.List;

import tyj.exp.day03.Person.Person;

public interface PersonDao {
	// 查询所有记录
	public List<Person> queryAllPersons();
	// 查询单条记录
	public Person queryOnePerson(int id);
	// 插入一条记录
	public int insertIntoPerson(String name,String userName,String passWord,int age,String descInfo,double height);
	// 按id删除一条记录
	public int deleteTupleByID(int id);
	// 按name删除一条记录
	public int deleteTupleByName(String name);
	// 修改一条记录
	public int modifyTuple(String newName,int age,double newHeight,int id);
}
