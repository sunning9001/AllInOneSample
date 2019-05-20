package com.panli.alipay.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016031701220615";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCx3S+Jbzx87BgtzwioXsBQT9NdN5ql3hSFRf17ZKTG8dtuf93k2gINTgVWzh7hPaHuz0wgZOb5bvhZSbxbgUf6Y3RJkv176ackjiH4a/AUYLWOFGiXLdounM1nkUf4FSCUpD1yhT5rTnG0wngz0zEOjchbARwQPyiDDZK6SV3SwW0YDGIxu7v/xIIr5Z1ij0EnlrJqf8Exg/Kjdc7ZM8tpZiVbFfz/4QhinNB9PjJ+tvnNqCa/Ht17J0+Ikvw8x+wFybEeTXigxlOZqL8DUNJZa7Ib0TjSfzR81op+vuPtojEDKO1ij2VRwVToOUtNZ5a+k/Gb4Qq9JWGMm+YSO7tBAgMBAAECggEAH8WuJzPKr1oRW6V/G2yJmA8aZ612H6kTK1d8V118Hdm4Y/3NaoMTGMNWKtJ5K60xzxISvDqqE+ah0Hlef04RyIWZkUcDpu3vIJWPNew6H7nC1NWKdW8IaYkzHAwUuhk0D7ljDKEGrG5/21Vd2YwhWEM1hiQlmjVeDEMRcduHOg1s5tG/T6YvLwLxcEEMFfZp+R1ZSUCq/1QO2h04PPvMZon+w1qudF36Z9gAumDY6BLBskh1Kz1brUFQhNZ1GlVgH97/o6ZHuvIUs3Dk1Y/WDrOZh6sU9G36CLS5C9Tg1iCAnUZKNelXcw1YfH1vB0vnIaGvMXtmxRJCxkPxl0uDQQKBgQDoauuFs8HCJ3F8jA8O4hWuN8+Is7fRqXILQdqUURGAaP21EdGLAQLBZQWltb9QIDXeEGDVMvLlwIpWnKszTKN9oD4y0A39XwZNzSUMt5bsQwwtznOyVh1j6Ce+Xo3DEATBo846irneZX5mEaO2W+wjWopFNIBdD9XSoKRKuSmrWQKBgQDD6TouRFhsnzni+3kh3Xcl6rKe7mPz/hYZMO2jfXvaVYdO/yCstUaGBBN96QcGCVEdYOhtN1vnDX2Co19KcMblG85JZQN4KypTvoc7olPldp5Qg8H4SzRBUD5cgM2Yi4os92vakk5V9BgrssoS4frXDNA1ysuJyFDwdcflRqJaKQKBgBW7aapm1IdDCOmMbxwFJ+HSdiViKJ4CKhfDYJzdt7U6G/8CW4WT4p4SxCRqiikD2gWZonRM/0lcZ5MRszBoyiDFCwvVSHmYmQ5NUFmQERymaE0gMNFMHBNrccvrK3ZB2TACERaIQjj5ZIhGvfgfQEVOAf/WmOoawPOg8bvK9IqBAoGBAJ1ht0OD1CUupKobquvxpc3oBSZ4DAPukoIaNE2qeNyk6NYlTnJwDf+LNr1nfiTzRx56wz05w7KRu8o+xEZg4ucat1VuuKLIynAMF0do2Ez2RagYsLJud8QgWnilYISzVIVbHmGwNw4F0YUJVBxnPcOUn48XIvvE2IDTnYoqfDJBAoGAEhCl+Fo6DeXp6cY+0yYbPQaBGRblN0IaRZXCS+ZxLAUo2xA7KGSRGw1ByJYlTYxTz/qrZPpWIz8Xoesm+ZGpOUHZQgyOxBIkB7M+Y2t+vIZ4hi9i6G+yXGmqAblBVNxwuxR7vWPdcjVfcI2ITdm/kZcSwCa6n9u5qETSyGz4Umc=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlgWMh6T83BTn6fRC+Ra3mBnOrEtATSFAoEl+kLum56RToWUKm+j4N69HerkUKrVV05PUfbrawBIlqlUiKSjTA0KiNEQ9cxTOJFiPnPilSqOAwgzQXprUtFEWB0Pd0E0cyuHo8EsXmlfTObYhQBzmPDXRFG/zJTJrUT3sEZRYayX0SCcafsgtCEi8Tb8QsWZXea8ZTHwBCz8yyC7Fdnj0fAvf42aEP1sdnvPPReG6yHO+ej+7F94vB0/Nh1wFq4KWeUsfVnUUguK4JQ7lVuurZ8Wf2I7U37hYJEF/Ivnn7U5CAkdjEFsvqxgk43gEpGMnRfPK48RAi+IFCWin2FUyjQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://localhost:8080/jsp/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    public static String notify_url = "http://test.ngrok.yugyg.com:8000/trade_notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://test.ngrok.yugyg.com:8000/jsp/index.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	//public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

