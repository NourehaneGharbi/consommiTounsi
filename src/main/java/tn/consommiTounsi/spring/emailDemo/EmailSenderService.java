package tn.consommiTounsi.spring.emailDemo;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.entity.User;
import tn.consommiTounsi.spring.repository.UserRepository;
import tn.consommiTounsi.spring.services.Implementation.StockServiceImpl;


@Service
public class EmailSenderService {

	
	private JavaMailSender mailSender;
	
	private StockServiceImpl stockServiceImpl;
	
	private UserRepository userRepository;
	
	@Autowired
	public EmailSenderService(JavaMailSender mailSender, StockServiceImpl stockServiceImpl, UserRepository userRepository) {
		this.stockServiceImpl = stockServiceImpl;
		this.mailSender = mailSender;
		this.userRepository = userRepository;
	}
	
	
	public void sendMail(String libelle)
		
		throws MessagingException, UnsupportedEncodingException {	
		    String fromAddress = "nourehane.gharbi@esprit.tn";
		    String senderName = "Consommi Tounsi";
		    String subject = "Veuillez vérifier votre Promotion";
		    String content = "Cher [[name]],<br>"
		    		+"Les dates de ces produits seront bientôt expirée : "
		    		 +libelle
		    		+"<br>"
		            + "Veuillez cliquer sur le lien ci-dessous pour mettre les produits en promotion :<br>"
		            + "<h3><a href=\"http://localhost:8081/SpringMVC/demandePromotion\" target=\"_self\">PROMOTION</a></h3>"
		            + "Merci Beaucoup d'avance,<br>"
		            + "Consommi Tounsi.";
		     
			
		    MimeMessage message = mailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message);
		     
		    helper.setFrom(fromAddress, senderName);
		    helper.setTo("nourhene.gharbi1@gmail.com");
		    helper.setSubject(subject);
		     
		 //   content = content.replace("[[name]]", user.getFullName());
		    //String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
		     
		  //  content = content.replace("[[URL]]", verifyURL);
		     
		    helper.setText(content, true);
		     
		    mailSender.send(message);
		    
		    System.out.println("Mail Sent successfully...");
		     
		}
	}
	
	
	
    

		
	

