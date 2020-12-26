package at.deppn;

import at.deppn.data.Datamake;
import at.deppn.users.Users;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  {
		Datamake doit = new Datamake();
		Users[] users = doit.getUsers(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),args[3]);
		doit.writeJson(users, args[4]);
	}
}
