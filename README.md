# REACTIVE [![Build Status](https://travis-ci.org/nomensa/jquery.hide-show.svg)](https://travis-ci.org/nomensa/jquery.hide-show.svg?branch=master)

   ```Reactive code can simplify the process of writing async code.```

<p><i>It is hard to explain reactive programming in a nutshell. Well, at least I couldn’t find any. You can say that reactive programming is an <b>Observer template</b> on steroids. Or rather, reactive programming is programming aimed at <b>flows</b>. The main idea is in presenting <b>events</b> and <b>data</b> as flows that can be <b>unified<b>, <b>filtered</b>, <b>transformed</b>, and <b>separated</b>. Sounds quite <b>vague</b> but I hope some of the examples below will help make sense of it.``</i></p>
  
## Understand `Observable`

``The basic building blocks of reactive code are Observables and Subscribers. The Observable class is the <b>source of data</b> and the Subscriber class is <b>the consumer</b>.``
![alt text](https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/1.png)

## We Research about "Observe Design Pattern"



When to use it:
1. When one object changes its state,then all other dependents object must automatically change their state to maintain consistency
2. When subject doesn't know about number of observers it has.
3. When an object should be able to notify other objects without knowing who objects are.

```java
import java.util.ArrayList;
import java.util.List;

  public class Subject {

  private int state;

  public int getState() {
    return state;
  }

 public void setState(int state) {
 import java.util.ArrayList;
  import java.util.List;

  public class Subject {

  private int state;

  public int getState() {
    return state;
  }

 public void setState(int state) {
   this.state = state;
 }
}   
```
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/> We need <b>ArrayList<Observer>()</b>, <b>attach(Observer observer)</b>, <b>notifyAllObservers()</b> and finally <b>notifyAllObservers()</b>
   
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/c.png" width="24px" height="24px"/>  Create variable to contain these observers<br>
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/c.png" width="24px" height="24px"/>  Attach observer from outside of scope of object<br>
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/c.png" width="24px" height="24px"/>  Implement sync when update its object with other observer<br>
```java
import java.util.ArrayList;
import java.util.List;

  public class Subject {

  private List<Observer> observers 
        = new ArrayList<Observer>();
  private int state;

  public int getState() {
    return state;
  }

 public void setState(int state) {
   this.state = state;
   notifyAllObservers();
 }

   public void attach(Observer observer){
     observers.add(observer);       
   }

  public void notifyAllObservers(){
    for (Observer observer : observers) {
     observer.update();
  }
} 
```

<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/> Create interface to communicate between Subject and other Observer
```java
public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}
```

<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/> Create concrete observer classes
```java
public class BinaryObserver extends Observer{

  public BinaryObserver(Subject subject){
     this.subject = subject;
     this.subject.attach(this);
  }

  @Override
  public void update() {
     System.out.println( "Binary String: " 
     + Integer.toBinaryString( subject.getState() ) ); 
  }
}

public class OctalObserver extends Observer{

   public OctalObserver(Subject subject){
     this.subject = subject;
    this.subject.attach(this);
 }

  @Override
  public void update() {
    System.out.println( "Octal String: " 
    + Integer.toOctalString( subject.getState() ) ); 
  }
}

public class HexaObserver extends Observer{

  public HexaObserver(Subject subject){
    this.subject = subject;
    this.subject.attach(this);
 }

  @Override
  public void update() {
     System.out.println( "Hex String: " 
    + Integer.toHexString( subject.getState() ).toUpperCase() ); 
 }
}
```

<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/> Use Subject and concrete observer objects.
```java
public class ObserverPatternDemo {
    public static void main(String[] args) {
       Subject subject = new Subject();

       new HexaObserver(subject);
       new OctalObserver(subject);
       new BinaryObserver(subject);

       System.out.println("First state change: 15");    
       subject.setState(15);
       System.out.println("Second state change: 10");   
       subject.setState(10);
   }
}
```
## We research about "Iterator Design Pattern in Java"
``Java developers have to be familiar with the Iterator interface:``
![alt text](https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/2.png)
```java
import java.util.ArrayList;
import java.util.Iterator;


public class IteratorExample {
	public static void main(String[] args) {
		// iterators
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(6);
		list.add(11);
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			Integer i = it.next();
			System.out.println(""+i);
		}
		Iterator<Integer> it = list.iterator();
		it.next();
		it.next();
		it.remove();
		System.out.println(list);
	}
}
```
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/> Upgrade level 1
```java
package upgrade;

@SuppressWarnings("all")
public class Shape {
	private int id;
	private String name;
	
	Shape(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

package upgrade;

@SuppressWarnings("all")
public class Main {
	public static void main(String[] args) {
		Shape rectangle = new Shape(1, "Rectangle");
		Shape square = new Shape(2, "Square");
		Shape circle = new Shape(3, "Circle");
		Shape triangle = new Shape(4, "Triangle");
		
		ShapeStorage shapeStorage = new ShapeStorage();
		shapeStorage.add(rectangle);
		shapeStorage.add(square);
		shapeStorage.add(circle);
		shapeStorage.add(triangle);
		
		// Create an iterator to iterate through this collection
	}
}

package upgrade;

@SuppressWarnings("all")
public class ShapeStorage {

	private Shape[] shapes = new Shape[4];
	private int index = 0;
	
	public void add(Shape shape) {
		shapes[index] = shape;
		index++;
	}

}

```
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/> Create method to get list (<b>Object Collection</b>)
### <b>Create an iterator to iterate through this collection</b>

```java
public Shape[] getShapes() {
	return shapes;
}
	
```
<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/> Embed Iterator into Collection and access element of collection easily.

```java
package upgrade;

import java.util.Iterator;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class ShapeInterator implements Iterator<Shape> {

	private Shape[] shapes;
	private int index = 0;

	public ShapeInterator(Shape[] shapes) {
		this.shapes = shapes;
	}

	public void forEachRemaining(Consumer<? super Shape> arg0) {
		// TODO Auto-generated method stub
	}

	public boolean hasNext() {
		if (index < shapes.length) {
			return true;
		}
		return false;
	}

	public Shape next() {
		if (this.hasNext()) {
			return shapes[index++];
		}
		return null;
	}

	public void remove() {
		for (int i = index - 1; i < shapes.length - 1; i++) {
			shapes[i] = shapes[i+1];
		}
		shapes[shapes.length - 1] = null;
	}

}

package upgrade;

@SuppressWarnings("all")
public class Main {
	public static void main(String[] args) {
		Shape rectangle = new Shape(1, "Rectangle");
		Shape square = new Shape(2, "Square");
		Shape circle = new Shape(3, "Circle");
		Shape triangle = new Shape(4, "Triangle");
		
		ShapeStorage shapeStorage = new ShapeStorage();
		shapeStorage.add(rectangle);
		shapeStorage.add(square);
		shapeStorage.add(circle);
		shapeStorage.add(triangle);
		
		// Create an iterator to iterate through this collection
		ShapeInterator iterator = new ShapeInterator(shapeStorage.getShapes());
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		iterator.next();
		iterator.remove();
	}
}

```

