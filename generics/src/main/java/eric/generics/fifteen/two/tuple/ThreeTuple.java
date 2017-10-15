package eric.generics.fifteen.two.tuple;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

	private C c;

	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		this.c = c;
	}

	@Override
	public String toString() {
		return super.toString() + " C:" + this.c.toString();
	}

	public static void main(String[] args) {
		ThreeTuple<String, String, String> t = new ThreeTuple<String, String, String>("first", "second", "third");
		System.out.println(t.toString());
	}

}
