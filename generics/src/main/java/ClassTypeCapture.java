
class Building {
	String aaa = "bbb";
	
	public <T> boolean getB(T t) {
		try {
			System.out.println(t.getClass());
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}
}

class House extends Building {
}

public class ClassTypeCapture<T> {
	Class<T> kind;

	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}

	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}

	public static void main(String[] args) {
		Building b = new Building();
		System.out.println(b.getB("a"));
		System.out.println(b.getB(b));
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		System.out.println(ctt1.f(new String()));
	}
}
