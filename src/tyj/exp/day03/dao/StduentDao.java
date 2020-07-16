package tyj.exp.day03.dao;

import java.util.List;

import tyj.exp.day03.student.*;
public interface StduentDao {
	public List<Student> queryAllStdeunt();
	public int insertLineToStudent(String sno,String sname,String ssex);
}
