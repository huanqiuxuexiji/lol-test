package com.java2.web.Listener;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.java2.web.Entity.NowUser;
import com.java2.web.Entity.User;
import com.java2.web.Service.NowService;
import com.java2.web.Service.UserService;

@Component
public class shoppingListener extends HttpServlet implements ServletRequestListener, ServletContextListener {

	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(shoppingListener.class);

	public void contextInitialized(ServletContextEvent sce) {
		Timer timer = new Timer();
		log.info("initial context....");
		System.out.println("��ѯ��⿪ʼִ�С���������������������");
		timer.schedule(new MyTask(), 0, 10000);
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void requestDestroyed(ServletRequestEvent sre) {
	}

	public void requestInitialized(ServletRequestEvent sre) {
	}

}

class MyTask extends TimerTask {
	// private final static Log log = LogFactory.getLog(MyTask.class);
	private static ApplicationContext ctx = null;
	private static NowService nowService;
	private static UserService userService;

	static {
		ctx = new ClassPathXmlApplicationContext("/WEB-INF/applicationContext.xml");
		nowService = (NowService) ctx.getBean("nowService");
		userService = (UserService) ctx.getBean("userService");
	}

	@SuppressWarnings("null")
	public void run() {
		System.out.println("��ⷽ����ʼִ��");
		Path path = Paths.get("C:/Users/jiyu/Desktop/12345.txt");
		OutputStream buff = null;
		try {
			buff = new BufferedOutputStream(new FileOutputStream(path.toFile(), true));
			byte[] contentInBytes;
			String content;
			List<NowUser> list1 = null;
			List<User> list2 = null;
			list1 = nowService.getAllUsers();
			list2 = userService.getAllUsers();

			if (list1.isEmpty()) {
				for (User user : list2) {
					nowService.createUser(user);
				}
			} else {
				for (NowUser nowUser : list1) {
					for (User user : list2) {
						if (user.getNickName().equals(nowUser.getNickName())) {
							if (!nowUser.getSex().equals(user.getSex())) {
								content = "\r\nsex�����ı䡣������" + "��ȥֵ��" + nowUser.getSex() + "����ֵ��" + user.getSex();
								contentInBytes = content.getBytes();
								buff.write(contentInBytes);
								buff.flush();
							} else if (!nowUser.getEmail().equals(user.getEmail())) {
								content = "\r\nemail�����ı䡣������" + "��ȥֵ��" + nowUser.getEmail() + "����ֵ��" + user.getEmail();
								contentInBytes = content.getBytes();
								buff.write(contentInBytes);
								buff.flush();
							} else if (!nowUser.getPassword().equals(user.getPassword())) {
								content = "\r\npassword�����ı䡣������" + "��ȥֵ��" + nowUser.getPassword() + "����ֵ��"
										+ user.getPassword();
								contentInBytes = content.getBytes();
								buff.write(contentInBytes);
								buff.flush();
							}
						}

					}
				}
				int m = 0;
				for (NowUser nowUser : list1) { // �ж�ɾ��
					m++;
					if (m >= list2.size()) {
						content = "\r\n�û���   " + nowUser.getNickName() + "Ϊɾ���û�����";
						contentInBytes = content.getBytes();
						buff.write(contentInBytes);
						buff.flush();
					}
				}

				int n = 0;
				for (User user : list2) { // �ж�����
					n++;
					if (n >= list1.size()) {
						content = "\r\n�û���   " + user.getNickName() + "Ϊ�����û�����";
						contentInBytes = content.getBytes();
						buff.write(contentInBytes);
						buff.flush();
					}
				}

				for (User user : list2) {
					nowService.refreshUser(user.getId(), user);
				}

			}
		} catch (

		IOException e) {
			e.printStackTrace();
		} finally {
			if (buff == null) {
				try {
					buff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("��ѯ������ִ�С�����������\n\n\n\n");
		}

	}
}
