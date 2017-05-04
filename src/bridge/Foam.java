package bridge;

public class Foam {

	enum FoamEnum{
		Nofoam(0),
		Light(1),
		Extra(2);
		
		private int size;
		private FoamEnum(int size){
			this.size = size;
		}
		
		public int toInt(){
			return size;
		}
	}
	
	private FoamEnum foam;
	public Foam(FoamEnum foam){
		this.foam = foam;
	}
	
	public void put_foam(){
		for(int i = 0; i < foam.toInt(); ++i)
			System.out.println("foam");
	}
}
