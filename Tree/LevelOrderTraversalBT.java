/* package whatever; // don't place package name! */

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.*;
import java.io.*;

//node class
class Node
{
	String name;
	public Node left, right, neighbour;
	
	Node(String name)
	{
		this.name = name;
		left = right = neighbour = null;
	}
	
	Node addLeft(String name)
	{
		this.left = new Node(name);
		return this.left;
	}
	
	Node addRight(String name)
	{
		this.right = new Node(name);
		return this.right;
	}
}

//generic queue
class Queue<E>
{
	ArrayList<E> a = new ArrayList<E>();
	
	E removeFromFront(){
		//System.out.println("removing head");
		return a.remove(0);
	}
	
	E peekHead() {
		return a.get(0);
	}
	void addToRear(E e){
		a.add(e);//automatically appends to queue, ie. to last position
		//System.out.println("adding tail");
	}
	
	boolean isEmpty()
	{
		return a.isEmpty();
	}
	
	void printQueue(Queue<E> q) {
		Iterator it = q.a.iterator();
		while(it.hasNext()) {
			System.out.print(it.next().toString() + " ");
		}
	}
}

class BinaryTree
{
	public Node root;
	
	public BinaryTree(String name) {
		this.root = new Node(name);
	}
	
	//perform level order traversal on a tree, printing the no. of nodes at 
	//each level along with name of nodes
	void levelOrderTraversal(Queue<Node> q, int n)
	{
		int noOfNodesAtCurrentLevel = n;
		int noOfNodesAtNextLevel = 0;
		
		//we will use a queue structure to implement this
		while(n != 0) {
			Node temp = q.removeFromFront();
			System.out.print(" " + temp.name + ": neighbour, ");
			
			//check if neighbour exists
			//last elem, at a level may not find the stack empty after pop, but we know its neighbor is null
			if (q.isEmpty() || n == 1){
				temp.neighbour = null;
				System.out.print("null ");
			}
			else {
				temp.neighbour = q.peekHead();
				System.out.print(temp.neighbour.name);
			}
			
			//push children to rear of stack
			if (temp.left != null) {
				q.addToRear(temp.left);
				noOfNodesAtNextLevel += 1;
			}
			
			if (temp.right != null) {
				q.addToRear(temp.right);
				noOfNodesAtNextLevel += 1;
			}
			
			n--;
		}
		
		//seperate difft levels by new line
		System.out.println(" ");
		
		//termination condition
		if (noOfNodesAtNextLevel == 0) return;
		
		// call next level
		levelOrderTraversal(q, noOfNodesAtNextLevel);
	}
	
	public static void main(String args[]) {
		
		BinaryTree b = new BinaryTree("A");
		
		Node B = b.root.addLeft("B");
		Node C = b.root.addRight("C");
		
		B.addLeft("D");
		B.addRight("E");
		
		C.addLeft("F");
	
		//Constructed a tree, now perform level order traversal
		Queue<Node> q = new Queue<Node>();
		
		//initialize queue with root element
		q.addToRear(b.root);
		b.levelOrderTraversal(q, 1);
	}
	
}