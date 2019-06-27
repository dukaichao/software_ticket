package manage;

import exception.AdminException;
/**
 * @Description: 管理员接口
 * @author Mr.DU
 * @date: 2019-06-25 14:03
 */
public interface AdminManage {
	/**
	 * 管理员登陆验证
	 * @return
	 */
	boolean loginAdmin (String loginname, String password) throws AdminException;
}
