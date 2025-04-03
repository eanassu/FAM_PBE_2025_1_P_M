package br.com.vemprafam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vemprafam.dao.DaoAluno;
import br.com.vemprafam.pojo.Aluno;
import org.springframework.web.bind.annotation.RequestBody;


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

	@PostMapping("/insert")
	public String createAluno(@ModelAttribute Aluno aluno) {
		dao.insert(aluno);
		return "alunos";
	}

	@GetMapping("/list")
	public String showAlunosList(Model model) {
		List<Aluno> lista = dao.getLista();
		model.addAttribute("alunos", lista);
		return "alunos-list";
	}

	@GetMapping("/busca")
	public String showBuscaAluno(Model model) {
		model.addAttribute("aluno",new Aluno());
		return "busca-aluno";
	}

	@PostMapping("/showUpdate")
	public String showUpdateForm(@ModelAttribute Aluno aluno) {
		Aluno novo = dao.buscarPeloRa(aluno.getRa());
		aluno.setNome(novo.getNome());
		aluno.setDataNascimento(novo.getDataNascimento());
		aluno.setRenda(novo.getRenda());
		return "edit-aluno";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Aluno aluno) {
		dao.update(aluno);
		return "alunos";
	}

	@GetMapping("/showDelete")
	public String showDeleteForm(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		return "apaga-aluno";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute Aluno aluno) {
		dao.delete(aluno);
		return "alunos";
	}
}














