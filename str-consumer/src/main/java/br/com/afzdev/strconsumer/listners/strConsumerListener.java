package br.com.afzdev.strconsumer.listners;

import br.com.afzdev.strconsumer.custom.StrCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class strConsumerListener {

    @StrCustomListener(groupId = "group-id-1")
    public void listen(String message) throws RuntimeException{
        log.info(" CREATE ::: Mensagem recebida : {}", message);
        throw new RuntimeException("EXCEPTION .....");
    }


    @StrCustomListener(groupId = "group-id-2", containerFactory = "validMessageContainerFactory")
    public void listenA(String message) {
        log.info("listenA ::: Mensagem recebida : {}", message);
    }


//    @StrCustomListener(groupId = "group-id-1")
//    public void listenB(String message) {
//        log.info("listenB ::: Mensagem recebida : {}", message);
//    }

//    @StrCustomListener(groupId = "group-id-1")
//    public void listenC(String message) {
//        log.info("listenC ::: Mensagem recebida : {}", message);
//    }


}
