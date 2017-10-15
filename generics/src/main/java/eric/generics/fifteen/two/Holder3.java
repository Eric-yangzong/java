package eric.generics.fifteen.two;

public class Holder3<T> {
	private T a;

	public Holder3(T a) {
		this.a = a;
	}

	public void setT(T a) {
		this.a = a;
	}

	public T get() {
		return this.a;
	}

	public static void main(String[] args) {
		Holder3<String> a = new Holder3<String>("a");
		System.out.println(a.get());
		
		Holder3<Automobile> a1 = new Holder3<Automobile>(new Automobile());
		a1.get();
	}
}
