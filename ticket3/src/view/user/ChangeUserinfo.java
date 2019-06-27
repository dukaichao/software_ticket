package view.user;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import entity.User;
import exception.UserException;
import manage.UserManage;
import manage.impl.UserManageImpl;

/**
 * @author Mr.DU
 * @date: 2019-06-26
 *
 */
public class ChangeUserinfo extends JFrame{
	private User user;
	JPanel loginname = new JPanel();
	JPanel oldPasss = new JPanel();
    JPanel password1 = new JPanel();
    JPanel password2 = new JPanel();
    JPanel username = new JPanel();
    JPanel identity = new JPanel();
    JPanel phone = new JPanel();
    JPanel btn = new JPanel();
    /*JPanel sex = new JPanel();
    JPanel phone = new JPanel();
    JPanel email = new JPanel();
    JPanel address = new JPanel();
    JPanel tra_name = new JPanel();
    JPanel start_place = new JPanel();
    JPanel end_place = new JPanel();
    JPanel takeoff_time = new JPanel();
    JPanel btn = new JPanel();*/
    
    // Label文字
    JLabel loginnameLabel = new JLabel("用户名:");
    JLabel oldPasssLabel = new JLabel("输入旧密码:");
    JLabel password1Label = new JLabel("请输入密码:");
    JLabel password2Label = new JLabel("请再输密码:");
    JLabel usernameLabel = new JLabel("姓名:");
    JLabel identityLabel = new JLabel("请输身份证:");
    JLabel phoneLabel = new JLabel("请输入手机:");
    /*JLabel sexLabel = new JLabel("请选择性别:");
    JLabel phoneLabel = new JLabel("请输入手机:");
    JLabel emailLabel = new JLabel("请输入邮箱:");
    JLabel addressLabel = new JLabel("请输入地址:");
    JLabel tra_nameLabel = new JLabel("旅行社名字");
    JLabel start_placeLabel = new JLabel("请输入起始地址:");
    JLabel end_placeLabel = new JLabel("请输入目的地:");
    JLabel takeoff_timeLabel = new JLabel("请输入旅行时间");*/

    // 输入框
    JLabel loginnameField = new JLabel("");
    JPasswordField oldPasssField = new JPasswordField(20);
    JPasswordField password1Field = new JPasswordField(20);
    JPasswordField password2Field = new JPasswordField(20);
    JLabel usernameField = new JLabel("");
    JLabel identityField = new JLabel("");
    JTextField phoneField = new JTextField(20);
    /*ButtonGroup sexButton = new ButtonGroup();
    JRadioButton maleRadio = new JRadioButton("男");
    JRadioButton femaleRadio = new JRadioButton("女");
    JTextField phoneField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JTextField addressField = new JTextField(20);
    JTextField tra_nameField = new JTextField(20);
    JTextField start_placeField = new JTextField(20);
    JTextField end_placeField = new JTextField(20);
    JTextField takeoff_timeField = new JTextField(20);*/
    
