package com.intertech.lab8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Startup {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-components.xml");
		
//		MessageChannel channel = context.getBean("requestChannel", MessageChannel.class);
//		Message<String> message = MessageBuilder.withPayload("Hello brave new world").build();
//		channel.send(message);

		PigLatinService service = context.getBean("latinService", PigLatinService.class);


		//Sync
//		System.out.println(service.translate("Hello brave new world"));


		//Async
		Future<String> future = service.translate("Hello brave new world");
		// do more work here in a real application
		System.out.println("hoge");
		System.out.println("fuga");
		System.out.println("piyo");
		String serviceOutput = null;
		try {
			serviceOutput = future.get(5000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		System.out.println(serviceOutput);



		context.close();
	}
}
