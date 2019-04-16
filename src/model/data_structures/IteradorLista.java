package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorLista<T> implements Iterator<T>
{
	private Nodo<T> proximo; 

	private Nodo<T> ant_prox; 

	public IteradorLista(Nodo<T> primero)
	{
		proximo = primero; 
	}

	public boolean hasNext() 
	{
		// TODO Auto-generated method stub
		return proximo != null; 
	}

	public T next() 
	{
		// TODO Auto-generated method stub
		T retornar = proximo.darElemento();
		
		ant_prox = proximo;
		
		proximo = proximo.darSiguiente(); 
		
		return retornar; 
	}
	
}