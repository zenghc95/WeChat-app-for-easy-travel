package yan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import yan.dto.UserDTO;
import yan.util.DataAccess;


public class LoginDao {
	//��ȡcon
	Connection con=(Connection) DataAccess.getCon();
	public boolean Login(UserDTO user) throws SQLException{
			PreparedStatement ps=null;
			ResultSet rs=null;
			UserDTO AdminiStratordto=new UserDTO();
			String sql="select * from user where account=? and password=?";//user�����ݿ�ı�����account��password�Ǳ�����Ӧ������
			ps=con.prepareStatement(sql);
			ps.setString(1,user.getAccount());
			ps.setString(2,user.getPassword());
			rs=ps.executeQuery();
			if(rs.next())	{
				return true;
			} else { 
				return false;
			}
		}
}
