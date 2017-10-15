package eric.generics.fifteen.two.tuple;

public class TwoTuple<A, B> {
	private A a;
	private B b;

	public TwoTuple(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public A getA() {
		return this.a;
	}

	public B getB() {
		return this.b;
	}

	@Override
	public String toString() {
		return "A:" + a.toString() + " B:" + b.toString();
	}

}
