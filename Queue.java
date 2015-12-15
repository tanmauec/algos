/* package whatever; // don't place package name! */

import java.util.ArrayList;

//Iterator is a generic class, to get an iterator for list contaning objects 
//of specific type, you just need to know object size.
import java.util.Iterator;
import java.lang.*;
import java.io.*;

//Creating a simple queue in java
//using ArrayList, easier to manage then mixed array

//Create a generic queue to hold all types of objects
class Queue<E>
{
	ArrayList<E> a = new ArrayList<E>();
	
	E removeFromFront(){
		System.out.println("removing head");
		return a.remove(0);
	}
	
	void addToRear(E e){
		a.add(e);//automatically appends to queue, ie. to last position
		System.out.println("adding tail");
	}
	
	boolean isEmpty()
	{
		return a.isEmpty();
	}
	
	void printQueue() {
		Iterator it = a.iterator();
		while(it.hasNext()) {
			System.out.print(it.next().toString() + " ");
		}
	}
	
	//main program to test implement
	public static void main(String args[]) {
		Queue<Integer> q = new Queue<Integer>();
		q.addToRear(1);
		q.addToRear(2);
		q.addToRear(3);
		
		q.printQueue();
		
		q.removeFromFront();
		
		q.printQueue();
	}
}
