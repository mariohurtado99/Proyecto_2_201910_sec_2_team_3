package model.vo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representation of a Trip object
 * @author Mario Hurtado
 * @param <T>
 */
public class VOMovingViolations<T> implements Comparable<VOMovingViolations<T>> {

	/**
	 * Id del objeto
	 */
	private String objectId;

	/**
	 * row
	 */
	private String row;

	/**
	 * Location del objeto
	 */
	private String location;

	/**
	 * Id de la dirección
	 */
	private int addressId;

	/**
	 * street segid
	 */
	private int segid;

	/**
	 * Coordenada x.
	 */
	private double xcoord;

	/**
	 * Coordenada y.
	 */
	private double ycoord;

	/**
	 * Tipo de ticket.
	 */
	private String ticketType;

	/**
	 * Valor multa.
	 */
	private String fine;

	/**
	 * Valor pago.
	 */
	private double paid;

	/**
	 * Penalty 1.
	 */
	private String penalty1;

	/**
	 * Penalty 2.
	 */
	private String penalty2;

	/**
	 * Indicador de accidente.
	 */
	private String accidentId;

	/**
	 * Fecha del ticket.
	 */
	private Date ticketIssue;

	/**
	 * Código violado.
	 */
	private String violationCode;

	/**
	 * Descripción de la violación.
	 */
	private String violationDesc;

	/**
	 * Id de fila.
	 */
	private String rowId;

	@Override
	public String toString() {
		return "VOMovingViolations [objectId()=" + getObjectId() + ",\n getLocation()=" + getLocation()
		+ ",\n getTicketIssueDate()=" + getTicketIssue() + ",\n getTotalPaid()=" + getPaid()
		+ ",\n getAccidentIndicator()=" + getAccidentId() + ",\n getViolationDescription()="
		+ getViolationDesc() + ",\n getStreetSegId()=" + getSegid() + ",\n getAddressId()="
		+ getAddressId() + "]\n\n";
	}





	/**
	 * @param objectId
	 * @param row
	 * @param location
	 * @param addressId
	 * @param segid
	 * @param xcoord
	 * @param ycoord
	 * @param ticketType
	 * @param fine
	 * @param paid
	 * @param penalty1
	 * @param penalty2
	 * @param accidentId
	 * @param ticketIssue
	 * @param violationCode
	 * @param violationDesc
	 * @param rowId
	 */
	public VOMovingViolations(String objectId, String row, String location, int addressId, int segid,
			double xcoord, double ycoord, String ticketType, String fine, double paid, String penalty1, String penalty2,
			String accidentId, String ticketIssue, String violationCode, String violationDesc, String rowId) {
		this.objectId = objectId;
		this.row = row;
		this.location = location;
		this.addressId = addressId;
		this.segid = segid;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.ticketType = ticketType;
		this.fine = fine;
		this.paid = paid;
		this.penalty1 = penalty1;
		this.penalty2 = penalty2;
		this.accidentId = accidentId;
		setTicketIssue(ticketIssue);
		this.violationCode = violationCode;
		this.violationDesc = violationDesc;
		this.rowId = rowId;
	}

	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the segid
	 */
	public int getSegid() {
		return segid;
	}

	/**
	 * @param segid the segid to set
	 */
	public void setSegid(int segid) {
		this.segid = segid;
	}

	/**
	 * @return the xcoord
	 */
	public double getXcoord() {
		return xcoord;
	}

	/**
	 * @param xcoord the xcoord to set
	 */
	public void setXcoord(double xcoord) {
		this.xcoord = xcoord;
	}

	/**
	 * @return the ycoord
	 */
	public double getYcoord() {
		return ycoord;
	}

	/**
	 * @param ycoord the ycoord to set
	 */
	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}

	/**
	 * @return the ticketType
	 */
	public String getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * @return the fine
	 */
	public String getFine() {
		return fine;
	}

	/**
	 * @param fine the fine to set
	 */
	public void setFine(String fine) {
		this.fine = fine;
	}

	/**
	 * @return the paid
	 */
	public double getPaid() {
		return paid;
	}

	/**
	 * @param paid the paid to set
	 */
	public void setPaid(double paid) {
		this.paid = paid;
	}

	/**
	 * @return the penalty1
	 */
	public String getPenalty1() {
		return penalty1;
	}

	/**
	 * @param penalty1 the penalty1 to set
	 */
	public void setPenalty1(String penalty1) {
		this.penalty1 = penalty1;
	}

	/**
	 * @return the penalty2
	 */
	public String getPenalty2() {
		return penalty2;
	}

	/**
	 * @param penalty2 the penalty2 to set
	 */
	public void setPenalty2(String penalty2) {
		this.penalty2 = penalty2;
	}

	/**
	 * @return the accidentId
	 */
	public String getAccidentId() {
		return accidentId;
	}

	/**
	 * @param accidentId the accidentId to set
	 */
	public void setAccidentId(String accidentId) {
		this.accidentId = accidentId;
	}

	/**
	 * @return the ticketIssue
	 */
	public Date getTicketIssue() {
		return ticketIssue;
	}

	/**
	 * @param ticketIssue the ticketIssue to set
	 */
	public void setTicketIssue(String ticketIssue) {

		String[] fecha=ticketIssue.split(".000Z");
		String []fechaa=fecha[0].split("T");

		String completa=fechaa[0]+fechaa[1];

		SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
		try {
			Date esto =SDF.parse(completa);
			this.ticketIssue=esto;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the violationCode
	 */
	public String getViolationCode() {
		return violationCode;
	}

	/**
	 * @param violationCode the violationCode to set
	 */
	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}

	/**
	 * @return the violationDesc
	 */
	public String getViolationDesc() {
		return violationDesc;
	}

	/**
	 * @param violationDesc the violationDesc to set
	 */
	public void setViolationDesc(String violationDesc) {
		this.violationDesc = violationDesc;
	}

	/**
	 * @return the rowId
	 */
	public String getRowId() {
		return rowId;
	}

	/**
	 * @param rowId the rowId to set
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Override
	public int compareTo(VOMovingViolations<T> o) {
		return this.getTicketIssue().compareTo(o.getTicketIssue());

	}
}
