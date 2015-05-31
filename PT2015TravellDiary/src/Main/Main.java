package Main;
import controller.Controlling;
import Model.DbConnection;
import Model.GoogleRequest;
import View.Login;
import View.Registration;

public class Main {

	public static void main(String[] args) {
		
	
		Login logView = new Login();
		Controlling c = new Controlling(logView);
		logView.showLogin();
		
	}

}
