package at.deppn;

import at.deppen.data.Datamake;
import at.deppn.users.Users;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  {
		Datamake doit = new Datamake();
		Users[] users = doit.getUsers(args[0]);
		doit.writeJson(users, args[1]);
	}
}
