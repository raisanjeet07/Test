package com.san.ques;

public class SortedLinkedListToB_BST {

}


class TNode{
    int data;
    TNode left;
    TNode right;
    public TNode(int data){
	this.data = data;
    }
}

// Basic Linked List
class LinkedList{
    private Node head;
    private Node tail;
    int size;

    public Integer getNext(){
	if(head != null){
	    int tmp = head.data;
	    head = head.next;
	    size--;
	    return tmp;
	}
	return null;
    }
    
    public boolean hasNext(){
	return head != null;
    }
    
    public boolean add(int data){
	if(head == null){
	    head = new Node(data);
	    tail = head;
	}else{
	    tail.next = new Node(data);
	    tail = tail.next;
	}
	
	return false;
    }
    
    private class Node{
	int data;
	Node next;
	
	public Node(int data){
	    this.data = data;
	}
    }
}