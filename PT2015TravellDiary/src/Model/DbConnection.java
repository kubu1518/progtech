/**
 * 
 */
package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Random;

/**
 * @author Rosti
 *
 */
public abstract class DbConnection {
	private static String url = "jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g";
	private static Connection con;
	private static int profileID;

	/**
	 * 
	 * 
	 * */

	public static Connection getCon() {
		return con;
	}

	public static int getProfileID() {
		return profileID;
	}

	public static boolean validateProfile(String profName, String profPass) {
		buildConnection();
		ResultSet rs = null;
		try {
			PreparedStatement st = con
					.prepareStatement("select PROFILE_ID, USERNAME, PASSW from U_PROFILE where USERNAME = ? and PASSW = ? ");
			st.setString(1, profName);
			st.setString(2, profPass);
			rs = st.executeQuery();

			if (rs.next()) {
				profileID = rs.getInt(1);

				rs.close();
				con.close();
				return true;

			} else {
				rs.close();
				con.close();
				return false;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				rs.close();
				con.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}

	}

	public static Profile allDateToProfile() {
		String sql = "select profile_id,full_name,username,passw,date_of_creation from U_profile where profile_id = ?";
		LinkedList<Journey> tmpj = new LinkedList<Journey>();

		Profile prof = null;
		buildConnection();

		try (PreparedStatement pst = getCon().prepareStatement(sql)) {
			pst.setInt(1, getProfileID());
			try (ResultSet rs = pst.executeQuery()) {
				rs.next();
				prof = new Profile(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),rs.getDate(5), null);
				System.out.println(rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sql = "select journey_id,journey_name,date_of_begin,date_of_end,journey_type,date_of_creation from journeys where profile_id = ?";

		try (PreparedStatement pst = getCon().prepareStatement(sql)) {
			pst.setInt(1, prof.getProfileId());
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					tmpj.add(new Journey(rs.getInt(1), rs.getString(2), rs
							.getDate(3), rs.getDate(4), rs.getString(5),rs.getDate(6) ,null));
				}

			}
			prof.setJourneys(tmpj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sql = "select day_id,day_number,day_desc,cost_of_day from days where journey_id = ?";
		
		for(Journey j : prof.getJourneys()){
			LinkedList<Day> tmpd = new LinkedList<Day>();
			try(PreparedStatement pst = getCon().prepareStatement(sql)){
				pst.setInt(1, j.getJourneyId());
				try(ResultSet rs = pst.executeQuery()){
					while(rs.next()){
						tmpd.add(new Day(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getDouble(4)));
					}
				}
				j.setDays(tmpd);
				
			} 
			  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
		
		
		sql = "select l.LOCATION_ID, l.LOCATION_NAME,l.LONGITUDE,l.LATITUDE "
				+ "from loc_to_day lc join locations l on lc.loc_id = l.location_id "
				+ "where lc.DAY_ID = ? order by lc.L_ORDER";
		
		for(Journey j : prof.getJourneys())
			for(Day d :  j.getDays()){
				LinkedList<Location> ltmp = new LinkedList<Location>();
				try(PreparedStatement pst = getCon().prepareStatement(sql)){
					pst.setInt(1, d.getDayId());
					try(ResultSet  rs = pst.executeQuery()){
						while(rs.next()){
							ltmp.add(new Location(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				d.setLocations(ltmp);
			}
			
		return prof;
	}

	public static void buildConnection() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("lib/dbconnection.properties"));

			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			if (con == null || con.isClosed())
				con = DriverManager.getConnection(url, p);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean createNewProfile(String fullname, String username,
			String pass) {
		buildConnection();
		ResultSet rs = null;
		int n;
		while (true) {
			n = getRanId();
			try (PreparedStatement pst = con
					.prepareStatement("select profile_id from u_profile where profile_id = ?")) {
				pst.setInt(1, n);
				rs = pst.executeQuery();
				if (!rs.next())
					break;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try (PreparedStatement pst = con
				.prepareStatement("select username from u_profile where username = ?")) {
			pst.setString(1, username);
			;
			rs = pst.executeQuery();
			if (rs.next())
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try (PreparedStatement pst = con
				.prepareStatement("insert into U_PROFILE (PROFILE_ID,FULL_NAME, USERNAME,PASSW) VALUES(?,?,?,?)")) {
			pst.setInt(1, n);
			pst.setString(2, fullname);
			pst.setString(3, username);
			pst.setString(4, pass);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static int getRanId() {
		Random n = new Random();
		return 1000 + n.nextInt(8999);
	}

}
