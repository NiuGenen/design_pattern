package bridge;

public class CoffeeMaker {

	private CoffeeSize 	size;
	private Coffee		coffee;
	private Milk		milk;
	private Foam		foam;
	
	public void config(CoffeeSize size,
			Coffee coffee,
			Milk milk,
			Foam foam){
		this.size = size;
		this.coffee = coffee;
		this.milk = milk;
		this.foam = foam;
	}
	
	public CoffeeMaker(CoffeeSize size,
			Coffee coffee,
			Milk milk,
			Foam foam){
		this.size = size;
		this.coffee = coffee;
		this.milk = milk;
		this.foam = foam;
	}
	
	public void make_coffee(){
		//coffee
		for(int i = 0; i < size.get_size(); ++i){
			coffee.put_coffee();
		}
		//milk
		milk.put_milk();
		//foam
		foam.put_foam();
	}
	
}
