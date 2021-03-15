package com.cg.apps.task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.apps.task1.customerMgt.ui.CustomerMgtUI;
import com.cg.apps.task1.itemMgt.ui.ItemMgtUI;

@SpringBootApplication
public class Task1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Task1Application.class, args);
		CustomerMgtUI custMgtUi = context.getBean(CustomerMgtUI.class);
		custMgtUi.start();
	}

}
