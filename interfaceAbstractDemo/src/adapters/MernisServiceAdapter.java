package adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import abstracts.CustomerCheckService;
import entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result = false;
		
		try {
			result= client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), customer.getFirstName().toUpperCase(Locale.ROOT), 
					customer.getLastName().toUpperCase(Locale.ROOT), customer.getDateOfBirth().getYear());
		} 
		
		catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		
		catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
