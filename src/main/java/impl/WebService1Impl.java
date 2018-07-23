package impl;

import service.WebService1;

import javax.jws.WebService;

/** @Author: shuyizhi @Date: 2018-07-23 10:58 @Description: SEL的具体实现 */
@WebService
public class WebService1Impl implements WebService1 {
    @Override
    public String sayHello(String name) {
        System.out.println("WebService sayHello " + name);
        return "sayHello " + name;
    }

    @Override
    public String save(String name, String pwd) {
        System.out.println("WebService save " + name + ", " + pwd);
        return "save " + name + ", " + pwd + "success";
    }
}
