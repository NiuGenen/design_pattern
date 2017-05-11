package interpreter;

import java.text.ParseException;

//num_2 := num__2 |  num__2 num_1
public class Num_2 extends Node{

	@Override
	public void parse(Context context)
			throws ParseException {
		Node num__2 = new Num__2();
		num__2.parse( context );
		
		if(context.checkToken(Num_1.tokens, 0)){
			Node num_1 = new Num_1();
			num_1.parse( context );
		}
		else{
			Final.getInstance().add('0');
		}
	}

}
