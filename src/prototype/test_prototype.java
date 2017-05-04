package prototype;

import static org.junit.Assert.*;

import org.junit.*;

public class test_prototype {

	private Sheep sheep;

	private String name = "Mary";
	private String sex = "female";
	private String color = "white";
	
	@Before
	public void setup(){
		sheep = new Sheep(name, sex, color);
	}
	
	@Test
	public void test_sheep_clone(){
		Sheep dolly = (Sheep)sheep._clone();

		assertEquals(name, dolly.name);
		assertEquals(sex, dolly.sex);
		assertEquals(color, dolly.color);
	}
	
}
