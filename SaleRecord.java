package salerecordpack;


public class SaleRecord {
	
	//Fields used to create the objects contained in the array
		private final String date;
		private final String salesPerson;
		private final String customerName;
		private final String carMake;
		private final String carModel;
		private final int carYear;
		private final double salePrice;
		private final double commissionRate;
		private final double commssionEarned;

		//Constructor for SaleRecord array
		public  SaleRecord(String date, String salesPerson, String customerName,String carMake, String carModel, int carYear, double salePrice, double commisionRate, double commissionEaned) {
			this.date = date;
			this.salesPerson = salesPerson;
			this.customerName = customerName;
			this.carMake = carMake;
			this.carModel = carModel;
			this.carYear = carYear;
			this.salePrice = salePrice;
			this.commissionRate = commisionRate;
			this.commssionEarned = commissionEaned;
			}
		
		public String getDate() {
			return date;
		}

		public String getSalesPerson() {
			return salesPerson;
		}

		public String getCustomerName() {
			return customerName;
		}

		public String getCarMake() {
			return carMake;
		}

		public String getCarModel() {
			return carModel;
		}

		public int getCarYear() {
			return carYear;
		}

		public double getSalePrice() {
			return salePrice;
		}

		public double getCommissionRate() {
			return commissionRate;
		}

		public double getCommssionEarned() {
			return commssionEarned;
		}

}//end of SaleReord class
