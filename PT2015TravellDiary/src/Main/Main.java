package Main;
<<<<<<< HEAD
import controller.Controlling;
=======
import Controller.Controlling;
>>>>>>> 6879f3a50d8323e44357ae604634ad065c80e79f
import Model.DbConnection;
import Model.GoogleRequest;
import View.Login;
import View.Registration;

public class Main {

	public static void main(String[] args) {
		
	
		Login logView = new Login();
		Controlling c = new Controlling(logView);
<<<<<<< HEAD
		logView.showLogin();
=======
		logView.setVisible(true);
>>>>>>> 6879f3a50d8323e44357ae604634ad065c80e79f
		
	}

}
