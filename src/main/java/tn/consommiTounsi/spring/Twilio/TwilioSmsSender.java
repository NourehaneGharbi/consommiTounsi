package tn.consommiTounsi.spring.Twilio;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.txw2.IllegalAnnotationException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.services.Implementation.StockServiceImpl;

@Service("twilio")
public class TwilioSmsSender implements SmsSender{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);
	private final TwilioConfiguration twilioConfiguration;
	private StockServiceImpl stockServiceImpl;
	
	@Autowired
	public TwilioSmsSender(TwilioConfiguration twilioConfiguration, StockServiceImpl stockServiceImpl) {
		this.stockServiceImpl = stockServiceImpl;
		this.twilioConfiguration = twilioConfiguration;
	}

	@Override
	public void sendSms(SmsRequest smsRequest) {
		
	  PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
	  PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrial_number());
	  if(!isPhoneNumberValid(smsRequest.getPhoneNumber())){
		  throw new IllegalAnnotationException(
					"Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
			);
	  }
	  List<Stock> stocks = stockServiceImpl.retrieveAllStocks();
	  
	  String message = "Stock insuffisant pour ces produits:\n"
	  + String.join(
			  ",", stocks.stream()
			  .filter(s -> s.getQuantite() <= s.getQuantiteMin())
			  .map(s -> s.getProduit().getLibelleProduit())
			  .collect(Collectors.toList()));
		  
	
	MessageCreator creator = Message.creator(to, from, message);
	creator.create();
	LOGGER.info("Send sms {} " + smsRequest);
	
	//genere précommande (baaed mayousel lsms lel admin ychouf ken yheb yzid menou lproduit +crud(przcommande))
	 
	}


	private boolean isPhoneNumberValid(String phoneNumber) {
		// TODO Auto-generated method stub
		// TODO: Implement phone number validator
		return true;
	}

}
