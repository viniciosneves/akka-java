package atores;

import java.io.Serializable;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ChildActor extends UntypedActor implements Serializable {

	private static final long serialVersionUID = 1L;
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {
		log.info("Mensagem recebida pelo filho: " + msg);
	}

}