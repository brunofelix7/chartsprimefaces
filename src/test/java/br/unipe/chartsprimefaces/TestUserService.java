package br.unipe.chartsprimefaces;

import java.util.List;
import org.junit.Test;
import br.unipe.chartsprimefaces.entity.User;
import br.unipe.chartsprimefaces.service.UserService;

public class TestUserService {

	@Test
	public void testCadastrar(){
		User usuario = new User("Bruno", "brunokim", "123");
		UserService usuarioSercice = new UserService();
		usuarioSercice.cadastrar(usuario);
	}
	
	@Test
	public void testAtualizar(){
		User usuario = new User("Bruno F.", "bK", "456");
		usuario.setId(1);
		UserService usuarioSercice = new UserService();
		usuarioSercice.atualizar(usuario);
	}
	
	@Test
	public void testRemover(){
		User usuario = new User();
		usuario.setId(1);		
		UserService usuarioSercice = new UserService();
		usuarioSercice.remover(usuario);
	}
	
	@Test
	public void testSalvar(){
		User usuario = new User("Bruh", "bruh321", "admin123");
		UserService usuarioSercice = new UserService();
		usuarioSercice.salvar(usuario);
	}
	
	@Test
	public void testBuscarPorId(){
		UserService usuarioSercice = new UserService();
		User usuario = usuarioSercice.buscarPorId(2);
		System.out.println(usuario);
	}
	
	@Test
	public void testBuscarTodos(){
		UserService usuarioSercice = new UserService();
		List<User> usuarios = usuarioSercice.buscarTodos();
		for(User usuario: usuarios){
			System.out.println(usuario);
		}
	
	}
	
}
