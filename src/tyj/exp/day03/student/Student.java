package tyj.exp.day03.student;

public class Student {
	private String sname;
	private String sno;
	private String ssex;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String sname, String sno, String ssex) {
		super();
		this.sname = sname;
		this.sno = sno;
		this.ssex = ssex;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sno=" + sno + ", ssex=" + ssex + "]";
	}
	
}
