package manage;
import java.util.List;

import entity.OrderTicket;
import exception.OrderTicketException;
import exception.UserException;
/**
 * @Description: 订票信息管理接口
 * @author Mr.DU
 * @date: 2019-06-25 14:35
 */
public interface OrderTicketManage {
	/**
	 * 
	 * @param loginname
	 * @param flightId
	 * @return
	 * @throws OrderTicketException
	 */
	boolean changeTicket (int orderTicketID, int flightID) throws OrderTicketException;
	/**
	 * 订票
	 * @param orderTicket 订票信息
	 * @return 订票号
	 * @throws UserException 
	 */
	boolean bookTicket (int flightId, String username,String identity, String loginname) throws OrderTicketException, UserException;
	/**
	 * 取消订票
	 * @param orderTicket
	 * @return
	 * @throws OrderTicketException
	 */
	boolean cancerTicket (int id) throws OrderTicketException;
	/**
	 * 获取订票信息
	 * @param username 用户姓名
	 * @return
	 * @throws OrderTicketException
	 */
	List<OrderTicket> listOrderTicket(String loginname) throws OrderTicketException;
}
