package br.com.unipe.bean;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AgendaPhaseListener implements PhaseListener{


	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("Depois de " + arg0.getPhaseId());		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("Antes de " + arg0.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
