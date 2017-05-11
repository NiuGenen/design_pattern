package interpreter;

import java.text.ParseException;

//num3 := num1_2 |  num_1 'hundred' num_1_2
public class Num3 extends Node{

	@Override
	public void parse(Context context) throws ParseException {
		if(context.checkToken("hundred", 1)){
			if( Context.isDebug ) System.out.println("[debug] find hundred.");
			
			Node num_1 = new Num_1();
			num_1.parse( context );

			context.skipToken("hundred");

			if(		/*context.checkToken(Num_1.tokens, 0) 	|| 
					context.checkToken(Num__2.tokens, 0)	|| 
					context.checkToken(Num2.tokens, 0)*/
					context.checkToken(Num_1_2.getTokens(), 0)
			){
				Node num_1_2 = new Num_1_2();
				num_1_2.parse( context );
			}
			else{
				Final.getInstance().add('0');
				Final.getInstance().add('0');
			}
		}
		else{
			Final.getInstance().add('0');
			
			Node num1_2 = new Num1_2();
			num1_2.parse( context );
		}
		
	}

}
