package view.user;

import javax.swing.*;

import view.MainView;
import entity.User;
import exception.UserException;
import manage.UserManage;
import manage.impl.UserManageImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * @description: 用户注册界面
 * @author Mr.DU
 * @date: 2019-06-26
 */
public class UserRegister extends JPanel {
    
    JPanel loginname = new JPanel();
    JPanel password1 = new JPanel();
    JPanel password2 = new JPanel();
    JPanel username = new JPanel();
    JPanel identity = new JPanel();
    JPanel sex = new JPanel();
    JPanel phone = new JPanel();
    JPanel email = new JPanel();
    JPanel address = new JPanel();
    JPanel tra_name = new JPanel();
    JPanel start_place = new JPanel();
    JPanel end_place = new JPanel();
    JPanel takeoff_time = new JPanel();
    JPanel btn = new JPanel();
    
    // Label文字
    JLabel loginnameLabel = new JLabel("输入用户名:");
    JLabel password1Label = new JLabel("请输入密码:");
    JLabel password2Label = new JLabel("请再输密码:");
    JLabel usernameLabel = new JLabel("请输入姓名:");
    JLabel identityLabel = new JLabel("请输身份证:");
    JLabel sexLabel = new JLabel("请选择性别:");
    JLabel phoneLabel = new JLabel("请输入手机:");
    JLabel emailLabel = new JLabel("请输入邮箱:");
    JLabel addressLabel = new JLabel("请输入地址:");
    JLabel tra_nameLabel = new JLabel("旅行社名字");
    JLabel start_placeLabel = new JLabel("请输入起始地址:");
    JLabel end_placeLabel = new JLabel("请输入目的地:");
    JLabel takeoff_timeLabel = new JLabel("请输入旅行时间");

    // 输入框
    JTextField loginnameField = new JTextField(20);
    JPasswordField password1Field = new JPasswordField(20);
    JPasswordField password2Field = new JPasswordField(20);
    JTextField usernameField = new JTextField(20);
    JTextField identityField = new JTextField(20);
    ButtonGroup sexButton = new ButtonGroup();
    JRadioButton maleRadio = new JRadioButton("男");
    JRadioButton femaleRadio = new JRadioButton("女");
    JTextField phoneField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JTextField addressField = new JTextField(20);
    JTextField tra_nameField = new JTextField(20);
    JTextField start_placeField = new JTextField(20);
    JTextField end_placeField = new JTextField(20);
    JTextField takeoff_timeField = new JTextField(20);

    // 按钮
    JButton registerButton = new JButton("立即注册");
    JButton backButton = new JButton("返回");
    private void setComponent () {
        setLayout(new GridLayout(10, 2));
    }

    private void addComponent () {
    	sexButton.add(maleRadio);
    	sexButton.add(femaleRadio);
    	loginname.add(loginnameLabel);
    	loginname.add(loginnameField);
    	password1.add(password1Label);
    	password1.add(password1Field);
    	password2.add(password2Label);
    	password2.add(password2Field);
    	username.add(usernameLabel);
    	username.add(usernameField);
    	identity.add(identityLabel);
    	identity.add(identityField);
    	sex.add(sexLabel);
    	sex.add(maleRadio);
    	sex.add(femaleRadio);
    	phone.add(phoneLabel);
    	phone.add(phoneField);
    	email.add(emailLabel);
    	email.add(emailField);
    	address.add(addressLabel);
    	address.add(addressField);
    	tra_name.add(tra_nameLabel);
    	tra_name.add(tra_nameField);
    	start_place.add(start_placeLabel);
    	start_place.add(start_placeField);
    	end_place.add(end_placeLabel);
    	end_place.add(end_placeField);
    	takeoff_time.add(takeoff_timeLabel);
    	takeoff_time.add(takeoff_timeField);
    	btn.add(registerButton);
    	btn.add(backButton);
    	add(loginname);
    	add(password1);
    	add(password2);
    	add(username);
    	add(identity);
    	add(sex);
    	add(phone);
    	add(email);
    	add(address);
    	add(tra_name);
    	add(start_place);
    	add(end_place);
    	add(takeoff_time);
    	add(btn);
    	
    }

