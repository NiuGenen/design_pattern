package interpreter;

import java.text.ParseException;

import org.junit.*;

public class textEnglishNumber {

	private String n1 = "Six billion twenty million three hundred thousand five hundred thirty two and";
	private String n2 = "Six billion twenty million three hundred one thousand five hundred thirty two and";
	private String n3 = "Six billion twenty million three hundred eleven thousand five hundred thirty two and";
	private String n4 = "Zero billion twenty million three hundred thousand five hundred thirty two and";
	private String n5 = "Six billion Zero million three hundred thousand five hundred thirty two and";
	
	@Test
	public void test_english_number() throws ParseException{
		String[] texts = {n1,n2,n3,n4,n5};
		for(String text: texts){
			System.out.println("text = \"" + text + "\"");
			Node node = new EnglishNumberNode();
			node.parse( new Context(text) );
			System.out.println("node = " + node);
			System.out.println();
		}
	}
}
