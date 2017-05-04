package proxy_composite_decorate;

public class PrinterDecorate implements Printable{

	private Printable printer;
	public PrinterDecorate(Printable p){
		this.printer = p;
	}

	@Override
	public void print(String string){
		printer.print("[Decorate]" + string +"[Decorate]");
	}

	@Override
	public void setPrinterName(String name) {
		printer.setPrinterName(name);
	}

	@Override
	public String getPrinterName() {
		return printer.getPrinterName();
	}
	
}
