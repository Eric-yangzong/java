package eric.generics.fifteen.seven;

public class SimpleHolder<T> {
	private T obj;

	public void set(T obj) {
		this.obj = obj;
	}

	public Object get() {
		
		return obj;
	}

	public static void main(String[] args) {
		SimpleHolder holder = new SimpleHolder();
		holder.set("Item");
		String s = (String) holder.get();

		if ("Item" instanceof String) {
			// System.out.println(true);
			int i = 0;
			System.out.println("Item".getClass().getName());
			System.out.println(String.class.getName());

		}
	}
}
