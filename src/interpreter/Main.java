package interpreter;

import java.text.ParseException;

//english_number:	billion million thousand num3 'and'
//billion:			num3 'billion'	//no null but 'zero billion'
//million:			num3 'million'
//thousand:			num3 'thousand'
//num3:				num1_2 |  num_1 'hundred' num_1_2
//num_1_2:			num_1  |  num2
//num1_2:			num1   |  num2
//num1:				zero   |  num_1
//num_1:			one|two|three|four|five|six|seven|eight|nine
//num2:				ten|eleven|twelve|thirteen|fourteen|fifteen|sixteen|seventeen|eighteen|nineteen | num_2
//num_2:			num__2 |  num__2 num_1
//num__2:			twenty|thirty|forty|fifty|sixty|seventy|eighty|ninety

public class Main {

	public static void main(String[] args) {
		try {
			String text = "Six billion twenty million three hundred thousand five hundred thirty two and";
			System.out.println("text = \"" + text + "\"");
			Node node = new EnglishNumberNode();
			node.parse( new Context(text) );
			System.out.println("node = " + node);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println(Final.getInstance().toString());
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
