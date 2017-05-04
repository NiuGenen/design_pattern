package bridge;

public class Coffee {

	enum CoffeeEnum{
		Espresso("espresso"),
		American("american"),
		Cappuccion("cappuccion"),
		Mocha("mocha");
		private String str;
		private CoffeeEnum(String type){
			this.str = type;
		}
		
		public String toString(){
			return str;
		}
	}

	private CoffeeEnum coffee;
	public Coffee(CoffeeEnum coffee){
		this.coffee = coffee;
	}

	public void put_coffee(){
		System.out.println( coffee.toString() );
	}
}
