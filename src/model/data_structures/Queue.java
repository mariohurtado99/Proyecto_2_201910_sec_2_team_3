package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class Queue <T> implements IQueue<T>
{

	// Nodo anterior 
	Nodo<T> nodoAnterior;

	// Nodo siguiente
	Nodo <T> nodoSiguiente;

	// Primer nodo
	Nodo<T> primero;

	// �ltimo nodo
	Nodo<T> ultimo;

	private int tama�o;



	public Queue() 
	{
		// TODO Auto-generated constructor stub
		tama�o = 0;
		primero = null;
		ultimo = null;
	}

	public Iterator<T> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> {
        private Nodo current = primero;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = (T) current.darElemento();
            current = current.darSiguiente();
            return item;
        }
    } 

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return primero == null;
	}


	public int size() 
	{
		return tama�o;
	}



	public void enqueue(T t)
	{
		if(primero == null)
		{
			primero = new Nodo<T>(t);
			ultimo = primero;

		}
		else
		{
			ultimo.cambiarSiguiente(new Nodo<T>(t)); 
			ultimo = ultimo.darSiguiente();
		}
		tama�o++;
	
	}

	public T darUltimo()
	{
		return ultimo.darElemento();
	}


	public T dequeue()
	{
		Nodo<T> sacada = primero;

		primero = primero.darSiguiente();
		tama�o--;
		return  sacada.darElemento();
	}
}