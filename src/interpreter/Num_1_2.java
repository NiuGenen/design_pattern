package interpreter;

import java.text.ParseException;
import java.util.Arrays;

//num_1_2 := num_1  |  num2
public class Num_1_2 extends Node{
	
	public static String[] getTokens(){
		return tokens;
	}
	private static String[] tokens = {};
	static{
		tokens = Arrays.copyOf(tokens, Num_1.tokens.length + Num__2.tokens.length + Num2.tokens.length);
		int dstPos = 0;
		
		System.arraycopy(Num_1.tokens, 	0, tokens, dstPos, Num_1.tokens.length);
		dstPos += Num_1.tokens.length;
		
		System.arraycopy(Num__2.tokens, 0, tokens, dstPos, Num__2.tokens.length);
		dstPos += Num__2.tokens.length;
		
		System.arraycopy(Num2.tokens, 	0, tokens, dstPos, Num2.tokens.length);
		dstPos += Num2.tokens.length;
	}

	@Override
	public void parse(Context context)
			throws ParseException {
		if( context.checkToken(Num_1.tokens, 0) ){
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
