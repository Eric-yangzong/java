package eric.generics.fifteen.three;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

	private static Random rand = new Random(47);
	private int size = 0;

	public CoffeeGenerator(int sz) {
		size = sz;
	};

	public Coffee next() {
		@SuppressWarnings("rawtypes")
		Class[] types = { Americano.class, Breve.class, Cappuccino.class, Latte.class, Mocha.class };

		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

	}
	
	private <T> void GenericTest(T...args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i].getClass());
		}
	}

	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator(5);
		gen.GenericTest("1","2",1L);
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}

		for (Coffee c : new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	}

}
