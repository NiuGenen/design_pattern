package interpreter;

public class Final {
	
	private StringBuffer buf = null;
	
	private static Final f = new Final();
	private Final(){
		buf = new StringBuffer();
	}
	public static Final getInstance(){
		return f;
	}
	
	public void add(char c){
		if(buf != null){
			buf.append(c);
		}
	}
	
	public void clear(){
		if(buf != null && buf.length() > 0){
			buf.delete(0, buf.length());
		}
	}
	
	public String toString(){
		return buf.toString();
	}

}
