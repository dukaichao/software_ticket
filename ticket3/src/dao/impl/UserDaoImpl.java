package dao.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JDBCUtil;
import util.impl.UserMapperImpl;
import dao.UserDao;
import entity.User;
/**
 * 用户Dao实现类
 * @author Mr.DU
 * @date: 2019-06-24 18:03
 */
public class UserDaoImpl implements UserDao {
	/**
	 * 删除用户
	 * @param id 用户对象
	 * @return 删除结果
	 */
	@Override
	public boolean delUser(int id) throws SQLException {
		String sql = "DELETE FROM user WHERE id=?";
		try {
            int i = JDBCUtil.executeUpdate(sql, id);
            if (i == 0) {
                throw new SQLException("用户不存在");
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException("无法执行该操作，请联系管理员");
        }
	}
	/**
	 * 获得某用户
	 * @param id 用户id
	 * @return 用户对象
	 */
	@Override
	public User getUser(int id) throws SQLException {
		String sql = "SELECT *  FROM user WHERE id=?";
		try {
			List<User> listUser = new ArrayList<User>();
			List<Object> objects = JDBCUtil.executeQuery(sql, new UserMapperImpl(), id);
			if (objects.size() == 0) {
				return null;
			}
			for (Object o:objects) {
				listUser.add((User)o);
			}
			return listUser.get(0);
		} catch (SQLException e) {
			throw new SQLException("无法执行该操作，请联系管理员");
		}
	}
	/**
	 * 获得所有用户
	 * @return 用户对象数组
	 */
	public List<User> listUser() throws SQLException {
		String sql = "SELECT *  FROM user";
		try {
			List<User> listUser = new ArrayList<User>();
			List<Object> objects = JDBCUtil.executeQuery(sql, new UserMapperImpl());
			if (objects.size() == 0) {
				return null;
			}
			for (Object o:objects) {
				listUser.add((User)o);
			}
			return listUser;
		} catch (SQLException e) {
			throw new SQLException("无法执行该操作，请联系管理员");
		}
	}
	/**
	 * 创建用户
	 * @param user 用户对象
	 * @return 创建结果
	 */
	@Override
	public boolean saveUser(User user) throws SQLException {
		String sql = "INSERT INTO user (loginname, password, username,"
				+ " identity, sex, phone, email, address,tra_name,start_place,"
				+ "end_place,takeoff_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            int i = JDBCUtil.executeUpdate(sql, user.getLoginname(), 
            		user.getPassword(), user.getUsername(), user.getIdentity(),
            		user.getSex(), user.getPhone(), user.getEmail(), user.getAddress(),
            		user.getTra_name(),user.getStart_place(),user.getEnd_place(),user.getTakeoff_time());
            if (i == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new SQLException("无法执行该操作，请联系管理员");
        }
	}

	/**
	 * 更新用户数据
	 * @param user 用户对象
	 * @return 更新结果
	 */
	@Override
	public boolean updateUser(User user) throws SQLException {
		/*String sql = "UPDATE user SET loginname=?, password=?,"
				+ " username=?, identity=?, sex=?, phone=?, email=?, "
				+ "address=?, tra_name=?,start_place=?,end_place=?,takeoff_time=? WHERE id=?";
		*/
		String sql = "UPDATE user SET password=?,"
				+ " username=?, identity=?, phone=? WHERE id=?";
		
		try {
			int i = JDBCUtil.executeUpdate(sql,
            		user.getPassword(), 
            		user.getUsername(), 
            		user.getIdentity(),
            		user.getPhone(),
            		user.getId()
            		/*user.getSex(), 
            		user.getEmail(), 
            		user.getAddress(),
            		user.getTra_name(),
            		user.getStart_place(),
            		user.getEnd_place(),
            		user.getTakeoff_time()*/);
			if (i == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException("无法执行该操作，请联系管理员");
		}
	}
	/**
	 * 获得某用户
	 * @param loginname
	 * @return 用户对象
	 */
	@Override
	public User getUser(String loginname) throws SQLException {
		String sql = "SELECT *  FROM user WHERE loginname=?";
		try {
			List<User> listUser = new ArrayList<User>();
			List<Object> objects = JDBCUtil.executeQuery(sql, new UserMapperImpl(), loginname);
			if (objects.size() == 0) {
				return null;
			}
			for (Object o:objects) {
				listUser.add((User)o);
			}
			return listUser.get(0);
		} catch (SQLException e) {
			throw new SQLException("无法执行该操作，请联系管理员");
		}
	}
}
