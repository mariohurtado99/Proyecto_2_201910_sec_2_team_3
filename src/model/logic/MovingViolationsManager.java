package model.logic;

import java.io.FileReader; 
import java.time.LocalDate;
import java.time.LocalTime;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IQueue;
import model.data_structures.MaxHeapCP;
import model.data_structures.Sort;
import model.vo.EstadisticaInfracciones;
import model.vo.EstadisticasCargaInfracciones;
import model.vo.InfraccionesFecha;
import model.vo.InfraccionesFechaHora;
import model.vo.InfraccionesFranjaHoraria;
import model.vo.InfraccionesFranjaHorariaViolationCode;
import model.vo.InfraccionesLocalizacion;
import model.vo.InfraccionesViolationCode;
import model.vo.VOMovingViolations;
public class MovingViolationsManager
{
	private enum Meses
	{
		January(0),
		February(0),
		March(0), 
		April(0), 
		May(0),
		June(0),
		July(0),
		August(0), 
		September(0),
		October(0), 
		November(0), 
		December(0);

		private int infracciones;

		private Meses(int cantidad)
		{ 
			this.infracciones = cantidad;
		}

		private void contar()
		{ 
			this.infracciones++; 
		}

		private int darInfracciones()
		{ 
			return infracciones; 
		}
	}
	private ArregloDinamico<VOMovingViolations> datos; 
	
	private EstadisticasCargaInfracciones estadisticasCarga;

	private ArregloDinamico<VOMovingViolations> infraccionesFecha;

	private ArregloDinamico<VOMovingViolations> infraccionesHora;
	
	private MaxHeapCP<InfraccionesViolationCode> ViolationCodes;
	
	private ArregloDinamico<VOMovingViolations> infraccionesLocalizacion;

	private ArregloDinamico<VOMovingViolations> infraccionesCodes;

	private ArregloDinamico<VOMovingViolations> infraccionesAddress;
	
	private MaxHeapCP<InfraccionesLocalizacion> coordenadas;


	/**
	 * Metodo constructor
	 */
	public MovingViolationsManager()
	{
		//TODO inicializar los atributos
		datos=new ArregloDinamico<VOMovingViolations>(670000);
	}
	/**
	 * Cargar las infracciones de un semestre de 2018
	 * @param numeroSemestre numero del semestre a cargar (1 o 2)
	 * @return objeto con el resultado de la carga de las infracciones
	 */
	public EstadisticasCargaInfracciones loadMovingViolations(int numeroSemestre) 

