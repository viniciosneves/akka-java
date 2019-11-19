package atores;

import java.io.Serializable;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import modelos.MensagemAkka;

//Um ator que exibe no console a mensagem recebida.
//Vamos implementar Serializable pq as mensagens podem ser distribuídas entre servidores
public class EcoActor extends UntypedActor implements Serializable {

	private static final long serialVersionUID = 1L;
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	// Declaramos o ator filho como atributo de EcoActor
	private ActorRef childActor;

	@Override
	public void preStart() throws Exception {
		super.preStart();

		// Na inicialização do ator, instanciamos o ator filho
		childActor = getContext().actorOf(Props.create(ChildActor.class), "childOfEco");
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof MensagemAkka) {
			log.info("Mensagem recebida: " + msg);
			// repassamos a mensagem recebida para o ator filho
			childActor.tell(msg, getSelf());
		} else {
			// informa ao actor system que este ator não processa esta mensagem
			unhandled(msg);
		}
	}

}