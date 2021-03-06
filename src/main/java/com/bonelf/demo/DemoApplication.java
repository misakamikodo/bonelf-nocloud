package com.bonelf.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.bonelf.cicada.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.UnknownHostException;

/**
 * <p>
 * 默认情况下，扫描入口类同级及其子级包下的所有文件，这里配置了扫描公共配置
 * </p>
 * @author bonelf
 * @since 2020/10/6 18:58
 */
@Slf4j
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {
		"com.bonelf.demo","com.bonelf.support"
},
		exclude = {DruidDataSourceAutoConfigure.class})
public class DemoApplication {

	public static void main(String[] args) throws UnknownHostException {
		ConfigurableApplicationContext application;
		// try {
		application = SpringApplication.run(DemoApplication.class, args);
		// } catch (Throwable e) {
		// 	e.printStackTrace();
		// 	throw e;
		// }
		Environment env = application.getEnvironment();
		//String ip = InetAddress.getLocalHost().getHostAddress();
		String ip = IpUtil.getWlanV4Ip();
		String port = env.getProperty("server.port");
		String path = env.getProperty("server.servlet.context-path");
		// netty ws://XXXX:8026
		// norm ws://XXXX:8800
		log.info("\n----------------------------------------------------------\n\t" +
				"Application is running! Access URLs:\n\t" +
				"Local: \t\thttp://127.0.0.1:" + port + path + "\n\t" +
				"External: \thttp://" + ip + ":" + port + path + "\n\t" +
				"Websocket(stomp): \thttp://" + ip + ":" + port + "/bonelf/wst\n" +
				"----------------------------------------------------------");
	}
}