package aspectJsample;

public class LoginServiceImpl implements LoginService {

	@UseAop
	@Override
	public String login(String userName) {
		System.out.println("正在登录");
		return "success";
	}

}
