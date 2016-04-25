package br.com.votenorestaurante.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.votenorestaurante.facade.VotacaoFacade;
import br.com.votenorestaurante.facade.VotacaoRestauranteFacade;
import br.com.votenorestaurante.modelo.Confronto;
import br.com.votenorestaurante.modelo.Restaurante;

@Controller
public class VotacaoRestauranteControle {
	
	private VotacaoFacade votacaoFacade = new VotacaoRestauranteFacade();

	@RequestMapping("/")
	public ModelAndView inicio() {
		System.out.println("metodo inicio");
		if (this.votacaoFacade.getConfrontos() == null) {
			this.votacaoFacade.carregarCandidatos();
		}
		if (this.votacaoFacade.getConfrontoAtual() == null) {
			return new ModelAndView("/votacaofinalizada");
		}
		ModelAndView mv = new ModelAndView("index");
		atualizaConfrontoMV(mv);
		return mv;
	}
	
	@RequestMapping("/votar")
	public ModelAndView votar(int id) {
		this.votacaoFacade.votar(id);
		ModelAndView mv = new ModelAndView("index");
		atualizaConfrontoMV(mv);
		return mv;
	}
	
	private void atualizaConfrontoMV(ModelAndView mv) {
		mv.addObject("restaurante1", this.votacaoFacade.getConfrontoAtual().getC1());
		mv.addObject("restaurante2", this.votacaoFacade.getConfrontoAtual().getC2());
	}
}
