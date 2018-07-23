package example;
/** @Author: shuyizhi @Date: 2018-07-20 16:15 @Description: */
public class HelloWorld {
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }

  public String sayTitle(String from) {
    String result = "title is " + from;
    System.out.println(result);
    return result;
  }

  public String sayBody(String Other) {
    String result = "-------------------------body is -----------------------" + Other;
    System.out.println(result);
    return result;
  }
}
