package interpreter;

import java.text.ParseException;

//num_1 := one|two|three|four|five|six|seven|eight|nine
public class Num_1 extends Node{

	public final static String[] tokens = {
			"one",
			"two",
			"three",
			"four",
			"five",
			"six",
			"seven",
			"eight",
			"nine"
	};
	
	@Override
	public void parse(Context context)
			throws ParseException {
		int index = context.skipToken(tokens);
		
		Final.getInstance().add((char)('0' + index + 1));
	}

}
