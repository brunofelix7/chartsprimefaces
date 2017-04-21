package br.unipe.chartsprimefaces.dao;

import java.util.List;
import br.unipe.chartsprimefaces.entity.User;

public interface UserDAO {
	
	void cadastrar(User usuario);
	
	void atualizar(User usuario);

	void remover(User usuario);
	
	void salvar(User usuario);
	
	User buscarPorId(Integer id);
	
	List<User> buscarTodos();
}
