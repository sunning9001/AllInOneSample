/**
@CreateTime: sunning2019年3月21日
@CreateUser: sunning 
@Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
*/

 package com.panli.paypal;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;

import com.egzosn.pay.common.api.PayService;
import com.egzosn.pay.common.bean.CurType;
import com.egzosn.pay.common.bean.MethodType;
import com.egzosn.pay.common.bean.PayOrder;
import com.egzosn.pay.common.http.HttpConfigStorage;
import com.egzosn.pay.paypal.api.PayPalConfigStorage;
import com.egzosn.pay.paypal.api.PayPalPayService;
import com.egzosn.pay.paypal.bean.PayPalTransactionType;

/**
 * @author sunning
 * @date 2019/03/21
 */
public class TestMain {

    
    public static void main(String[] args) {
        

        PayPalConfigStorage configStorage = new PayPalConfigStorage();
        configStorage.setClientID("Ae1W4TjVCqlxmAlePCvHON3d1iCeKdd5tJUcbAZNvNaNJx5vU_eKHOvxT1sWMx");
        configStorage.setClientSecret("ELpEq4kI7kpVnJ2L7-jlGPSqoA-95tU6LYFA8oVTVPW7wJ7Oa8HbpqKOI2rUY_BqN_Q6VlVVLiXMEkhD");
        configStorage.setTest(true);
        //发起付款后的页面转跳地址
        configStorage.setReturnUrl("http://127.0.0.1:8088/pay/success");
        //取消按钮转跳地址,这里用异步通知地址的兼容的做法
        configStorage.setNotifyUrl("http://127.0.0.1:8088/pay/cancel");
           
        

        //网络请求配置

        HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
        
      /* /网络请求连接池**/
        //最大连接数
        httpConfigStorage.setMaxTotal(20);
        //默认的每个路由的最大连接数
        httpConfigStorage.setDefaultMaxPerRoute(10);
        

        //创建支付服务

    //支付服务
     PayService service = new PayPalPayService(configStorage);

     //设置网络请求配置根据需求进行设置
     //service.setRequestTemplateConfigStorage(httpConfigStorage)
     

     //创建支付订单信息

        //支付订单基础信息
         PayOrder order = new PayOrder("Order_payment:", "Order payment", new BigDecimal("0.01"), UUID.randomUUID().toString().replace("-", ""), PayPalTransactionType.sale);
  

         //网页支付

        //币种
        order.setCurType(CurType.USD);
        Map orderInfo = service.orderInfo(order);
       String request = service.buildRequest(orderInfo, MethodType.POST);
       System.out.println("===============");
       System.out.println(request);

    
    }
}
