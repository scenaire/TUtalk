package Client;

import java.util.ArrayList;

public class ClientList {
	
	private ArrayList<Client> ClientList;
	
	public ClientList() {
		ClientList = new ArrayList<Client>();
	}
	
	public void addClient(Client client) {
		ClientList.add(client);
	}
	
	public Client getClientAtIndex(int index) {
		return ClientList.get(index);
	}
	
	public void removeAll() {
		ClientList.clear();
	}
	
	public ArrayList<Client> getClientList() {
		return ClientList;
	}

	public ArrayList<Client> getOnlineList() {
		ArrayList<Client> onlineList = new ArrayList<Client>();
		for(Client a:ClientList) {
			if (a.isStatus()) {
				onlineList.add(a);
			}
		}
		return onlineList;
	}

}
