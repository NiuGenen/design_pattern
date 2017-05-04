package prototype;

public class Sheep implements IClone{

	String name;
	String sex;
	String color;
	
	public Sheep(String n, String s, String c){
		name = n;
		sex = s;
		color = c;
	}
	
	@Override
	public Object _clone() {
		return new Sheep(name, sex, color);
	}
	
	
}
