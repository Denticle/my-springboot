package icu.yqj.springboot;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;


public class MySpringApplication {

    public static void run(Class clazz) {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(clazz);
        webApplicationContext.refresh();

        WebServer webServer = getWebServer(webApplicationContext);
        webServer.start();
    }

    public static WebServer getWebServer(WebApplicationContext webApplicationContext){
        Map<String, WebServer> beansOfType = webApplicationContext.getBeansOfType(WebServer.class);
        if (beansOfType.isEmpty()){
            throw new NullPointerException();
        }

        if (beansOfType.size() > 1){
            throw new IllegalStateException();
        }

        return beansOfType.values().stream().findFirst().get();
    }
}
