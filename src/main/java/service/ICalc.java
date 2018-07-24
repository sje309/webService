package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-23 15:53
 * @Description:
 */
@WebService(name = "calcService", targetNamespace = "http://ws.itcast.cn/")
public interface ICalc {
    @WebMethod
    int add(int num1, int num2);

    @WebMethod
    int sub(int num1, int num2);

    @WebMethod
    int mul(int num1, int num2);

    @WebMethod
    int div(int num1, int num2);
}
