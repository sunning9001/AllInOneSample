package proxyfactory;

public class LoginServiceImpl {


	public String login(String userName) {
		System.out.println("正在登录");
		return "success";
	}

}
