package proxy_composite_decorate;

public class Printer implements Printable {
    private String name;
    public Printer() {
        heavyJob("Printer(default)");
    }
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer(" + name + ")");
    }
    public void setPrinterName(String name) {
        this.name = name;
    }
    public String getPrinterName() {
        return name;
    }
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("Finish!");
    }
}
