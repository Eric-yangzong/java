package eric.generics.fifteen.ten;

//:generics/Wildcards.java
//Exploring the meaning of wildcards

public class Wildcards {
	// Raw argument:
	static void rawArgs(Holder holder, Object arg) {
		// holder.set(arg);//Warning
		// Unchecked call to set(T) as a
		// member of the row type Holder
		// holder.set(new Wildcards());//Same warning

		// Can't do this:don't have any 'T':
		// T t = holder.get();

		// OK ,but type information has been lost:
		Object obj = holder.get();
	}

	// Similar to rawArgs(),but errors instead of warnings:
	static void unboundedArg(Holder<?> holder, Object arg) {
		// holder.set(arg);//Error
		// set(capture of ?) in Holder<capture of ?>
		// cannot be applied to (Object)
		// holder.set(new Wildcards());// Same error

		// Can't do this: dot't have any 'T':
		// T t = holder.get();

		// OK, but bype information has been lost:
		Object obj = holder.get();

	}

	static <T> boolean t(T t) {

		T t1 = t;
		return true;
	}

	static <T> T exact1(Holder<T> holder) {
		T t = holder.get();
		return t;
	}

	static <T> T exact2(Holder<T> holder, T arg) {
		holder.set(arg);
		T t = holder.get();
		return t;
	}

	static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
		// holder.set(arg); //Error
		// set(capture of ? extends T) in
		// cannot be applied to (T)
		T t = holder.get();
		return t;
	}

	static <T> void wildSupertype(Holder<? super T> holder, T arg) {
		holder.set(arg);
		// T t = holder.get();//Error
		// InCompatible types:found Object,required T

		// OK,but type information has been lost:
		Object obj = holder.get();
	}

	public static void main(String[] args) {
		Holder raw = new Holder<Long>();
		// Or:
		raw = new Holder();
		Holder<Long> qualified = new Holder<Long>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<Long>();
		Long lng = 1L;

		rawArgs(raw, lng);
		rawArgs(qualified, lng);
		rawArgs(unbounded, lng);
		rawArgs(bounded, lng);
		
		unboundedArg(raw,lng);
		unboundedArg(qualified,lng);
		unboundedArg(unbounded,lng);
		unboundedArg(bounded,lng);
		
		//Object r1 = exact1(raw);//Warnings
		// Unchecked conversion from Holder to Holder<T>
		// unchecked method invocation: exact1(Holder<T>)
		// is applied to (Holder)
		Long r2 = exact1(qualified);
		Object r3 = exact1(unbounded);// Must return Object
		Long r4 = exact1(bounded);
		
		Long r5 = exact2(raw,lng);//Warnings:
		// Unchecked conversion from Holder to Holder<Long>
		// Unchecked method invocation:exact2(Holder<T>,T)
		// is applied to (Holder,Long)
		Long r6 = exact2(qualified,lng);
		//Long r7 = exact2(unbounded,lng);//Errpr:
		//exact2(Holder<T>,T) cannot be applied to 
		//(Holder<capture of ?>,Long)
		//Long r8 = exact2(bounded,lng);//Error
		//exact2(Holder<T>,T) cannot be applied
		// to(Holder<capture of ? extends Long>,Long)
		
		Long r9 = wildSubtype(raw,lng);//Warnings
		
		
		

	}
}
