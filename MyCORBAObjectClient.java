import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import java.util.* ;

public class MyCORBAObjectClient {	

	public static void main(String[] args) throws InvalidName, NotFound,
			CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {

		ORB orb = ORB.init(args, null);

		String[] services = orb.list_initial_services();
		for (String s : services)
			System.out.println(s);

		org.omg.CORBA.Object nameService = orb
				.resolve_initial_references("NameService");
		NamingContext namingContext = NamingContextHelper.narrow(nameService);

		NameComponent[] path = { new NameComponent("MyObject", "Object") };
		org.omg.CORBA.Object myObject = namingContext.resolve(path);

		MyCORBAObject object = MyCORBAObjectHelper.narrow(myObject);
		System.out.println(object.getLowerCase("AbCdEfG"));

		// 1.
		object.addToList("A");
		object.addToList("B");
		object.addToList("C");
		System.out.println(object.getOneList(1));

		object.removeFromList(1);

		System.out.println(object.getOneList(0));
		object.updateList(0, "UPDATE");
		System.out.println(object.getOneList(0));

		// 2.
		System.out.println("----------------------");
		System.out.println("ADD");
		object.addBank("111-01-111", 0, 400.50);
		object.addBank("221-00-299", 1, 1400.0);
		object.addBank("201-00-878", 2, 100.0);
		System.out.println("GET");
		log(object.getBank(1));
		System.out.println("GET ALL");
		logALL(object.getBankList());
		

		System.out.println("REMOVE ID : 1");
		object.removeBank(1);
		System.out.println("GET ALL");
		logALL(object.getBankList());

		System.out.println("UPDATE ID : 0");
		object.updateBank(0, "111-01-111", 0, 1000.00);
		System.out.println("GET ALL");
		logALL(object.getBankList());
	}

	private static void log(Bank arg){
		System.out.println("\t"+arg.id + " , " + arg.account + " , " + arg.price);
	}

	private static void logALL(Bank[] arr){
		// ArrayList<Bank> arrayList = new ArrayList<Bank>(Arrays.asList(object.getBankList()));
		System.out.println("[ ");
		for(Bank bank : arr)
    		log(bank);
		System.out.println("]");
	}
}