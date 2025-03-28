package br.com.vemprafam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vemprafam.dao.DaoAluno;
import br.com.vemprafam.pojo.Aluno;

@Controller
@RequestMapping("/alunos")
public class AlunosController {

	private DaoAluno dao = new DaoAluno();

	@GetMapping
	public String showHomeAlunos(Model model) {
		return "alunos";
	}

	@GetMapping("/")
	public String showHomeAlunosBarra(Model model) {
		return "alunos";
	}

	@GetMapping("/new")
	public String showInsertForm(Model model) {
		model.addAttribute("aluno",new Aluno());
		return "create-aluno";
	}

	@PostMapping
	public String createAluno(@ModelAttribute Aluno aluno) {
		dao.insert(aluno);
		return "redirect:alunos";
	}

	@GetMapping("/list")
	public String showAlunosList(Model model) {
		List<Aluno> lista = dao.getLista();
		model.addAttribute("alunos", lista);
		return "alunos-list";
	}
}