    // 按钮
    JButton changeButton = new JButton("修改个人信息");
    JButton backButton = new JButton("返回");
	private void init () {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	
	private void setComponent () {
		setLayout(new GridLayout(11, 1));
		loginnameField.setText(user.getLoginname());
		usernameField.setText(user.getUsername());
		identityField.setText(user.getIdentity());
		phoneField.setText(user.getPassword());
		/*emailField.setText(user.getEmail());
		addressField.setText(user.getAddress());
		tra_nameField.setText(user.getTra_name());
		start_placeField.setText(user.getStart_place());
		end_placeField.setText(user.getEnd_place());
		takeoff_timeField.setText(user.getTakeoff_time());*/
	}
	
	private void addComponent () {
		/*sexButton.add(maleRadio);
    	sexButton.add(femaleRadio);*/
    	loginname.add(loginnameLabel);
    	loginname.add(loginnameField);
    	oldPasss.add(oldPasssLabel);
    	oldPasss.add(oldPasssField);
    	password1.add(password1Label);
    	password1.add(password1Field);
    	password2.add(password2Label);
    	password2.add(password2Field);
    	username.add(usernameLabel);
    	username.add(usernameField);
    	identity.add(identityLabel);
    	identity.add(identityField);
    	/*sex.add(sexLabel);
    	sex.add(maleRadio);
    	sex.add(femaleRadio);*/
    	phone.add(phoneLabel);
    	phone.add(phoneField);
    	/*email.add(emailLabel);
    	email.add(emailField);
    	address.add(addressLabel);
    	address.add(addressField);*/
    	btn.add(changeButton);
    	btn.add(backButton);
    	/*tra_name.add(tra_nameField);
    	tra_name.add(tra_nameLabel);
    	start_place.add(start_placeLabel);
    	start_place.add(start_placeField);
    	end_place.add(end_placeLabel);
    	end_place.add(end_placeField);
    	takeoff_time.add(takeoff_timeLabel);
    	takeoff_time.add(takeoff_timeField);*/
    	add(loginname);
    	add(oldPasss);
    	add(password1);
    	add(password2);
    	add(username);
    	add(identity);
    	add(phone);
    	/*add(sex);
    	add(email);
    	add(address);
    	add(tra_name);
    	add(start_place);
    	add(end_place);
    	add(takeoff_time);*/
    	add(btn);
	}
	
	private void addListenter () {
		changeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loginname = loginnameField.getText();
				String oldPass = oldPasssField.getText();
				String password1 = password1Field.getText();
				String password2 = password2Field.getText();
				if (oldPass.length()==0) {
					JOptionPane.showMessageDialog(null,"旧密码不能为空");
					return;
				}
				if (password1.length()==0 || password2.length()==0) {
					JOptionPane.showMessageDialog(null,"密码不能为空");
					return;
				}
				if (!password1.equals(password2)) {
					JOptionPane.showMessageDialog(null,"两次密码不一致");
					return;
				}
				if (oldPass.equals(password1)) {
					JOptionPane.showMessageDialog(null,"旧密码和新密码不能相同");
				}
				String username = usernameField.getText();
				String identity = identityField.getText();
				/*if (!(maleRadio.isSelected() || femaleRadio.isSelected())) {
					JOptionPane.showMessageDialog(null,"请选择请别");
					return;
				}
				String sex ;
				if (maleRadio.isSelected()) {
					sex = "男";
				} else {
					sex = "女";
				}*/
				String phone = phoneField.getText();
				if (phone.length()==0) {
					JOptionPane.showMessageDialog(null,"手机号码不能为空");
					phoneField.grabFocus();
					return;
				}
				/*String email = emailField.getText();
				String address = addressField.getText();
				String tra_name = tra_nameField.getText();
				String start_place = start_placeField.getText();
				String end_place = end_placeField.getText();
				String takeoff_time = takeoff_timeField.getText();*/
				User user = new User();
				
				user.setLoginname(loginname);
				user.setPassword(password1);
				user.setUsername(username);
				user.setIdentity(identity);
				user.setPhone(phone);
				/*user.setSex(sex);
				user.setEmail(email);
				user.setAddress(address);
				user.setTra_name(tra_name);
				user.setStart_place(start_place);
				user.setEnd_place(end_place);
				user.setTakeoff_time(takeoff_time);*/
				
				 
				UserManage userManage = new UserManageImpl();
				try {
					User check = userManage.getUserInfo(loginname);
					user.setId(check.getId());
					if (!(check.getPassword().equals(oldPass))) {
						JOptionPane.showMessageDialog(null, "旧密码输入错误");
						return ;
					}
					
					// 修改用户信息
					boolean f = userManage.updateUser(user);
					if (f) {
						JOptionPane.showMessageDialog(null, "修改成功");
						return ;
					} else {
						JOptionPane.showMessageDialog(null, "修改失败");
						return ;
					}
				} catch (UserException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			};
    		
    	});
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChangeUserinfo.this.setVisible(false);
				UserFrame u = new UserFrame (ChangeUserinfo.this.user.getLoginname());
				return;
			}
			
		});
	}
	
	public ChangeUserinfo (String loginname) {
		super("修改个人信息");
		UserManage userMange = new UserManageImpl();
		try {
			User user = userMange.getUserInfo(loginname);
			this.user = user;
		} catch (UserException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		init ();
		setComponent ();
		addComponent ();
		addListenter ();
		setVisible(true);
	}
	
}
