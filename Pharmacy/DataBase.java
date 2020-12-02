package Pharmacy;

class DataBase {
	String usrname;
	String password;
	String name;
	long phnno;
	String address;
	String email;

	DataBase(String usrname, String password, String name, long phnno, String address, String email) {
		this.usrname = usrname;
		this.address = address;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phnno = phnno;
	}
}