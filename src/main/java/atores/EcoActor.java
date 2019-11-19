package atores;

import java.io.Serializable;

import akka.actor.UntypedActor;
import akka.event.LoggingAdapter;
import akka.event.Logging;


//Um ator que exibe no console a mensagem recebida.
//Vamos implementar Serializable pq as mensagens podem ser distribuídas entre servidores
public class EcoActor extends UntypedActor implements Serializable {

	private static final long serialVersionUID = 1L;
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {
		log.info("Mensagem recebida: " + msg);
	}

}