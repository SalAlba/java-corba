import java.util.*;

public class MyCORBAObjectImpl extends MyCORBAObjectPOA{

	// ...
	private List<Bank> bankList = new ArrayList<Bank>();
	private List<String> list = new ArrayList<String>();
	// private static int idx = 0;
	
	// ...
	public String getLowerCase(String s) {
		return s.toLowerCase();
	}

	// ...
	public String getOneList(int index){
		System.out.println("LOG : SEVER GET " + index);		
		return list.get(index);
	}

	public void removeFromList(int index) {
		System.out.println("LOG : SEVER REMOVE");
		System.out.println(getOneList(index));
		list.remove(index);
	}

	public void updateList(int index, String msg) {
		System.out.println("LOG : SEVER UPDATE");
		list.set(index, msg);
	}

	public void addToList(String msg) {
		System.out.println("LOG : SEVER ADD");
		list.add(msg);
		// idx++;
	}


	public Bank getBank(int index){
		return bankList.get(index);
	}

	public Bank[] getBankList (){
		return bankList.toArray(new Bank[bankList.size()]);
	}
	
	public void addBank(String account, int id, double price) {
		System.out.println("LOG : SEVER ADD Bank");
		bankList.add(new Bank(account, id, price));
	}

	public void removeBank(int index) {
		System.out.println("LOG : SEVER REMOVE Bank");
		bankList.remove(index);
	}

	public void updateBank(int index, String account, int id, double price) {
		System.out.println("LOG : SEVER UPDATE Bank");
		bankList.set(index, new Bank(account, id, price));		
	}
}