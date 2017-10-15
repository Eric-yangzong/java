package eric.generics.fifteen.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * */

public class Genericsvarargs {
	public static <T> List<T> makeList(T ...args){
		List<T> result = new ArrayList<T>();
		for(T item:args)
			result.add(item);
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> ls = makeList("A","B","C");
		System.out.println(ls);
	}
}
