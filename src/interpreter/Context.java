package interpreter;

import java.text.ParseException;
import java.util.*;

public class Context {
	public final static boolean isDebug = true;
	
    private StringTokenizer tokenizer;
    private String currentToken;
    private Queue<String> savedToken;
    private Queue<String> offset_tokens;
    public Context(String text) {
    	offset_tokens = new LinkedList<String>();
    	savedToken = new LinkedList<String>();
        tokenizer = new StringTokenizer(text);
        nextToken();
    }
    public String nextToken() {
    	if(!savedToken.isEmpty()){
    		currentToken = savedToken.poll();
    	}
    	else if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }
    public String currentToken() {
        return currentToken;
    }
    public boolean checkToken(String[] Tokens, int offset) throws ParseException{
    	if(offset < 0){
    		throw new ParseException("Warning: offset " + offset + " is not supported in checkToken.", 0);
    	}
    	
    	boolean ret = true;

    	String offset_token = currentToken;
    	if(offset > 0){
	    	while(offset > 0){
	    		if(savedToken.isEmpty()){
	    			if(tokenizer.hasMoreTokens()){
	    				offset_token = tokenizer.nextToken();
	    				offset_tokens.add( offset_token );
	    			}
	    			else{
	    				ret = false;
	    				break;
	    			}
	    		}
	    		else{
	    			offset_token = savedToken.poll();
	    			offset_tokens.add( offset_token );
	    		}
	    		offset--;
	    	}
	    	while(!savedToken.isEmpty())    offset_tokens.add( savedToken.poll() );
	    	while(!offset_tokens.isEmpty()) savedToken.add( offset_tokens.poll() );
    	}
    	
    	if(ret){
    		boolean in = false;
    		for(String token: Tokens){
    			in = token.toLowerCase().equals( offset_token.toLowerCase() );
    			if(in) break;
    		}
    		ret = in;
    	}
    	
    	return ret;
    }
    public boolean checkToken(String Token, int offset) throws ParseException{
    	if(offset < 0){
    		throw new ParseException("Warning: offset " + offset + " is not supported in checkToken.", 0);
    	}
    	
    	boolean ret = true;
    	
    	String offset_token = currentToken;
    	if(offset > 0){
	    	while(offset > 0){
	    		if(savedToken.isEmpty()){
	    			if(tokenizer.hasMoreTokens()){
	    				offset_token = tokenizer.nextToken();
	    				offset_tokens.add( offset_token );
	    			}
	    			else{
	    				ret = false;
	    				break;
	    			}
	    		}
	    		else{
	    			offset_token = savedToken.poll();
	    			offset_tokens.add( offset_token );
	    		}
	    		offset--;
	    	}
	    	while(!savedToken.isEmpty())    offset_tokens.add( savedToken.poll() );
	    	while(!offset_tokens.isEmpty()) savedToken.add( offset_tokens.poll() );
    	}
    	
    	if(ret && !offset_token.toLowerCase().equals( Token.toLowerCase() )){
    		ret = false;
    	}
    	
    	return ret;
    	
    }
    public int skipToken(String[] tokens) throws ParseException{
    	int ret = -1;
    	boolean in = false;
    	for(String token: tokens){
    		in = currentToken.toLowerCase().equals(token.toLowerCase());
    		ret++;
    		if(in) break;
    	}
    	if(!in) throw new ParseException("Warning: " + tokens + " are expected, but " + currentToken + " is found.", 0);
    	nextToken();
    	return ret;
    }
    public void skipToken(String token) throws ParseException {
        if (!token.toLowerCase().equals(currentToken.toLowerCase())) {
            throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.", 0);
        }
        nextToken();
    }
    public int currentNumber() throws ParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e, 0);
        }
        return number;
    }
}
