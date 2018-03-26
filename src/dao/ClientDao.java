package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domaine.Client;

public class ClientDao {
	
	private String url = "jdbc:mysql://localhost/test";
	private String login = "root";
	private String psw = "";
	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public Client selectOneClient(int idClient) {
		connect();
		String sql = "Select * from client where idclient = "+idClient;
		try {
			this.rs = this.st.executeQuery(sql);
			Client c = new Client();
			this.rs.first();	// je mets le curseur sur la première ligne
			c.setNom(this.rs.getString("nom"));
			c.setPrenom(this.rs.getString("prenom"));
			c.setAge(this.rs.getInt("age"));
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateClient() {}

	public void insertClient() {}
	
	public void deleteClient() {}
	
	public void listClient() {}
	
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection(url, login, psw);
			this.st = this.cn.createStatement();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
