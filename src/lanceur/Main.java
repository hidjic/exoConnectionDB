package lanceur;

import dao.ClientDao;
import domaine.Client;

public class Main {

	public static void main(String[] args) {
		Client c = new Client();
		ClientDao co = new ClientDao();
		
		c = co.selectOneClient(1);
		
		System.out.println(c);
		
	}

}
