package bridge;

import org.junit.Before;
import org.junit.Test;

import bridge.Coffee.CoffeeEnum;
import bridge.CoffeeSize.CoffeeSizeEnum;
import bridge.Foam.FoamEnum;
import bridge.Milk.MilkEnum;

public class test_bridge {

	private CoffeeMaker maker;

	private CoffeeSize coffee_size;
	private Coffee coffee;
	private Milk milk;
	private Foam foam;
	
	@Before
	public void setup(){	//default Venti Soy Extra
		coffee_size = 	new CoffeeSize(CoffeeSize.CoffeeSizeEnum.Venti);
		coffee		=	new	Coffee(Coffee.CoffeeEnum.Espresso);
		milk		=	new	Milk(Milk.MilkEnum.Soy);
		foam		=	new	Foam(Foam.FoamEnum.Extra);
		
		maker = new CoffeeMaker(coffee_size, coffee, milk, foam);
	}
	
	@Test
	public void test_coffee_maker_default(){//4_1_2
		System.out.println("[Espresso] Venti size & Soy milk & Extra foam");
		maker.make_coffee();
	}
	
	@Test
	public void test_coffee_make_1_1_1(){
		System.out.println("[America] Short size & Low_fat milk & Light foam");
		maker = new CoffeeMaker(
				new CoffeeSize(CoffeeSizeEnum.Short),
				new Coffee(CoffeeEnum.American),
				new Milk(MilkEnum.Low_fat),
				new Foam(FoamEnum.Light));
		maker.make_coffee();
	}
	
	@Test
	public void test_coffee_make_2_0_0(){
		System.out.println("[Cappuccion] Tall size & No milk & No foam");
		maker = new CoffeeMaker(
				new CoffeeSize(CoffeeSizeEnum.Tall),
				new Coffee(CoffeeEnum.Cappuccion),
				new Milk(MilkEnum.Nomilk),
				new Foam(FoamEnum.Nofoam));
		maker.make_coffee();
	}
}
