package databasetools;

import databasetools.ui.frame.LoginWindow;

public class StartClient {

	public static void main(String[] args) {
		try {

			LoginWindow.getInstance();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
