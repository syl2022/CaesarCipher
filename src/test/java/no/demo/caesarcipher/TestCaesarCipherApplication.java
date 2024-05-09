package no.demo.caesarcipher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCaesarCipherApplication {

    public static void main(String[] args) {
        SpringApplication.from(CaesarCipherApplication::main).with(TestCaesarCipherApplication.class).run(args);
    }

}
