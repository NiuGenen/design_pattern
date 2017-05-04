package proxy_composite_decorate;

import org.junit.*;

public class test_printer {
	
	private PrinterProxy printer;
	private PrinterMultiProxy printer_multi;
	private PrinterDecorate printer_decorate;
	
	@Before
	public void setup(){
		printer = new PrinterProxy("printer1");
		printer_multi = new PrinterMultiProxy("printer2");
		printer_decorate = new PrinterDecorate( printer );
	}
	
	@Test
	public void test_printer_proxy(){
		System.out.println("------test printer proxy");
		printer.setPrinterName("printer_dev_01");
		printer.print("content");
		System.out.println();
	}
	
	@Test
	public void test_multi_printer_proxy(){
		System.out.println("------test multi printer proxy");
		printer_multi.setPrinterName("printer_dev");
		printer_multi.print("content_by_three");;
		printer_multi.print_choose_one("content_by_one");
		System.out.println();
	}
	
	@Test
	public void test_printer_decorate(){
		System.out.println("------test printer decorate");
		printer_decorate.print("content");
		System.out.println();
	}

}
