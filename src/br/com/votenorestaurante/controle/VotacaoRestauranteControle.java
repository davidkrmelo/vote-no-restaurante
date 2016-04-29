package br.com.votenorestaurante.controle;

import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.votenorestaurante.facade.VotacaoFacade;
import br.com.votenorestaurante.facade.VotacaoRestauranteFacade;
import br.com.votenorestaurante.modelo.Restaurante;
import br.com.votenorestaurante.modelo.Usuario;

@Controller
public class VotacaoRestauranteControle {
	
	private VotacaoFacade votacaoFacade = new VotacaoRestauranteFacade();
	
	@RequestMapping("/")
	public ModelAndView inicio() {
		if ((this.votacaoFacade.getConfrontos() == null) || (this.votacaoFacade.getConfrontos().isEmpty())) {
			this.votacaoFacade.carregarCandidatos();
		}
		ModelAndView mv = new ModelAndView("index");
		atualizaConfrontoMV(mv);
		return mv;
	}
	
	@RequestMapping("/votar")
	public ModelAndView votar(int id) {
		this.votacaoFacade.votar(id);
		if (this.votacaoFacade.getConfrontoAtual() == null) {
			return new ModelAndView("novousuario");
		}
		ModelAndView mv = new ModelAndView("index");
		atualizaConfrontoMV(mv);
		return mv;
	}
	
	@RequestMapping("/criarusuario")
	public ModelAndView criarUsuario(Usuario usuario) {
		this.votacaoFacade.salvarVotacao(usuario);
		ModelAndView mv = new ModelAndView("listarrestaurantes");
		mv.addObject("lista", this.votacaoFacade.buscarMaisVotados());
		return mv;
	}
	
	private void atualizaConfrontoMV(ModelAndView mv) {
		Restaurante r1 = (Restaurante) this.votacaoFacade.getConfrontoAtual().getC1();
		Restaurante r2 = (Restaurante) this.votacaoFacade.getConfrontoAtual().getC2();
		String logoR1 = "data:image/png;base64," + Base64.getEncoder().encodeToString(r1.getLogo());
		String logoR2 = "data:image/png;base64," + Base64.getEncoder().encodeToString(r2.getLogo());
		mv.addObject("restaurante1", r1);
		mv.addObject("restaurante2", r2);
		mv.addObject("logoR1", logoR1);
		mv.addObject("logoR2", logoR2);
	}
}
