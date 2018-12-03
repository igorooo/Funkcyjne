public class Pojazd {
	private String producer;
	private String model;
	private String registrationNumber;
	private int productionYear;
	
	public Pojazd(String producer, String model) {
		this(producer, model, "", -1);
	}
	
	public Pojazd(String producer, String model, String registrationNumber) {
		this(producer, model, registrationNumber, -1);
	}
	
	public Pojazd(String producer, String model, int productionYear) {
		this(producer, model, "", productionYear);
	}
	
	public Pojazd(String producer, String model, String registrationNumber, int productionYear) {
		this.producer = producer;
		this.model = model;
		this.registrationNumber = registrationNumber;
		this.productionYear = productionYear;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getProductionYear() {
		return productionYear;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
}