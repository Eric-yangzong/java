package eric.generics.fifteen.nine;

import java.awt.Color;

interface HasColor {
	java.awt.Color getColor();
}

class Colored<T extends HasColor> {
	T item;

	Colored(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	// The bound allows you to call a method;
	java.awt.Color color() {
		return item.getColor();
	}
}

class Dimension {
	public int x, y, z;
}

// This won't work -- class must be first, then interfaces;
// class ColoredDimension<T extends HasColor & HasColor>{

// Multiple bounds:

class ColoredDimension<T extends Dimension & HasColor> {
	T item;

	ColoredDimension(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	java.awt.Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}

}

interface A {
}

interface Weight {
	int weight();
}

class B implements A {

}

// As with inheritance,you can have only one
// concrete class but multiple interfaces;
class Solid<T extends Dimension & HasColor & Weight & A> {
	T item;

	Solid(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	java.awt.Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}

	int weight() {
		return item.weight();
	}

}

class Bounded extends Dimension implements HasColor, Weight, A {

	public int weight() {
		return 0;
	}

	public Color getColor() {
		return null;
	}

}

public class BasicBounds {
	public static void main(String[] args) {
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getY();
		solid.weight();
	}
}
