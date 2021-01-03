package com.ikuta.customize;

//自定义函数
//该类及其函数需要在一个扩展名为.tld的xml文件中进行注册
//tld(tag library definition):标签库定义文件
//XML文件是需要约束的,即XML文件需要配置文件头部
//头部约束可以从以下文件中复制:E:\tomcat-9.0\webapps\examples\WEB-INF\jsp2\jsp2-example-taglib.tld
//这个tld的XML文件需要定义在当前web项目的WEB-INF目录下
public class ELFunctions {
    // 将字符串小写变大写
    public static String lowerToUpper(String source) {
        return source.toUpperCase();
    }

    // 将字符串大写变小写
    public static String upperToLower(String source) {
        return source.toLowerCase();
    }
}