    private void addListener() {
    	registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loginname = loginnameField.getText();
				if (loginname.length()==0) {
					JOptionPane.showMessageDialog(null,"用户名不能为空");
					loginnameField.grabFocus();
					return;
				}
				String pattern = "^[a-zA-Z]\\w{4,17}$";
				boolean isMatch = Pattern.matches(pattern, loginname);
				if (!isMatch) {
					JOptionPane.showMessageDialog(null,"用户名：以字母开头，长度在6~18之间，只能包含字符、数字和下划线");
					// 获取用户名焦点
					loginnameField.grabFocus();
					return;
				}
				
				String password1 = password1Field.getText();
				String password2 = password2Field.getText();
				if (password1.length()==0 || password2.length()==0) {
					JOptionPane.showMessageDialog(null,"密码不能为空");
					return;
				}else if(password1.length()<5) {
					JOptionPane.showMessageDialog(null,"密码长度大于5");
					return;
				}
				if (!(password1.equals(password2))) {
					JOptionPane.showMessageDialog(null,"两次密码不一致");
					return;
				}
				
				String username = usernameField.getText();
				if (username.length()==0) {
					JOptionPane.showMessageDialog(null,"姓名不能为空");
					usernameField.grabFocus();
					return;
				}else if(!checkname(username)) {
					JOptionPane.showMessageDialog(null,"请输入中文姓名");
					usernameField.grabFocus();
					return;
				}
				
				String identity = identityField.getText();
				if (identity.length()==0) {
					JOptionPane.showMessageDialog(null,"身份证号不能为空");
					identityField.grabFocus();
					return;
				}else if(!check_IDcard(identity)) {
					JOptionPane.showMessageDialog(null,"请输入合法的身份证");
					identityField.grabFocus();
					return;
				}
				if (!(maleRadio.isSelected() || femaleRadio.isSelected())) {
					JOptionPane.showMessageDialog(null,"请选择请别");
					return;
				}
				String sex ;
				if (maleRadio.isSelected()) {
					sex = "男";
				} else {
					sex = "女";
				}
				
				String phone = phoneField.getText();
				if (phone.length()==0) {
					JOptionPane.showMessageDialog(null,"手机号码不能为空");
					phoneField.grabFocus();
					return;
				}else if(!check_Phone(phone)) {
					JOptionPane.showMessageDialog(null,"请输入正确的手机号");
					phoneField.grabFocus();
					return;
				}
				
				String email = emailField.getText();
				String address = addressField.getText();
				String tra_name = tra_nameField.getText();
				String start_place = start_placeField.getText();
				String end_place = end_placeField.getText();
				String takeoff_time = takeoff_timeField.getText();
				User user = new User();
				user.setLoginname(loginname);
				user.setPassword(password1);
				user.setUsername(username);
				user.setIdentity(identity);
				user.setSex(sex);
				user.setPhone(phone);
				user.setEmail(email);
				user.setAddress(address);
				user.setTra_name(tra_name);
				user.setStart_place(start_place);
				user.setEnd_place(end_place);
				user.setTakeoff_time(takeoff_time);
				 
				UserManage userManage = new UserManageImpl();
				try {
					boolean f = userManage.registerUser(user);
					if (f) {
						JOptionPane.showMessageDialog(null, "注册成功");
						return ;
					} else {
						JOptionPane.showMessageDialog(null, "注册失败");
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
				UserRegister.this.setVisible(false);
				new MainView ("航空订票系统");
			}
    		
    	});
    }

    public UserRegister() {
        setComponent();
        addComponent();
        addListener();
        setVisible(true);
    }
    
    public static void main(String[] args) {
    	UserRegister register = new UserRegister ();
    	JFrame jf = new JFrame("航空订票系统");
        jf.setLayout(new BorderLayout());
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(register);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
	}
    
  //验证姓名是否为中文
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
    
  //验证手机号是否合法
  	public boolean check_Phone(String str) {
  		return str.matches("1[345678]\\d{9}");
  	}


  	//验证身份证
  	public boolean check_IDcard(String str) {
  		return str.matches("[1-9]\\d{5}(19\\d{2}|20\\d{2})((0[1-9])|(10|11|12))(([0-2][1-9])|10|30|31)\\d{3}[0-9Xx]{1}");
  	} 
}
