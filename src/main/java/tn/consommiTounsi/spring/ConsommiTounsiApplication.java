package tn.consommiTounsi.spring;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import tn.consommiTounsi.spring.emailDemo.EmailSenderService;

@SpringBootApplication
public class ConsommiTounsiApplication extends WebMvcConfigurerAdapter{

	@Autowired
	EmailSenderService emailSenderService;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsommiTounsiApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
	//public void sendMail() throws UnsupportedEncodingException, MessagingException{
	//	emailSenderService.sendMail("nourhene.gharbi1@gmail.com");
	//}

}
