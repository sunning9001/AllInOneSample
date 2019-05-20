https://docs.open.alipay.com/284


商户的APPID = 2016031701220615

http://test.ngrok.yugyg.com:8000/jsp/index.jsp


ENCODED_URL  =http%3A%2F%2Ftest.ngrok.yugyg.com%3A8000%2Fjsp%2Findex.jsp

http://tool.oschina.net/encode?type=4
https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2016031701220615&scope=auth_user&redirect_uri=http%3A%2F%2Ftest.ngrok.yugyg.com%3A8000%2Falilogin_loginNotify&state=init


http://test.ngrok.yugyg.com:8000/loginNotice


http%3A%2F%2Ftest.ngrok.yugyg.com%3A8000%2FloginNotice


https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2016031701220615&scope=auth_user&redirect_uri=http%3A%2F%2Ftest.ngrok.yugyg.com%3A8000%2FloginNotice&state=init

https://oauth.net/code/java/
https://en.wikipedia.org/wiki/JSON_Web_Token
https://en.wikipedia.org/wiki/Session_(computer_science)

http://www.ruanyifeng.com/blog/2018/07/json_web_token-tutorial.html
http://blog.leapoahead.com/2015/09/06/understanding-jwt/
https://github.com/auth0/java-jwt

https://en.wikipedia.org/wiki/Access_token

https://en.wikipedia.org/wiki/OAuth


https://en.wikipedia.org/wiki/Access_token
A token is composed of various fields, including: [3]

an identifier.
the identifier of the associated logon session. The session is maintained by the authentication service, and is populated by the authentication packages with a collection of all the information (credentials) the user provided when logging in. Credentials are used to access remote systems without the need for the user to re-authenticate (single sign-on), provided that all the systems involved share an authentication authority (e.g. a Kerberos ticket server)
the user identifier. This field is the most important and it's strictly read-only.
the identifiers of groups the user (or, more precisely, the subject) is part of. Group identifiers cannot be deleted, but they can be disabled or made "deny-only". At most one of the groups is designated as the session id, a volatile group representing the logon session, allowing access to volatile objects associated to the session, such as the display.
the restricting group identifiers (optional). This additional set of groups doesn't grant additional access, but further restricts it: access to an object is only allowed if it's allowed also to one of these groups. Restricting groups cannot be deleted nor disabled. Restricting groups are a recent addition, and they are used in the implementation of sandboxes.
the privileges, i.e. special capabilities the user has. Most privileges are disabled by default, to prevent damage from non-security-conscious programs. Starting in Windows XP Service Pack 2 and Windows Server 2003 privileges can be permanently removed from a token by a call to AdjustTokenPrivileges() with the SE_PRIVILEGE_REMOVED attribute.
the default owner, primary group and ACL for objects created by the subject associated to the token.