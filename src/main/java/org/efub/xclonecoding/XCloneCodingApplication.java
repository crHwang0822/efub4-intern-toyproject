package org.efub.xclonecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class XCloneCodingApplication {

    public static void main(String[] args) {
        SpringApplication.run(XCloneCodingApplication.class, args);
    }

}
