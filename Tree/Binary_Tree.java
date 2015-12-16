/* package whatever; // don't place package name! */

import java.util.ArrayList;
import java.lang.*;
import java.io.*;

//Creating a binary tree in java

class Node
{
	String name;
	public Node left, right;
	
	Node(String name)
	{
		this.name = name;
		left = right = null;
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
	
	//main program
	public static void main(String args[]) 
	{
		Node A = new Node("A");
		Node B = A.addLeft("B");
		Node C = A.addRight("C");
		
		Node D = A.addLeft("D");
		Node E = A.addRight("E");
		
		Node F = C.addLeft("F");
	
	}
}