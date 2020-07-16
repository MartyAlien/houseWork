package tyj.exp.day03.Person;

public class Person {
	private int id;
	private String name;
	private String userName;
	private String passWord;
	private int age;
	private String descInfo;
	private double height;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id,String name, String userName, String passWord,int age, String descInfo, double height) {
		this.id=id;
		this.name = name;
		this.userName = userName;
		this.passWord = passWord;
		this.age=age;
		this.descInfo = descInfo;
		this.height = height;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescInfo() {
		return descInfo;
	}
	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return id+"  "+name + "[ userName=" + userName + "\tpassWord=" + passWord + "\tadg="+ age +"\tdescInfo=" + descInfo
				+ "\theight=" + height + "m ]";
	}
	
}
