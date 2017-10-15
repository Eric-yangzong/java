package eric.generics.fifteen.eight;

class Generic<T> {
}

public class ArrayOfGenericReference {
	//static Generic<Integer>[] gfa;
	
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	@SuppressWarnings("unchecked")
	public static void main(String [] args) {
		//gia[0] = (Generic<Integer>) new Object[SIZE];
	}
}
