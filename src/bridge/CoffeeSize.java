package bridge;

public class CoffeeSize {
	
	enum CoffeeSizeEnum{
		Short(1),
		Tall(2),
		Grande(3),
		Venti(4);
		
		private int size;
		private CoffeeSizeEnum(int size){
			this.size = size;
		}
		
		public int toInt(){
			return size;
		}
	}
	
	private CoffeeSizeEnum coffee_size;
	public CoffeeSize(CoffeeSizeEnum size){
		this.coffee_size = size;
	}
	
	public int get_size(){
		return coffee_size.toInt();
	}
}
