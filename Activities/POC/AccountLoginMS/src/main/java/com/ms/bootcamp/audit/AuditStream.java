package com.ms.bootcamp.audit;

//import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.SubscribableChannel;

public interface AuditStream {

	
	final String OUTPUT = "webaudit-out";
	//final String INPUT = "order-in";

	 
	
	@Output(OUTPUT)
	MessageChannel outboundAudit();

}
