package model.utils;

import java.util.Comparator;
import model.vo.VOMovingViolations;


public class Sort 
{

	private static Comparator comparadorActual;
	/**
	 * Ordenar datos aplicando el algoritmo MergeSort
	 * @param infraccionesLocalizacion - conjunto de datos a ordenar (inicio) y conjunto de datos ordenados (final)
	 * @param ultimo 
	 * @param mitad 
	 * @param inicio 
	 * @param aux 
	 */
	public static void ordenarMergeSort( ArregloDinamico<VOMovingViolations> infraccionesLocalizacion, VOMovingViolations[] aux, int inicio, int mitad, int ultimo ) 
	{
		for (int k = inicio; k <= ultimo; k++)
		{	
			aux[k] = infraccionesLocalizacion.darElemento(k); 
		}

		int i = inicio;
		int j = mitad+1;

		for (int k = inicio; k <= ultimo; k++)
		{
			if      (i > mitad)            
			{
				infraccionesLocalizacion.eliminar(infraccionesLocalizacion.darElemento(k));
				infraccionesLocalizacion.agregar(aux[j++]);
			}
			else if (j > ultimo)             
			{
				infraccionesLocalizacion.eliminar(infraccionesLocalizacion.darElemento(k));
				infraccionesLocalizacion.agregar(aux[i++]);
			}
			else if (less(aux[j], aux[i])) 
			{
				infraccionesLocalizacion.eliminar(infraccionesLocalizacion.darElemento(k));
				infraccionesLocalizacion.agregar(aux[j++]);
			}
			else                          
			{
				infraccionesLocalizacion.eliminar(infraccionesLocalizacion.darElemento(k));
				infraccionesLocalizacion.agregar(aux[i++]);
			}
		}
	}
	private static void sortM(ArregloDinamico<VOMovingViolations> infraccionesLocalizacion, VOMovingViolations[] aux, int inicio, int fin)
	{
		if (fin<=inicio)
		{
			return;
		}

		int mid=inicio+(fin-inicio)/2;
		sortM(infraccionesLocalizacion, aux, inicio, mid);
		sortM(infraccionesLocalizacion, aux, mid+1, fin);
		ordenarMergeSort(infraccionesLocalizacion, aux, inicio, mid, fin);
	}

	public static void sort(ArregloDinamico<VOMovingViolations> infraccionesLocalizacion, Comparator entrada)
	{
		comparadorActual = entrada;
		VOMovingViolations[] aux = new VOMovingViolations[infraccionesLocalizacion.darTamanio()];
		sortM(infraccionesLocalizacion, aux, 0, infraccionesLocalizacion.darTamanio());
	}



	/**
	 * Comparar 2 objetos usando la comparacion "natural" de su clase
	 *param v primer objeto de comparacion
	 * @param w segundo objeto de comparacion
	 * @return true si v es menor que w usando el metodo compareTo. false en caso contrario.
	 */
	private static boolean less(VOMovingViolations v, VOMovingViolations w)
	{
		return comparadorActual.compare(v, w)<0;
	}

	/**
	 * Intercambiar los datos de las posicion i y j
	 * @param datos contenedor de datos
	 * @param i posicion del 1er elemento a intercambiar
	 * @param j posicion del 2o elemento a intercambiar
	 */
	private static void exchange( VOMovingViolations[] datos, int i, int j)
	{
		VOMovingViolations temp = datos[i]; 
		datos[i] = datos[j]; 
		datos[j] = temp;
	}

	public static void invertirMuestra( VOMovingViolations[ ] datos )
	{

		VOMovingViolations[] nuevos = new VOMovingViolations[ datos.length ];
		int j = datos.length-1;
		for ( int i = 0 ; i < datos.length-1 ; i++ )
		{
			nuevos[i] = datos[j];
			j--;	
		}
		datos = nuevos;

	}


}