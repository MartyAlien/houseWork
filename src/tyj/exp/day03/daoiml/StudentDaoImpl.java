package tyj.exp.day03.daoiml;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tyj.JDBC.DruidJDBCutils;

import tyj.exp.day03.dao.StduentDao;
import tyj.exp.day03.student.Student;

public class StudentDaoImpl implements StduentDao{
	JdbcTemplate jt=new JdbcTemplate(DruidJDBCutils.getDataSource());
	@Override
	public List<Student> queryAllStdeunt() {
		String sql="select sname,sno,ssex from student";
		List<Student> list = jt.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
		return list;
	}
	@Override
	public int insertLineToStudent(String sno, String sname, String ssex) {
		String sql="insert into student values(?,?,?,null,null)";
		int update = jt.update(sql, sno,sname,ssex);
		return update;
	}
	
}
