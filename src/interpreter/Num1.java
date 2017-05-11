package interpreter;

import java.text.ParseException;

//num1 := zero   |  num_1
public class Num1 extends Node{
	
	public final static String[] tokens = {
			"zero"
	};

	@Override
	public void parse(Context context)
			throws ParseException {
		if(context.checkToken(tokens, 0)){
			context.skipToken(tokens);
			
			Final.getInstance().add('0');
		}
		else{
			Node num_1 = new Num_1();
			num_1.parse( context );
		}
	}

}
