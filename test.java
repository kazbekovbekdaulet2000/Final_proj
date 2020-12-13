import Users.Admin;
import project.DataBase;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase db = DataBase.getInstance();
		Admin admin= new Admin("adad", "adada", "dada", "Addsad", 498); 
		db.load();
		System.out.println(db.users.size());
	}

}
