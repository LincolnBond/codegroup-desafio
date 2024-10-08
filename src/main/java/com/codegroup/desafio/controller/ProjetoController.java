package com.codegroup.desafio.controller;

import com.codegroup.desafio.Constantes;
import com.codegroup.desafio.exception.ExclusionNotAllowedException;
import com.codegroup.desafio.exception.ResourceNotFoundException;
import com.codegroup.desafio.model.Pessoa;
import com.codegroup.desafio.model.Projeto;
import com.codegroup.desafio.service.PessoaService;
import com.codegroup.desafio.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Classe responsável pelo CRUD dos Projetos padrão MVC
 */
@Controller
public class ProjetoController {

	@Autowired
	ProjetoService projetoService;

	@Autowired
	PessoaService pessoaService;

	@GetMapping({"/","listaProjetos"})
	public String listaProjetos(Model model, @ModelAttribute("message") String message) {
		List<Projeto> projetos = this.projetoService.findAll();
		model.addAttribute("projetos", projetos);
		return "listaProjetos";
	}

	@GetMapping("/createProjeto")
	public String createProjeto(Model model) {
		model.addAttribute("projeto", new Projeto());

		List<Pessoa> pessoas = this.pessoaService.findAll();
		model.addAttribute("pessoas", pessoas);
		return "createProjeto";
	}

	@PostMapping("/saveProjeto")
	public String saveProjeto(Projeto projeto, RedirectAttributes redirectAttributes) {
		try {
			projetoService.saveProjeto(projeto);
			redirectAttributes.addFlashAttribute("status", Constantes.SUCESSO);
			redirectAttributes.addFlashAttribute("mensagem", Constantes.PROJETO_CRIADO);
			return "redirect:/listaProjetos";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("status", Constantes.ERRO);
			redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
			e.printStackTrace();
			return "createProjeto";
		}
	}

	@GetMapping("/editarProjeto/{id}")
	public String editarProjeto(@PathVariable Long id,Model model, RedirectAttributes redirectAttributes) {

		try {
			Projeto projeto = projetoService.findById(id);
			model.addAttribute("projeto",projeto);
			List<Pessoa> pessoas = this.pessoaService.findAll();
			model.addAttribute("pessoas", pessoas);
		} catch (ResourceNotFoundException e) {
			redirectAttributes.addFlashAttribute("status", Constantes.ERRO);
			redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
			return "redirect:/listaProjetos";
		}

		return "editarProjeto";
	}

	@PostMapping("/updateProjeto")
	public String updateProjeto(Projeto projeto, RedirectAttributes redirectAttributes) {

		try{
			projetoService.updateProjeto(projeto.getId(), projeto) ;
			redirectAttributes.addFlashAttribute("status", Constantes.SUCESSO);
			redirectAttributes.addFlashAttribute("mensagem", Constantes.PROJETO_ALTERADO);
			return "redirect:/listaProjetos";
		} catch (ResourceNotFoundException e) {
			redirectAttributes.addFlashAttribute("status", Constantes.ERRO);
			redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
			e.printStackTrace();
			return "redirect:/editarProjeto/"+projeto.getId();
		}
	}

	@GetMapping("/deleteProjeto/{id}")
	public String deleteProjeto(@PathVariable Long id, RedirectAttributes redirectAttributes) {

		try{
			projetoService.deleteProjeto(id) ;
			redirectAttributes.addFlashAttribute("status", Constantes.SUCESSO);
			redirectAttributes.addFlashAttribute("mensagem", Constantes.PROJETO_EXCLUIDO);
		} catch (ResourceNotFoundException e) {
			redirectAttributes.addFlashAttribute("status", Constantes.ERRO);
			redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
			e.printStackTrace();
		}catch (ExclusionNotAllowedException e){
			redirectAttributes.addFlashAttribute("status", Constantes.ERRO);
			redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/listaProjetos";
	}
}
