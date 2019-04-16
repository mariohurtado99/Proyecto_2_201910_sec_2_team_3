package model.vo;

import model.data_structures.IQueue;
import model.data_structures.Iterador;

/**
 * Agrupa las infracciones mostrando estad�sticas sobre los datos 
 * como el total de infracciones que se presentan en ese conjunto,
 * el porcentaje de infracciones con y sin accidentes con respecto al total,
 * el valor total de las infracciones que se deben pagar y una lista con 
 * las infracciones. 
 */

public class EstadisticaInfracciones 
{
	
	@Override
	public String toString() 
	{
		return "EstadisticaInfracciones [totalInfracciones=" + totalInfracciones + ",\n porcentajeAccidentes="
				+ porcentajeAccidentes + ",\n porcentajeNoAccidentes=" + porcentajeNoAccidentes + ",\n valorTotal="
				+ valorTotal + "]\n\n";
	}

	protected double accidentes;
	
	protected double sinAccidentes;
	/**	
	 * Numero total de infraciones del conjunto
	 */
	
	protected int totalInfracciones;
	
	/**
	 * Porcentaje de las infracciones con accidentes con respecto al total
	 */
	
	protected double porcentajeAccidentes;
	
	/**
	 * Porcentaje de las infracciones sin accidentes con respecto al total
	 */
	
	protected double porcentajeNoAccidentes; 
	
	/**
	 * Valor total de las infracciones que se debe pagar.
	 */
	
	protected double valorTotal;	
	
	/**
	 * Lista con las infracciones que agrupa el conjunto
	 */
	
	protected IQueue<VOMovingViolations> listaInfracciones;
	
	
	/**
	 * Crea un nuevo conjunto con las infracciones
	 * @param listaInfracciones - Lista con las infracciones que cumplen el criterio de agrupamiento
	 */
	
	public EstadisticaInfracciones(IQueue<VOMovingViolations> lista) {
		this.listaInfracciones = lista;
		totalInfracciones = listaInfracciones.size();
		
		porcentajeAccidentes = getPorcentajeAccidentes();   
		porcentajeNoAccidentes = getPorcentajeNoAccidentes();  
		valorTotal =  getValorTotal();        
	
		accidentes = 0;
		sinAccidentes = 0;
		
		
	}
	
	//=========================================================
	//Metodos Getters and Setters
	//=========================================================
	
	/**
	 * Gets the total infracciones.
	 * @return the total infracciones
	 */
	
	public int getTotalInfracciones()
	{
		//Cuenta las infrecciones con accidente y sin accidente.
		for(int i = 0; i <totalInfracciones; i++)
		{
			VOMovingViolations actual = listaInfracciones.dequeue();
			if(actual.getAccidentIndicator().equals("Yes"))
			{
				accidentes++;
			}
			else
				sinAccidentes++;
		}
		return totalInfracciones;
	}	
	
	
	/**
	 * Gets the porcentaje accidentes.	 *
	 * @return the porcentaje accidentes
	 */
	
	public double getPorcentajeAccidentes() 
	{
		return (accidentes/totalInfracciones)*100;
	}	


	/**
	 * Gets the porcentaje no accidentes.
	 *
	 * @return the porcentaje no accidentes
	 */
	public double getPorcentajeNoAccidentes() 
	{
		return (sinAccidentes/totalInfracciones)*100;
	}

	/**
	 * Gets the valor total.
	 *
	 * @return the valor total
	 */
	public double getValorTotal() 
	{
		
	}	

	/**
	 * Gets the lista infracciones.
	 *
	 * @return the lista infracciones
	 */
	public IQueue<VOMovingViolations> getListaInfracciones()
	{
		return listaInfracciones;
	}

	/**
	 * Sets the lista infracciones.
	 *
	 * @param listaInfracciones the new lista infracciones
	 */
	
	public void setListaInfracciones(IQueue<VOMovingViolations> listaInfracciones) 
	{
		this.listaInfracciones = listaInfracciones;
	}
}
