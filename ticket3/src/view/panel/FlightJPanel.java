package view.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import manage.impl.OrderTicketManageImpl;
import view.tablemodel.FlightTableModel;
import exception.FlightException;
import exception.OrderTicketException;
import exception.UserException;
/**
 * @author Mr.DU
 * @date: 2019-06-26
 *
 */
public class FlightJPanel extends JPanel {
	FlightTableModel flight = null;
    JTable table = null;
    private String loginname;
    
    public FlightJPanel (String loginname){
    	this.loginname = loginname;
    	setPreferredSize(new Dimension(800, 500));
    	setSize (800, 450);
    	setLocation(0, 50);
    	
    	try {
    		flight = new FlightTableModel();
            table = new JTable(flight);
            setComponent ();
            addComponent();
            addListener();
    	} catch (FlightException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
    
    private void setComponent () {
        // 设置第一列宽度为40
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        // 设置第二列宽度为150
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        setLayout(new FlowLayout());

    }
    
    private void addComponent () {
        // 使用scrollpane会自动显示列名
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
       
    }
    private void addListener () {
        // selection监听器监听表格哪行被选中
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            	// 获取哪一行被选中
				int row = table.getSelectedRow();
				// 出发时间
				String takeoff_time = (String)flight.getValueAt(row, 1);
				// 出发地
				String start_place = (String)flight.getValueAt(row, 3);
				// 目的地
				String end_place = (String)flight.getValueAt(row, 4);
				// 飞行时间
				String flying_time = (String)flight.getValueAt(row, 2);
				String flightInfo = "您已选择于 "+takeoff_time+"  从 【"+start_place+"】 开往 【"+end_place+"】 "+flying_time+" 的航班";
				int Yes_or_no = JOptionPane.showConfirmDialog (null, flightInfo, "是否订购", JOptionPane.YES_NO_OPTION);
				if (Yes_or_no == JOptionPane.YES_OPTION) {
					// 让用户输入姓名
					String username = JOptionPane.showInputDialog("请输入购票姓名：");
					if (username == null || "".equals(username)) {
						JOptionPane.showMessageDialog(null,"没有输入姓名");
						return ;
					}else if(!checkname(username)) {
						JOptionPane.showMessageDialog(null,"请输入中文名字");
					}
					// 让用户输入身份证
					String identity = JOptionPane.showInputDialog("请输入购票身份证号：");
					if (identity == null || "".equals(identity)) {
						JOptionPane.showMessageDialog(null,"没有输入身份证号或者输入身份证不合法");
						return ;
					}else if(!check_IDcard(identity)) {
						JOptionPane.showMessageDialog(null,"输入身份证不合法");
					}
					OrderTicketManageImpl orderTicketManage = new OrderTicketManageImpl ();
					try {
						boolean f = orderTicketManage.bookTicket(row+1, username, identity, FlightJPanel.this.loginname);
						if (f) {
							JOptionPane.showMessageDialog(null,"订票成功");
						} else {
							JOptionPane.showMessageDialog(null,"订票失败");
						}
					} catch (OrderTicketException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage());
					} catch (UserException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (Yes_or_no == JOptionPane.NO_OPTION){
					return ;
				}
            }
        });
    }
    
    public boolean check_Phone(String str) {
  		return str.matches("1[345678]\\d{9}");
  	}


  	//验证身份证
  	public boolean check_IDcard(String str) {
  		return str.matches("[1-9]\\d{5}(19\\d{2}|20\\d{2})((0[1-9])|(10|11|12))(([0-2][1-9])|10|30|31)\\d{3}[0-9Xx]{1}");
  	} 
  	
  	public boolean checkname(String name)
    {
        int n = 0;
        for(int i = 0; i < name.length(); i++) {
            n = (int)name.charAt(i);
            if(!(19968 <= n && n <40869)) {
                return false;
            }
        }
        return true;
    }
   
}
