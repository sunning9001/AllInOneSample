package aspectJsample2;

public class LoginServiceImpl implements LoginService {

	@Override
	public String login(String userName) {
		System.out.println("正在登录");
		return "success";
	}

}
