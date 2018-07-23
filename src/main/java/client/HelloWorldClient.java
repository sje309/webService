package client;

import impl.WebService1Impl;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.lang3.StringUtils;

import javax.xml.rpc.ServiceException;
import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/** @Author: shuyizhi @Date: 2018-07-20 17:25 @Description: */
public class HelloWorldClient {
    public static void main(String[] args) {
        publishWebService1();
    }

    /** 发布WebService1 */
    public static void publishWebService1() {
        String address = "http://127.0.0.1:2222/WS_Server/WebService";
        Endpoint.publish(address, new WebService1Impl());
        System.out.println("发布WebService发布成功!");
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
}
