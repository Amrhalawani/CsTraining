package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {

        size = 0;
        head = new LLNode<>(null); //sentinel node {dummy node}
        tail = new LLNode<>(null); //sentinel node
        head.next = tail;
        tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
     * @return 
	 */
        @Override
	public boolean add(E element ) 
	{
           if(element!=null){
              LLNode<E> newNode= new LLNode<>(element);
                newNode.prev = tail.prev;
                tail.prev.next = newNode;
                tail.prev = newNode;
                newNode.next = tail;
                size++;  
           return true;
           }  else {
           throw new NullPointerException("Invalid element input ");
           }
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
        @Override
	public E get(int index) {
                if( size > 0 && index >=0 && index <= size-1){
                   LLNode<E> res = head;
                for (int i = 0; i <= index; i++) {
                res = res.next;
                }
                return res.data; 
                }else{
                throw new IndexOutOfBoundsException();
                }
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index where the element should be added
	 * @param element The element to add
	 */
        @Override
	public void add(int index, E element ) 
	{
            if (element == null) {
			throw new NullPointerException("Invalid element input = null");
		}
            
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
                
          
           LLNode<E> res = head;  
            for (int i = 0; i <= index; i++) {
              res = res.next;
            }
            
            LLNode<E> newNode= new LLNode<>(element);
                newNode.prev = res.prev;
                res.prev.next = newNode;
                res.prev = newNode;
                newNode.next = res;
                size++;  
                 }
                
        


	/** Return the size of the list */
        @Override
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
        @Override
	public E remove(int index) 
	{
             if( size > 0 && index >=0 && index <= size-1){
           LLNode<E> res = head;
           
            for (int i = 0; i <= index; i++) {
              res = res.next;
            }
            res.prev.next =res.next;
            res.next.prev =res.prev;
            size--;
		return res.data;}
             else
             {
                  throw new IndexOutOfBoundsException();
                 
             }
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
        @Override
	public E set(int index, E element) 
               
	{
            if (element == null) {
			throw new NullPointerException("Invalid element input = null");
		}
            
             if( size > 0 && index >=0 && index <= size-1){
           LLNode<E> res = head;  
            for (int i = 0; i <= index; i++) {
              res = res.next;
            }
            E replacedElement = res.data;
         res.data = element;
		return replacedElement;}
             else
             {
                  throw new IndexOutOfBoundsException();   
             }
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
