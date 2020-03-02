package com.feng.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.IOException;

public class TomcatStarter {
    private static int port = 8080;
    private static String contextPath = "/";

    public static void start() throws LifecycleException, IOException, ServletException {
        Tomcat tomcat = new Tomcat();
        String baseDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        tomcat.setBaseDir(baseDir);
        tomcat.setPort(port);
        //tomcat.setConnector(new Connector());

        tomcat.addWebapp(contextPath, baseDir);
        tomcat.enableNaming();
        tomcat.start();
        tomcat.getServer().await();
    }

    public static void main(String[] args) throws IOException, LifecycleException, ServletException {
        start();
    }

}
