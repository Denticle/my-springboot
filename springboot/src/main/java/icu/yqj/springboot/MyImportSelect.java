package icu.yqj.springboot;

import org.apache.catalina.Server;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class MyImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //自动配置
        ServiceLoader<AutoConfiguration> loader = ServiceLoader.load(AutoConfiguration.class);
        List<String> list = new ArrayList<>();
        for (AutoConfiguration configurations:loader) {
            list.add(configurations.getClass().getName());
        }
        return list.toArray(new String[0]);
    }
}
