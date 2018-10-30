package f17g305;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	private String userName;
	private String passWord;
	private String hostName;
	private String sqlServerName;
	private String dbSchema;
	private String sqlQuery;
	private String finalResult;
	private String connectionMessage;
	private String errorMessage;
	private String sqlErrorCode;
	private String sqlState;

	public String getSqlErrorCode() {
		return sqlErrorCode;
	}
	public void setSqlErrorCode(String sqlErrorCode) {
		this.sqlErrorCode = sqlErrorCode;
	}
	public String getSqlState() {
		return sqlState;
	}
	public void setSqlState(String sqlState) {
		this.sqlState = sqlState;
	}


	private static String url = "";
	private  String jdbcDriver = "com.mysql.jdbc.Driver";
	private static Statement statement;
	private static DatabaseMetaData databaseMetaData;
	private static ResultSet resultSet;
	private static Connection connection = null;
	public String getSqlServerName() {
		return sqlServerName;
	}
	public void setSqlServerName(String sqlServerName) {
		this.sqlServerName = sqlServerName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDbSchema() {
		return dbSchema;
	}
	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}
	public String getSqlQuery() {
		return sqlQuery;
	}
	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}
	public String getFinalResult() {
		return finalResult;
	}
	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}
	public String getConnectionMessage() {
		return connectionMessage;
	}
	public void setConnectionMessage(String connectionMessage) {
		this.connectionMessage = connectionMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public  String getConnection() {

		connectionMessage="fail";
		try {
			url = "jdbc:mysql://"+hostName+":3306/world";
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(url, userName, passWord);
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			databaseMetaData = connection.getMetaData();
			resultSet = databaseMetaData.getCatalogs();
			connectionMessage="Success";
			// set status to true - established connection
		} // end try
		 catch (ClassNotFoundException e) {
				this.errorMessage = "Either Host or DB type is incorrect.";
				return "fail";
			} catch (SQLException e) {
				this.sqlState = e.getSQLState();
				if (e.getSQLState().equals("28000")) {
					this.errorMessage = "Either username or password is incorrect.";
				} else { this.errorMessage = "Either Host or DB type is incorrect.";
				}
				return "fail";
			} catch (Exception e) {
				this.errorMessage = "All credentials incorrect.";
				return "fail";
			}
  
		return connectionMessage;

	}

	public String displayResults() {


		try {
			String con = getConnection();
			if (con.equalsIgnoreCase("SUCCESS")) {
				System.out.println(sqlQuery);
				resultSet = statement.executeQuery(sqlQuery);
				resultSet.next();
				connectionMessage="display";
	
			}
			
			

				finalResult = resultSet.getInt(1)+"";
				
			}
		
			

		 catch (Exception e) {
			e.printStackTrace();

			connectionMessage="not valid";
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return finalResult;

	}
	
	public void closeConnection() {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext()
		.invalidateSession();
		FacesContext
		.getCurrentInstance()
		.getApplication()
		.getNavigationHandler()
		.handleNavigation(FacesContext.getCurrentInstance(), null,
		"/index.jsp");
	   }
}
