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


   
