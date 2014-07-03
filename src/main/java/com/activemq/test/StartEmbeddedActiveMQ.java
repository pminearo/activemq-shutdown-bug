package com.activemq.test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StartEmbeddedActiveMQ {

	private AbstractApplicationContext broker1Context;
	private AbstractApplicationContext broker2Context;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final StartEmbeddedActiveMQ embeddedActiveMq = new StartEmbeddedActiveMQ();
		embeddedActiveMq.run();
		embeddedActiveMq.waitBeforeShutdown();
		embeddedActiveMq.stop();
	}

	public void run() {

		broker1Context = new ClassPathXmlApplicationContext("broker1-context.xml");
		broker1Context.registerShutdownHook();

		broker2Context = new ClassPathXmlApplicationContext("broker2-context.xml");
		broker2Context.registerShutdownHook();
	}

	public void waitBeforeShutdown() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

 	public void stop() {
 		broker2Context.close();
	}

}
