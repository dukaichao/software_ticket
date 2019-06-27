package util;
import java.sql.SQLException;
/**
 * 事务的操作
 * @author Mr.DU
 * @date: 2019-06-25 20:15
 */
public interface Transaction {
	void start()  throws SQLException;
	void rollback()  throws SQLException;
	void commit() throws SQLException;
}
