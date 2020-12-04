package at.deppn;

import at.deppen.data.Data;
import at.deppn.users.Users;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  {
		Data doit = new Data();
		Users[] users = doit.getUsers(args[0]);
		doit.writeJson(users, args[1]);
	}
}
