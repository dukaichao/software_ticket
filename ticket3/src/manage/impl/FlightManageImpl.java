package manage.impl;

import dao.FlightDao;
import dao.impl.FlightDaoImpl;
import entity.Flight;
import exception.FlightException;
import manage.FlightManage;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author Mr.DU
 * @date: 2019-06-25 14:16
 */
public class FlightManageImpl implements FlightManage {
	
	
    /* (non-Javadoc)
	 * @see manage.FlightManage#getFlight(int)
	 */
	@Override
	public Flight getFlight(int id) throws FlightException {
		FlightDao flightDao = new FlightDaoImpl();
        try {
            Flight flight = flightDao.getFlight(id);
            if (flight == null) {
            	throw new FlightException("航班信息不存在");
            }
            return flight;
        } catch (SQLException e) {
            throw new FlightException("没有航班信息");
        }
	}

	/* (non-Javadoc)
	 * @see manage.FlightManage#listCanModify()
	 */
	@Override
	public List<Flight> listCanModify() throws FlightException {
		FlightDao flightDao = new FlightDaoImpl();
        try {
            List<Flight> flights = flightDao.listCanModify();
            return flights;
        } catch (SQLException e) {
            throw new FlightException("没有航班信息");
        }
	}

	/**
     * 获取航班信息
     *
     * @return
     */
    @Override
    public List<Flight> listFlight() throws FlightException {
        FlightDao flightDao = new FlightDaoImpl();
        try {
            List<Flight> flights = flightDao.listFlight();
            return flights;
        } catch (SQLException e) {
            throw new FlightException("没有航班信息");
        }
    }

    /**
     * 修改航班信息
     *
     * @param flight
     * @return
     * @throws FlightException
     */
    @Override
    public boolean updateFlight(Flight flight) throws FlightException {
    	FlightDao flightDao = new FlightDaoImpl ();
    	try {
    		boolean f = flightDao.updateFlight(flight);
    		if (f) {
    			return true;
    		} else {
    			return false;
    		}
    	} catch (SQLException e) {
    		throw new  FlightException(e.getMessage());
    	}
    }

    /**
     * 增加航班信息
     *
     * @param flight
     * @return
     * @throws FlightException
     */
    @Override
    public boolean saveFlight(Flight flight) throws FlightException {
    	FlightDao flightDao = new FlightDaoImpl ();
    	try {
    		boolean f = flightDao.saveFlight(flight);
    		if (f) {
    			return true;
    		} else {
    			return false;
    		}
    	} catch (SQLException e) {
    		throw new  FlightException(e.getMessage());
    	}
    }

	@Override
	public List<Flight> listCanFlight() throws FlightException {
		// TODO Auto-generated method stub
		FlightDao flightDao = new FlightDaoImpl();
        try {
            List<Flight> flights = flightDao.listCanFlight();
            return flights;
        } catch (SQLException e) {
            throw new FlightException("没有航班信息");
        }
	}
}
