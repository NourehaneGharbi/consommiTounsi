package tn.consommiTounsi.spring;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.Builder;
import tn.consommiTounsi.spring.emailDemo.EmailSenderService;
import tn.consommiTounsi.spring.services.Implementation.PromotionServiceImpl;

@SpringBootApplication
public class ConsommiTounsiApplication extends WebMvcConfigurerAdapter{

	@Value("${sendMail.active}")
	private String isEmailAvtice;
	
	@Autowired
	PromotionServiceImpl promotionServiceImpl;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsommiTounsiApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws UnsupportedEncodingException, MessagingException{
		if(this.isEmailAvtice != null && this.isEmailAvtice.equalsIgnoreCase("true")){
			promotionServiceImpl.genererPromotions();
		}
		
	}

}
