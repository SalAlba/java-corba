import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class MyCORBAObjectServer {
	public static void main(String[] args) throws InvalidName, AdapterInactive,
			ServantNotActive, WrongPolicy, NotFound, CannotProceed,
			org.omg.CosNaming.NamingContextPackage.InvalidName {

		ORB orb = ORB.init(args, null);
		POA root = (POA) orb.resolve_initial_references("RootPOA");
		root.the_POAManager().activate();

		MyCORBAObjectImpl o = new MyCORBAObjectImpl();
		org.omg.CORBA.Object ref = root.servant_to_reference(o);

		System.out.println(orb.object_to_string(ref));

		org.omg.CORBA.Object nameService = orb
				.resolve_initial_references("NameService");
		NamingContext namingContext = NamingContextHelper.narrow(nameService);

		NameComponent[] path = { new NameComponent("MyObject", "Object") };
		namingContext.rebind(path, ref);

		orb.run();
	}
}