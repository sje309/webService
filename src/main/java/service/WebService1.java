package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @Author: shuyizhi @Date: 2018-07-23 10:55 @Description: 定义SEL(WebService EndPoint Interface)终端
 */

/** 使用@WebService注解标注WebService1接口 */
@WebService
public interface WebService1 {
    /**
     * 使用@WebMethod注解标注WebService1接口中的方法
     *
     * @param name
     * @return
     */
    @WebMethod
    String sayHello(String name);

    @WebMethod
    String save(String name, String pwd);
}