	{
		CSVReader reader;

		String[] nextLine;

		int[] infraccionesxMes=new int[6];
		double[] miniMax=new double[4];
		double miny = Double.MAX_VALUE;
		double minx = Double.MAX_VALUE;
		double maxx = 0.0;
		double maxy = 0.0;

		try
		{
			double coordenadax=0.0; 
			double coordenaday=0.0;
			for (Meses mes : Meses.values())
			{
				if(mes.ordinal()>=(numeroSemestre-1)*6 && mes.ordinal()<numeroSemestre*6)
				{
					reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_" + mes + "_2018.csv"));
					nextLine=reader.readNext();  
					if(mes.ordinal() >8 )
					{

						while ((nextLine = reader.readNext()) != null) 
						{			
							coordenadax = Double.parseDouble(nextLine[5]);

							coordenaday = Double.parseDouble(nextLine[6]);

							if(coordenadax>maxx)
							{
								maxx=coordenadax;
							}
							if(coordenadax<minx)
							{
								minx=coordenadax;
							}
							if(coordenaday>maxy)
							{
								maxy=coordenaday;
							}
							if(coordenaday<miny)
							{
								miny=coordenaday;
							}
							datos.agregar(new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2],nextLine[14], Double.parseDouble(nextLine[9]),nextLine[12],nextLine[16],nextLine[3],nextLine[4],coordenadax,coordenaday,(nextLine[8]!="" && nextLine[8]!=null && !nextLine[8].isEmpty())?Double.parseDouble(nextLine[8]):0 ,(nextLine[10]!="" && nextLine[10]!=null && !nextLine[10].isEmpty())?Double.parseDouble(nextLine[10]):0  ,(nextLine[11]!="" && nextLine[11]!=null && !nextLine[11].isEmpty())?Double.parseDouble(nextLine[11]):0, nextLine[15]));
							mes.contar();
						}
						reader.close();
					}
					else
					{	
						while ((nextLine = reader.readNext()) != null) 
						{				
							coordenadax = Double.parseDouble(nextLine[5]);

							coordenaday = Double.parseDouble(nextLine[6]);

							if(coordenadax>maxx)
							{
								maxx=coordenadax;
							}
							if(coordenadax<minx)
							{
								minx=coordenadax;
							}
							if(coordenaday>maxy)
							{
								maxy=coordenaday;
							}
							if(coordenaday<miny)
							{
								miny=coordenaday;
							}
							datos.agregar(new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2],nextLine[13], Double.parseDouble(nextLine[9]),nextLine[12],nextLine[15],nextLine[3],nextLine[4],coordenadax,coordenaday,(nextLine[8]!="" && nextLine[8]!=null && !nextLine[8].isEmpty())?Double.parseDouble(nextLine[8]):0 ,(nextLine[10]!="" && nextLine[10]!=null && !nextLine[10].isEmpty())?Double.parseDouble(nextLine[10]):0  ,(nextLine[11]!=null && nextLine[11]!="" && !nextLine[11].isEmpty())?Double.parseDouble(nextLine[11]):0, nextLine[14] ));
							mes.contar();
						}
						reader.close();
					}
					infraccionesxMes[mes.ordinal()%6]=mes.darInfracciones();
				}

			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace(); 
		}

		miniMax[0]=minx;
		miniMax[1]=miny;
		miniMax[2]=maxx;
		miniMax[3]=maxy;
		estadisticasCarga = new EstadisticasCargaInfracciones(datos.darTamanio(),infraccionesxMes,miniMax);
		infraccionesLocalizacion=datos;
		Sort.sort(infraccionesLocalizacion, new VOMovingViolations.comparatorCoord());
		infraccionesFecha=datos;
		Sort.sort(infraccionesFecha, new VOMovingViolations.comparatorLocalDateTime());
		infraccionesHora=datos;
		Sort.sort(infraccionesHora, new VOMovingViolations.comparatorHour());
		infraccionesAddress=datos;
		Sort.sort(infraccionesAddress, new VOMovingViolations.comparatorAddressID());

		return estadisticasCarga;
	}

	/**
	 * Requerimiento 1A: Obtener el ranking de las N franjas horarias
	 * que tengan más infracciones. 
	 * @param int N: Número de franjas horarias que tienen más infracciones
	 * @return Cola con objetos InfraccionesFranjaHoraria
	 */
	public IQueue<InfraccionesFranjaHoraria> rankingNFranjas(int N)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 2A: Consultar  las  infracciones  por
	 * Localización  Geográfica  (Xcoord, Ycoord) en Tabla Hash.
	 * @param  double xCoord : Coordenada X de la localizacion de la infracción
	 *			double yCoord : Coordenada Y de la localizacion de la infracción
	 * @return Objeto InfraccionesLocalizacion
	 */
	public InfraccionesLocalizacion consultarPorLocalizacionHash(double xCoord, double yCoord)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 3A: Buscar las infracciones por rango de fechas
	 * @param  LocalDate fechaInicial: Fecha inicial del rango de búsqueda
	 * 		LocalDate fechaFinal: Fecha final del rango de búsqueda
	 * @return Cola con objetos InfraccionesFecha
	 */
	public IQueue<InfraccionesFecha> consultarInfraccionesPorRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 1B: Obtener  el  ranking  de  las  N  tipos  de  infracción
	 * (ViolationCode)  que  tengan  más infracciones.
	 * @param  int N: Numero de los tipos de ViolationCode con más infracciones.
	 * @return Cola con objetos InfraccionesViolationCode con top N infracciones
	 */
	public IQueue<InfraccionesViolationCode> rankingNViolationCodes(int N)
	{
		// TODO completar
		return null;		
	}


	/**
	 * Requerimiento 2B: Consultar las  infracciones  por  
	 * Localización  Geográfica  (Xcoord, Ycoord) en Arbol.
	 * @param  double xCoord : Coordenada X de la localizacion de la infracción
	 *			double yCoord : Coordenada Y de la localizacion de la infracción
	 * @return Objeto InfraccionesLocalizacion
	 */
	public InfraccionesLocalizacion consultarPorLocalizacionArbol(double xCoord, double yCoord)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 3B: Buscar las franjas de fecha-hora donde se tiene un valor acumulado
	 * de infracciones en un rango dado [US$ valor inicial, US$ valor final]. 
	 * @param  double valorInicial: Valor mínimo acumulado de las infracciones
	 * 		double valorFinal: Valor máximo acumulado de las infracciones.
	 * @return Cola con objetos InfraccionesFechaHora
	 */
	public IQueue<InfraccionesFechaHora> consultarFranjasAcumuladoEnRango(double valorInicial, double valorFinal)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 1C: Obtener  la información de  una  addressId dada
	 * @param  int addressID: Localización de la consulta.
	 * @return Objeto InfraccionesLocalizacion
	 */
	public InfraccionesLocalizacion consultarPorAddressId(int addressID)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 2C: Obtener  las infracciones  en  un  rango de
	 * horas  [HH:MM:SS  inicial,HH:MM:SS  final]
	 * @param  LocalTime horaInicial: Hora  inicial del rango de búsqueda
	 * 		LocalTime horaFinal: Hora final del rango de búsqueda
	 * @return Objeto InfraccionesFranjaHorariaViolationCode
	 */
	public InfraccionesFranjaHorariaViolationCode consultarPorRangoHoras(LocalTime horaInicial, LocalTime horaFinal)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 3C: Obtener  el  ranking  de  las  N localizaciones geográficas
	 * (Xcoord,  Ycoord)  con  la mayor  cantidad  de  infracciones.
	 * @param  int N: Numero de las localizaciones con mayor número de infracciones
	 * @return Cola de objetos InfraccionesLocalizacion
	 */
	public IQueue<InfraccionesLocalizacion> rankingNLocalizaciones(int N)
	{
		// TODO completar
		return null;		
	}

	/**
	 * Requerimiento 4C: Obtener la  información  de  los códigos (ViolationCode) ordenados por su numero de infracciones.
	 * @return Contenedora de objetos InfraccionesViolationCode.
	  // TODO Definir la estructura Contenedora
	 */
	public Contenedora<InfraccionesViolationCode> ordenarCodigosPorNumeroInfracciones()
	{
		// TODO completar
		// TODO Definir la Estructura Contenedora
		return null;		
	}


}
