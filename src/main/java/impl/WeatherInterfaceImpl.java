package impl;

import service.WeatherInterface;

import javax.jws.WebService;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-24 15:14
 * @Description:
 */
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    public String queryWeather(String cityName) {
        System.out.println("接收到客户端发送的城市名称: " + cityName);
        System.out.println("晴，高温预警");
        String res = "晴，高温预警";
        return res;
    }
}
