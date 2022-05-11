package tn.consommiTounsi.spring.chat;

import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import tn.consommiTounsi.spring.entity.Message;


@RestController

public class ChatController {
private String[] colores = {"purple","red","yellow","orange","blue","black","green"};
	@MessageMapping("/message")
	@SendTo("/chat/message") // notif pour tous les users le nv message
	public Message recevoirMessage(Message message) {
		message.setDate(new Date().getTime());
		
		if(message.getType().equals("nv_user")) {
			message.setColor(colores[new Random().nextInt(colores.length)]);
			message.setText(" - nouveau user connecté ");
		}
		
		return message;
	}
	
	 @MessageMapping("/ecrire")
	 @SendTo("/chat/ecrire")
	 public String comparerSiUserEntrainEcrire(String username) {
		 return username.concat("est entrain d'écrire...");
	 }

}
