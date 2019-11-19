package akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import atores.EcoActor;
import modelos.MensagemAkka;

public class Start {
		
	// O actor system é o ponto de partida de toda aplicação, por isso, deve ser criado assim que ela iniciar
	public static void main(String[] args) {
		
		// a string aqui deve ser única por aplicação e também deve ser único por container
		ActorSystem sistema = ActorSystem.create("OiMundo");
		
		
		// Criando o ator EcoActor
		//É importante perceber que o que obtemos ao criar um ator é um ActorRef 
		//e não um objeto com a classe do ator propriamente dita (EcoActor).
		//Motivo: atores e suas propriedades devem ser IMUTÁVEIS
	    ActorRef ator = sistema.actorOf(Props.create(EcoActor.class), "eco");

	    // Enviando a mensagem ao ator
	    //como não é um ator enviando a mensagem, passamos o noSender().
	    ator.tell(new MensagemAkka(), ActorRef.noSender());
	    
	}
	
}
