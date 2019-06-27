package manage.impl;
import java.sql.SQLException;
import java.util.regex.Pattern;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import exception.AdminException;
import manage.AdminManage;
/**
 * @Description: 管理员业务实现
 * @author Mr.DU
 * @date: 2019-06-25 15:10
 */
public class AdminManageImpl implements AdminManage {
	/**
	 * 管理员登陆验证
	 * @return
	 */
	@Override
	public boolean loginAdmin(String loginname, String password) throws AdminException {
		AdminDao adminDao = new AdminDaoImpl();
		try {
			Admin admin = adminDao.getAdmin(loginname);
			if (admin.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
	}

}
