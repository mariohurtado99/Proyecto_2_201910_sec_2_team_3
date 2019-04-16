package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.opencsv.CSVReader;

import model.data_structures.IQueue;
import model.data_structures.Queue;
import model.vo.EstadisticaInfracciones;
import model.vo.EstadisticasCargaInfracciones;
import model.vo.InfraccionesFecha;
import model.vo.InfraccionesFechaHora;
import model.vo.InfraccionesFranjaHoraria;
import model.vo.InfraccionesFranjaHorariaViolationCode;
import model.vo.InfraccionesLocalizacion;
import model.vo.InfraccionesViolationCode;
import model.vo.VOMovingViolations;

public class MovingViolationsManager {

	//TODO Definir atributos necesarios
	private IQueue<VOMovingViolations> listaViolaciones;

	/**
	 * Metodo constructor
	 */
	public MovingViolationsManager()
	{
		listaViolaciones =  new Queue<VOMovingViolations>();
	}

	/**
	 * Cargar las infracciones de un semestre de 2018
	 * @param numeroSemestre numero del semestre a cargar (1 o 2)
	 * @return objeto con el resultado de la carga de las infracciones
	 */
	public EstadisticasCargaInfracciones loadMovingViolations(int numeroSemestre) { 
		if(numeroSemestre == 1) {
			try {
				listaViolaciones= (IQueue<VOMovingViolations>) new Queue<VOMovingViolations>();
				CSVReader reader = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_January_2018.csv"));
				String [] nextLine;
				int contador1 =0;
				int contador2=0;
				int contador3=0;
				int contador4=0;
		        int contador5=0;
				int contador6=0;
				
				int contadorMes1=0;
				int contadorMes2=0;
				int contadorMes3=0;
				int contadorMes4=0;
				int contadorMes5=0;
				int contadorMes6=0;
				
				
				try {
					reader.readNext();
					while ((nextLine = reader.readNext()) != null&&contador1<10000) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando1");
						contador1++;
					}
					contadorMes1 = listaViolaciones.size();
					CSVReader reader2 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_February_2018.csv"));
					String [] nextLine2;


					reader2.readNext();
					while ((nextLine2 = reader2.readNext()) != null&&contador2 < 10000) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando2" );
						contador2++;
					}
					contadorMes2=listaViolaciones.size()-contadorMes1;
					CSVReader reader3 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_March_2018.csv"));
					String [] nextLine3;

					reader3.readNext();
					while ((nextLine3 = reader3.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando3" );
						contador3++;
					}
					contadorMes3=listaViolaciones.size()-contadorMes1-contadorMes2;
					CSVReader reader4 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_April_2018.csv"));
					String [] nextLine4;

					reader4.readNext();
					while ((nextLine4 = reader4.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando4" );
						contador4++;
					}
					contadorMes4=listaViolaciones.size()-contadorMes1-contadorMes2-contadorMes3;
					CSVReader reader5 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_May_2018.csv"));
					String [] nextLine5;

					reader5.readNext();
					while ((nextLine3 = reader3.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando5" );
						contador5++;
					}
					contadorMes5=listaViolaciones.size()-contadorMes1-contadorMes2-contadorMes3-contadorMes4;
					CSVReader reader6 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_June_2018.csv"));
					String [] nextLine6;

					reader6.readNext();
					while ((nextLine6 = reader6.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando6" );
						contador6++;
					}
					contadorMes6=listaViolaciones.size()-contadorMes1-contadorMes2-contadorMes3-contadorMes4-contadorMes5;
					int [] params = new int[6];
					params[0]= contadorMes1;
					params[1]= contadorMes2;
					params[2]= contadorMes3;
					params[3]= contadorMes4;
					params[4]= contadorMes5;
					params[5]= contadorMes6;
					
					double [] params2 = new double[4];
					params2[0]= 0;
					params2[1]= 0;
					params2[2]= 0;
					params2[3]=0;
					
					return new EstadisticasCargaInfracciones(listaViolaciones.size(), 6,params , params2);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Terminado"+System.currentTimeMillis());
				System.out.println("Se han cargado (infracciones): Enero: "+ contador1+" ; Febrero: "+contador2+" ; Marzo: "+contador3+" ; Abril: "+contador4+" ; Mayo: "+contador5+" ; Junio: "+contador6+". \nY en total este cuatrimestre: "+(contador1+contador2+contador3+contador4+contador5+contador6)+".") ;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(numeroSemestre == 2) {
			try {
				listaViolaciones= (IQueue<VOMovingViolations>) new Queue<VOMovingViolations>();
				CSVReader reader = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_July_2018.csv"));
				int contadorMes1=0;
				int contadorMes2=0;
				int contadorMes3=0;
				int contadorMes4=0;
				int contadorMes5=0;
				int contadorMes6=0;
				
				
				String [] nextLine;
				int contador7 =0;
				int contador8=0;
				int contador9=0;
				int contador10=0;
				int contador11=0;
				int contador12=0;
				try {
					reader.readNext();
					while ((nextLine = reader.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando7");
						contador7++;
						
					}
					contadorMes1 = listaViolaciones.size();
					CSVReader reader2 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_August_2018.csv"));
					String [] nextLine2;

					reader2.readNext();
					while ((nextLine2 = reader2.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando8");
						contador8++;
					}
					contadorMes2=listaViolaciones.size()-contadorMes1;
					CSVReader reader3 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_September_2018.csv"));
					String [] nextLine3;

					reader3.readNext();
					while ((nextLine3 = reader3.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando9");
						contador9++;
					}
					contadorMes3=listaViolaciones.size()-contadorMes1-contadorMes2;
					CSVReader reader4 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_October_2018.csv"));
					String [] nextLine4;

					reader4.readNext();
					while ((nextLine4 = reader4.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando10");
						contador10++;
					}
					contadorMes4=listaViolaciones.size()-contadorMes1-contadorMes2-contadorMes3;
					
					CSVReader reader5 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_November_2018.csv"));
					String [] nextLine5;

					reader5.readNext();
					while ((nextLine4 = reader5.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando11");
						contador11++;
					}
					contadorMes5=listaViolaciones.size()-contadorMes1-contadorMes2-contadorMes3-contadorMes4;
					
					CSVReader reader6 = new CSVReader (new FileReader ("./data/Moving_Violations_Issued_in_December_2018.csv"));
					String [] nextLine6;

					reader6.readNext();
					while ((nextLine6 = reader6.readNext()) != null) {


						VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3].equals("")?0:Integer.parseInt(nextLine[3]),nextLine[4].equals("")?0:Integer.parseInt(nextLine[4]),nextLine[5].equals("")?0:Double.parseDouble(nextLine[5]),nextLine[6].equals("")?0:Double.parseDouble(nextLine[6])
								,nextLine[7],nextLine[8],nextLine[9].equals("")?0:Double.parseDouble(nextLine[9]),nextLine[10],nextLine[11],nextLine[12],nextLine[13]
										,nextLine[14],nextLine[15],nextLine[16]);
						listaViolaciones.enqueue(mV);
						System.out.println("mapeando12");
						contador12++;
					}
					contadorMes6=listaViolaciones.size()-contadorMes1-contadorMes2-contadorMes3-contadorMes4-contadorMes5;
					System.out.println("Terminado"+System.currentTimeMillis());
					System.out.println("Se han cargado (infracciones): Julio: "+ contador7+" ; Agosto: "+contador8+" ; Septiembre: "+contador9+" ; Octubre: "+contador10+" ;  Noviembre: "+contador11+" ; Diciembre: "+contador12+". \nY en total este cuatrimestre: "+(contador7+contador8+contador9+contador10+contador11+contador12)+".") ;
					int [] params = new int[6];
					params[0]= contadorMes1;
					params[1]= contadorMes2;
					params[2]= contadorMes3;
					params[3]= contadorMes4;
					params[4]= contadorMes5;
					params[5]= contadorMes6;
					
					double [] params2 = new double[4];
					params2[0]= 0;
					params2[1]= 0;
					params2[2]= 0;
					params2[3]=0;
					
					return new EstadisticasCargaInfracciones(listaViolaciones.size(), 6,params , params2);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
		
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
		IQueue infracciones = (IQueue) new Queue<InfraccionesViolationCode>();
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
		double xcoor = 0;
		double ycoor = 0;
		String locat = "";
		int address = 0;
		int street = 0;
		IQueue lista = (IQueue) new Queue<VOMovingViolations>();
		if (listaViolaciones.iterator().hasNext() == true) {
			if ((listaViolaciones.iterator().next().getXcoord() == xCoord) && (listaViolaciones.iterator().next().getYcoord() == yCoord)) {
				xcoor = listaViolaciones.iterator().next().getXcoord();
				ycoor = listaViolaciones.iterator().next().getYcoord();
				locat = listaViolaciones.iterator().next().getLocation();
				address = listaViolaciones.iterator().next().getAddressId();
				street = listaViolaciones.iterator().next().getSegid();
			}
		}
		
		return new InfraccionesLocalizacion(xcoor, ycoor, locat, address, street, lista);
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
		IQueue resp = (IQueue) new Queue<InfraccionesFechaHora>();
		Date fechaHoraInicial = new Date();
		Date fechaHoraFinal = new Date();
		
		if (listaViolaciones.iterator().hasNext() == true)
		{
			if((listaViolaciones.iterator().next().getPaid() >= valorInicial) && (listaViolaciones.iterator().next().getPaid() <= valorFinal)) {
				fechaHoraInicial = listaViolaciones.iterator().next().getTicketIssue();
				fechaHoraFinal = listaViolaciones.iterator().next().getTicketIssue();
			}
		}
		InfraccionesFechaHora infra = new InfraccionesFechaHora(convertToLocalDateTimeViaInstant(fechaHoraInicial), convertToLocalDateTimeViaInstant(fechaHoraFinal), null);
		resp.enqueue(infra);
		return resp;
		
	}

	
	/**
	 * Requerimiento 1C: Obtener  la información de  una  addressId dada
	 * @param  int addressID: Localización de la consulta.
	 * @return Objeto InfraccionesLocalizacion
	 */
	public InfraccionesLocalizacion consultarPorAddressId(int addressID)
	{
		InfraccionesLocalizacion resp = new InfraccionesLocalizacion(0, 0, "", 0, 0, new Queue<VOMovingViolations>());
		double xcoor = 0;
		double ycoor = 0;
		
		String locat = "";
		
		int address = 0;
		
		
		
		int street = 0;
		IQueue lista = (IQueue) new Queue<VOMovingViolations>();
		Iterator<VOMovingViolations> i = listaViolaciones.iterator();
		while(i.hasNext()) {
			VOMovingViolations a = i.next();
			if(a.getAddressId() == addressID) {
				xcoor = a.getXcoord();
				ycoor = a.getYcoord();
				locat = a.getLocation();
				address = a.getAddressId();
				street = a.getSegid();
			}
		}
		
		
		return new InfraccionesLocalizacion(xcoor, ycoor, locat, address, street, lista);
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
//	public Contenedora<InfraccionesViolationCode> ordenarCodigosPorNumeroInfracciones()
//	{
//		// TODO completar
//		// TODO Definir la Estructura Contenedora
//		return null;		
//	}

	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	

}
