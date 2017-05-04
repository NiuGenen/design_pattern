package memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        //Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("gamer:" + gamer);

            gamer.bet();

            System.out.println("money:" + gamer.getMoney());

            //if(this.getMoney() > memento.getMoney())
            if ( gamer.should_store() ) {
                System.out.println("create memento");
                //memento = gamer.createMemento();
                gamer.store_to_memento();
            //} else if (gamer.getMoney() < memento.getMoney() / 2) {
            } else if ( gamer.should_resotre() ) {
                System.out.println("restore memento");
                //gamer.restoreMemento(memento);
                gamer.restore_from_memento();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("");
        }
    }
}