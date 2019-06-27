package manage;

import entity.User;
import exception.UserException;

/**
 * @Description: 用户管理接口
 * @author Mr.DU
 * @date: 2019-06-25 14:45
 */
public interface UserManage {
	/**
	 * 用户登陆验证
	 * @return 验证结果
	 */
	boolean loginUser (String loginname, String password) throws UserException;
	/**
	 * 用户注册
	 * @return
	 */
	boolean registerUser (User user) throws UserException;
	
	String getUsername(String loginname) throws UserException;
	
	User getUserInfo(String loginname)  throws UserException;
	
	boolean updateUser(User user)  throws UserException;
}
