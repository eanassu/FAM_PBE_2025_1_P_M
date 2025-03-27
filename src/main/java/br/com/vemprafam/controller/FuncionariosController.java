package br.com.vemprafam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vemprafam.dao.DaoFuncionario;
import br.com.vemprafam.pojo.Funcionario;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

	private DaoFuncionario dao = new DaoFuncionario();

	@GetMapping
	public String showHomeFuncionarios(Model model) {
		return "funcionarios";
	}
	@GetMapping("/")
	public String showHomeFuncionariosBarra(Model model) {
		return "funcionarios";
	}
	@GetMapping("/new")
	public String showFuncionariosForm(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "create-funcionario";
	}
	@PostMapping
	public String insert(@ModelAttribute Funcionario funcionario) {
		dao.insert(funcionario);
		return "redirect:funcionarios";
	}

}
