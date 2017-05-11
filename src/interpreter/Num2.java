package interpreter;

import java.text.ParseException;

//num2 := ten|eleven|twelve|thirteen|fourteen|fifteen|sixteen|seventeen|eighteen|nineteen | num_2
public class Num2 extends Node{
	
	public final static String[] tokens = {
			"ten",
			"eleven",
			"twelve",
			"thirteen",
			"fourteen",
			"fifteen",
			"sixteen",
			"seventeen",
			"eighteen",
			"nineteen"
	};

	@Override
	public void parse(Context context)
			throws ParseException {
		if(context.checkToken(tokens, 0)){
			int index = context.skipToken(tokens);
			
			Final.getInstance().add('1');
			Final.getInstance().add((char)('0' + index));
		}
		else{
			Node num_2 = new Num_2();
			num_2.parse( context );
		}
	}

}
