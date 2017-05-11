package interpreter;

import java.text.ParseException;

public class EnglishNumberNode extends Node {

	@Override
	public void parse(Context context) throws ParseException {
		Final.getInstance().clear();
		
		Node num3 = new Num3();
		
		num3.parse(context);
		context.skipToken("billion");
		Final.getInstance().add(',');
		
		num3.parse(context);
		context.skipToken("million");
		Final.getInstance().add(',');
		
		num3.parse(context);
		context.skipToken("thousand");
		Final.getInstance().add(',');
		
		num3.parse(context);
		context.skipToken("and");
	}
	
	@Override
	public String toString(){
		return Final.getInstance().toString();
	}

}
