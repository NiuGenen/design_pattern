package interpreter;

import java.text.ParseException;

//num__2 := twenty|thirty|forty|fifty|sixty|seventy|eighty|ninety
public class Num__2 extends Node {

	public final static String[] tokens = {
			"twenty",
			"thirty",
			"forty",
			"fifty",
			"sixty",
			"seventy",
			"eighty",
			"ninety"
	};
	
	@Override
	public void parse(Context context)
			throws ParseException {
		int index = context.skipToken( tokens );
		
		Final.getInstance().add( (char) ('0' + index + 2) );
		//Final.getInstance().add('0');
		
		//Character c = (char) ('0' + index + 2);
		/*switch(index){
		case 0:	c = '2';	break;	//twenty	20
		case 1:	c = '3';	break;	//thirty	30
		case 2:	c = '4';	break;	//forty		40
		case 3:	c = '5';	break;	//fifty		50
		case 4:	c = '6';	break;	//sixty		60
		case 5:	c = '7';	break;	//seventy	70
		case 6:	c = '8';	break;	//eighty	80
		case 7:	c = '9';	break;	//ninety	90
		}*/
	}

}
