package client;

import example.ServerFactoryBeanDemo;
import impl.CalculatorImpl;
import impl.WebService1Impl;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import service.ICalc;

import javax.xml.rpc.ServiceException;
import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/** @Author: shuyizhi @Date: 2018-07-20 17:25 @Description: */
public class HelloWorldClient {
    public static void main(String[] args) {
        //publishWebService1();
        //publishWebServerByServerFactoryBean();
        //publishWebServiceByJaxWsServerFactoryBean();
        //int res = methodCallCalc();
        //System.out.println("res: " + res);

        publishWebServiceByJaxWsServerFactoryBean();
    }

    /**
     * 发布WebService1:::使用EndPoint发布
     * 参考：https://blog.csdn.net/hanxuemin12345/article/details/40163757
     */
    public static void publishWebService1() {
        String address = "http://127.0.0.1:2222/WS_Server/WebService";
        Endpoint.publish(address, new WebService1Impl());
        System.out.println("发布WebService发布成功!");
    }

    /**
     * 发布WebService:::使用ServerFactoryBean方式
     * 参考：https://blog.csdn.net/javandroid/article/details/17095815
     */
    public static void publishWebServerByServerFactoryBean() {
        ServerFactoryBean sf = new ServerFactoryBean();
        //服务实现类
        sf.setServiceClass(ServerFactoryBeanDemo.class);
        //服务的发布地址
        sf.setAddress("http://127.0.0.1:1111/hello");
        //服务的实现
        sf.setServiceBean(new ServerFactoryBeanDemo());
        //发布服务
        Server server = sf.create();
        if (server.isStarted()) {
            System.out.println("服务已发布，并且启动.......通过http://127.0.0.1:1111/hello?wsdl访问");
        }
    }

    /**
     * JaxWsServerFactoryBean方式发布WebService
     * 参考：https://blog.csdn.net/javandroid/article/details/17095815
     */
    public static void publishWebServiceByJaxWsServerFactoryBean() {
        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
        //服务实现类
        jaxWsServerFactoryBean.setServiceClass(ICalc.class);
        //服务的发布地址
        jaxWsServerFactoryBean.setAddress("http://127.0.0.1:5555/calculator");
        //服务的实例
        jaxWsServerFactoryBean.setServiceBean(new CalculatorImpl());
        //发布服务
        Server server = jaxWsServerFactoryBean.create();
        if (server.isStarted()) {
            System.out.println("服务已经发布,访问地址为: http://127.0.0.1:5555/calculator");
        }
    }
    /** 测试Calculator */
    public static void testCalculator() {
        String url = "http://localhost:8080/services/Calculator";
        String method = "add";
        Integer[] params = new Integer[] {10, 10};
        String result = methodCall(url, method, params);
        System.out.println("result: " + result);
    }

    /** 测试HelloWorld */
    public static void testHelloWorld() {
        String url = "http://localhost:8080/services/HelloWorld";
        String method = "sayTitle";
        String[] parms = new String[] {"abc"};
        String result = methodCall(url, method, parms);
        System.out.println("result: " + result);
    }

    /**
     * WebService方法调用
     *
     * @param url
     * @param method
     * @param args
     * @return
     */
    public static String methodCall(String url, String method, Object[] args) {
        String result = null;
        if (StringUtils.isEmpty(url)) {
            return "url 为空";
        }
        if (StringUtils.isEmpty(method)) {
            return "method 为空";
        }
        org.apache.axis.client.Call rpcCall = null;
        try {
            // 实例webService调用实例
            Service webService = new Service();
            rpcCall = (Call) webService.createCall();
            rpcCall.setTargetEndpointAddress(new java.net.URL(url));
            rpcCall.setOperationName(method);

            // 执行webService方法
            result = (String) rpcCall.invoke(args);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int methodCallCalc() {
        int result = 0;
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(ICalc.class);
        factoryBean.setAddress("http://127.0.0.1:5555/calculator?wsdl");
        ICalc calculator = (ICalc) factoryBean.create();
        result = calculator.add(10, 20);
        return result;
    }
}
