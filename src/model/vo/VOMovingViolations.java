package model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations 
{

	private int objectId;
	
	private String location;
	
	private String addressId;
	
	private int addressID;
	
	private String streetSegId;
	
	private double xCoord;
	
	private double yCoord;
	
	private double fineAmt;
	
	private double totalPaid;
	
	private double penalty1;
	
	private double penalty2;
	
	private String accidentIndicator;
	
	private String ticketIssueDate;
	
	private String violationCode;
	
	private String violationDesc;
	
	private LocalDateTime date;
	
	
	
	public VOMovingViolations(int pObjectId, String pLocation, String pTicketIssueDate, double pTotalPaid, String pAccidentIndicator, String pViolationDesc, String pAddressId, String pStreetSegId, Double pXCoord, Double pYCoord, 
			double pFineAmt, double pPenalty1, double pPenalty2, String pViolationCode) 
	
			
	{
		objectId = pObjectId;
		location = pLocation;
		addressId = pAddressId;
		streetSegId = pStreetSegId;
		xCoord = pXCoord;
		yCoord = pYCoord;
		fineAmt = pFineAmt;
		totalPaid = pTotalPaid;
		penalty1 = pPenalty1;
		penalty2 = pPenalty2;
		accidentIndicator = pAccidentIndicator;
		ticketIssueDate = pTicketIssueDate;
		violationCode = pViolationCode;
		violationDesc = pViolationDesc;
		addressID=!pAddressId.isEmpty() ? Integer.parseInt(pAddressId) : 0;
		
	}
	
	@Override
	public String toString() {
		return "VOMovingViolations [objectId()=" + objectId() + ",\n getLocation()=" + getLocation()
				+ ",\n getTicketIssueDate()=" + getTicketIssueDate() + ",\n getTotalPaid()=" + getTotalPaid()
				+ ",\n getAccidentIndicator()=" + getAccidentIndicator() + ",\n getViolationDescription()="
				+ getViolationDescription() + ",\n getStreetSegId()=" + getStreetSegId() + ",\n getAddressId()="
				+ getAddressId() + "]\n\n";
	}

	
	/**
	 * @return id - Identificador único de la infracción
	 */
	public int objectId() 
	{
		// TODO Auto-generated method stub
		return objectId;
	}	
	/**
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() 
	{
		// TODO Auto-generated method stub
		return location;
	}

	public LocalDateTime getDate()
	{
		return date;
	}

	/**
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() {
		
		// TODO Auto-generated method stub
		return ticketIssueDate;
	}

	/**
	 * @return totalPaid - Cuanto dinero efectivamente pagó el que recibió la infracción en USD.
	 */
	public double getTotalPaid()
	{
		// TODO Auto-generated method stub
		return totalPaid;
	}

	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() 
	{
		// TODO Auto-generated method stub
		return accidentIndicator;
	}

	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() 
	{
		// TODO Auto-generated method stub
		return violationDesc;
	}

	public String getStreetSegId() 
	{
		return streetSegId;
	}

	public String getAddressId()
	{
		return addressId;
	}
	
	public int getAddressID()
	{
		return addressID;
	}



	public double getXCoord()
	{
		return xCoord;
	}

	public double getYCoord()
	{
		return yCoord;
	}

	public String getViolationCode()
	{
		return violationCode;
	}

	public int compareTo(VOMovingViolations o)
	{
		double d=this.getXCoord()-o.getXCoord();
		if(d<0)
			return -1;
		else if(d>0)
			return 1;
		else
		{
			double d2=this.getYCoord()-o.getYCoord();
			if(d2<0)
				return -1;
			else if(d2>0)
				return 1;
			return 0;
		}
	}

	public double totalAPagar()
	{
		return totalPaid+fineAmt+penalty1+penalty2;
	}

	public static class comparatorViolationCode implements Comparator <VOMovingViolations>
	{
		public int compare(VOMovingViolations arg0, VOMovingViolations arg1 )
		{
			return arg0.getViolationCode().compareTo(arg1.getViolationCode());
		}
	}

	public static class comparatorLocalDateTime implements Comparator <VOMovingViolations>
	{
		public int compare(VOMovingViolations arg0, VOMovingViolations arg1 )
		{
			return arg0.getDate().compareTo(arg1.getDate());
		}
	}

	public static class comparatorHour implements Comparator <VOMovingViolations>
	{
		public int compare(VOMovingViolations arg0, VOMovingViolations arg1 )
		{
			return arg0.getDate().getHour()-arg1.getDate().getHour();
		}
	}

	public static class comparatorCoord implements Comparator <VOMovingViolations>
	{
		public int compare(VOMovingViolations arg0, VOMovingViolations arg1 )
		{
			if(arg0.getXCoord()-arg1.getXCoord()!=0.0)
			{
				return arg0.getXCoord()-arg1.getXCoord()>0.0?1:-1;
			}
			else if(arg0.getYCoord()-arg1.getYCoord()!=0.0) 
			{
				return arg0.getYCoord()-arg1.getYCoord()>0.0?1:-1;
			}
			else
				return 0;
		}
	}

	public static class comparatorAddressID implements Comparator <VOMovingViolations>
	{
		public int compare(VOMovingViolations arg0, VOMovingViolations arg1 )
		{
			return arg0.getAddressID()-arg1.getAddressID();
		}
	}
}


