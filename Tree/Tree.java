/* package whatever; // don't place package name! */

import java.util.ArrayList;
import java.lang.*;
import java.io.*;

//Creating a using a tree in java

class Node
{
	String name;
	public ArrayList<Node> children;
	
	Node(String name)
	{
		this.name = name;
		children = new ArrayList<Node>();
	}
	
	void addChild(String name)
	{
		children.add(new Node(name));
	}
	
	public static void main(String args[]) 
	{
		Node root = new Node("A");
		root.addChild("B");
		root.addChild("C");
		
	}
}