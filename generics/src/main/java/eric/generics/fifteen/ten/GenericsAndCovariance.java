package eric.generics.fifteen.ten;

import java.util.ArrayList;
import java.util.List;

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class GenericsAndCovariance {
	public static void main(String[] args) {
		//Wildcards allow covariance;
		List<? extends Fruit> flist = new ArrayList<Apple>();
		//Complile Error:can't add any type of objects;
		//flist.add(new Apple());
		//flist.add(new Fruit());
		//flist.add(new Object());
		flist.add(null);
		Fruit f = flist.get(0);
		
	}
}
