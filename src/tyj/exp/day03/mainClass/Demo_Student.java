package tyj.exp.day03.mainClass;

import java.util.List;

import tyj.exp.day03.daoiml.StudentDaoImpl;
import tyj.exp.day03.student.Student;

public class Demo_Student {
	public static void main(String[] args) {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		//queryStu(studentDaoImpl);
		//insertTuples(studentDaoImpl);
	}

	public static void insertTuples(StudentDaoImpl studentDaoImpl) {
		int line = studentDaoImpl.insertLineToStudent("19144633", "黄晓明", "男");
		System.out.println(line);
	}

	public static void queryStu(StudentDaoImpl studentDaoImpl) {
		List<Student> list=studentDaoImpl.queryAllStdeunt();
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
