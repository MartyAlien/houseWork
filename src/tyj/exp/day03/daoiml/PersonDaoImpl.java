package tyj.exp.day03.daoiml;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tyj.JDBC.DruidJDBCutils;

import tyj.exp.day03.Person.Person;
import tyj.exp.day03.dao.PersonDao;

public class PersonDaoImpl implements PersonDao{
	JdbcTemplate jt=new JdbcTemplate(DruidJDBCutils.getDataSource());
	String sql;
	@Override
	public List<Person> queryAllPersons() {
		System.out.println("查询所有记录：");
		sql="select * from person";
		List<Person> list = jt.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
		return list;
	}
	
	@Override
	public Person queryOnePerson(int id) {
		System.out.println("查询id="+id+"记录：");
		sql="select * from person where id=?";
		Person person = jt.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class), id);
		return person;
	}

	@Override
	public int insertIntoPerson(String name, String userName, String passWord,int age, String descInfo, double height) {
		System.out.println("插入记录 [ "+name+", "+userName+", "+passWord+", "+age+", "+descInfo+", "+height+" ]");
		sql="insert into person(name,userName,passWord,age,descInfo,height) values(?,?,?,?,?,?)";
		int updateLine = jt.update(sql, name,userName,passWord,age,descInfo,height);
		return updateLine;
	}

	@Override
	public int deleteTupleByID(int id) {
		sql="delete from person where id=?";
		int deleteLine = jt.update(sql, id);
		return deleteLine;
	}

	@Override
	public int deleteTupleByName(String name) {
		System.out.println("删除name="+name+"记录：");
		sql="delete from person where name=?";
		int deleteLine = jt.update(sql, name);
		return deleteLine;
	}

	@Override
	public int modifyTuple(String newName, int age, double newHeight, int id) {
		System.out.println("修改记录：");
		sql="update person set name = ?,age = ?,height = ? where id=?";
		int modifyLine = jt.update(sql, newName,age,newHeight,id);
		return modifyLine;
	}

	
}
