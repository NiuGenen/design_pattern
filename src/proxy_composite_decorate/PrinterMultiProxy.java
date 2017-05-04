package proxy_composite_decorate;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PrinterMultiProxy implements Printable {
    private String name;
    private List<Printer> real_list;
    public PrinterMultiProxy() {
    }
    public PrinterMultiProxy(String name) {
        this.name = name;
    }
    public synchronized void setPrinterName(String name) {
        if (real_list != null) {
        	real_list = new LinkedList<Printer>();
        	real_list.add( new Printer(name + "_01") );
        	real_list.add( new Printer(name + "_02") );
        	real_list.add( new Printer(name + "_03") );
        }
        this.name = name;
    }
    public String getPrinterName() {
        return name;
    }
    public void print(String string) {
        realize();
        for(Printer p: real_list){
        	p.print(string);
        }
    }
    public void print_choose_one(String string){
    	realize();
    	int i = new Random().nextInt( real_list.size() );
    	real_list.get( i ).print( string );
    }
    private synchronized void realize() {
        if (real_list == null) {
        	real_list = new LinkedList<Printer>();
        	real_list.add( new Printer(name+"_01") );
        	real_list.add( new Printer(name+"_02") );
        	real_list.add( new Printer(name+"_03") );
        }
    }
}