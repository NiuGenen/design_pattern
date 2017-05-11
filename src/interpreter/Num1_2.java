package interpreter;

import java.text.ParseException;

//num1_2 := num1   |  num2
public class Num1_2 extends Node{

	@Override
	public void parse(Context context)
			throws ParseException {
		if(context.checkToken(Num1.tokens, 0) || context.checkToken(Num_1.tokens, 0)){
			Final.getInstance().add('0');
			
			Node num1 = new Num1();
			num1.parse( context );
		}
		else{
			Node num2 = new Num2();
			num2.parse( context );
		}
	}

}
