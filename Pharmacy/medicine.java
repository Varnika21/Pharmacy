package Pharmacy;

class medicine {
	int id;
	int date, month, year;
	String disease, tablet;
	float cost;
	int quantity;

	public medicine(int id, String disease, String tablet, int date, int month, int year, float cost, int quantity) {
		this.id = id;
		this.disease = disease;
		this.tablet = tablet;
		this.date = date;
		this.month = month;
		this.year = year;
		this.cost = cost;
		this.quantity = quantity;
	}
}