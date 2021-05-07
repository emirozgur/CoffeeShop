package interfaceAbstractDemo;

import java.time.LocalDate;

import abstracts.BaseCustomerManager;
import concrete.NeroCustomerManager;
import entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager=new NeroCustomerManager();
		customerManager.save(new Customer("Özgür","Demir",LocalDate.of(1919, 5, 19),"12345"));

	}

}
