package pojo;

public class Student {
private int a;
private int b;
public Student(int a,int b) {
	this.a=a;
	this.b=b;
}
public int getDecr() {
	a--;
	b--;
	return a+b;
}
public int getA() {
	return a;
}
public void setA(int a) {
	this.a = a;
}
public int getB() {
	return b;
}
public void setB(int b) {
	this.b = b;
}
}
