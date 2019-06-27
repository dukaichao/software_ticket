package manage;
import java.util.List;

import entity.Flight;
import exception.FlightException;
/**
 * @Description: 航班信息管理接口
 * @author Mr.DU
 * @date: 2019-06-25 14:30
 */
public interface FlightManage {
	List<Flight> listCanModify () throws FlightException;
	List<Flight> listCanFlight () throws FlightException;
	/**
	 * 获取航班信息
	 * @return
	 */
	List<Flight> listFlight () throws FlightException;
	/**
	 * 修改航班信息
	 * @param flight
	 * @return
	 * @throws FlightException
	 */
	boolean updateFlight (Flight flight) throws FlightException;
	/**
	 * 获得某航班
	 * @param id
	 * @return
	 * @throws FlightException
	 */
	Flight getFlight(int id) throws FlightException;
	/**
	 * 增加航班信息
	 * @param flight
	 * @return
	 * @throws FlightException
	 */
	boolean saveFlight (Flight flight) throws FlightException;
}
