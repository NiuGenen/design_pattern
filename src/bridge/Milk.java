package bridge;

public class Milk {
	
	enum MilkEnum{
		Nomilk(null),
		Low_fat("los_fat"),
		Soy("soy");
		
		private String milk;
		private MilkEnum(String milk){
			this.milk = milk;
		}
		
		public String toString(){
			return milk;
		}
	}
	
	private MilkEnum milk;
	public Milk(MilkEnum milk){
		this.milk = milk;
	}
	
	public void put_milk(){
		if(milk.toString() != null)
			System.out.println( milk.toString() );
	}

}
