package memento;

import java.util.*;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<String>();
    private Random random = new Random();
    private static String[] fruitsname = {
        "apple", "orange", "banana", "pear",
    };
    public Gamer(int money) {
        this.money = money;
        this.memento = this.createMemento();
    }
    public int getMoney() {
        return money;
    }
    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("dice = 1 money + 100");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("dice = 2 money /= 2");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("dice = 6 fruit: " + f );
            fruits.add(f);
        } else {
            System.out.println("dice 2,3,4,5 useless");
        }
    }
    /* ---------------------------- */
    private Memento memento;
    public boolean should_store(){
    	if( this.getMoney() > memento.getMoney() ) return true;
    	return false;
    }
    public boolean should_resotre(){
    	if( this.getMoney() < memento.getMoney() / 2 ) return true;
    	return false;
    }
    public void store_to_memento(){
    	this.memento = this.createMemento();
    }
    public void restore_from_memento(){
    	this.restoreMemento(this.memento);
    }
    /* ---------------------------- */
    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String)it.next();
            if (f.startsWith("mem")) {
                m.addFruit(f);
            }
        }
        return m;
    }
    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "mem_";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}

