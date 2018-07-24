package server;

import impl.WeatherInterfaceImpl;

import javax.xml.ws.Endpoint;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-24 15:17
 * @Description:
 */
public class WeatherServer {
    public static void main(String[] args) {
        //发布服务
        Endpoint.publish("http://127.0.0.1:1111/weather", new WeatherInterfaceImpl());
    }
}
