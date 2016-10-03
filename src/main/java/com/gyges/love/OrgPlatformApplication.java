package com.gyges.love;

		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.web.servlet.ServletComponentScan;
		import org.springframework.context.ApplicationContext;

		import java.text.SimpleDateFormat;

@SpringBootApplication
@ServletComponentScan
public class OrgPlatformApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrgPlatformApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrgPlatformApplication.class, args);
		LOGGER.info("项目名称为："+context.getApplicationName());
		LOGGER.info("启动时间为：" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(context.getStartupDate())));

	}
}
