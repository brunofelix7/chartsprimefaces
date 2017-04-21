package br.unipe.chartsprimefaces.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unipe.chartsprimefaces.dao.ConnectionFactory;
import br.unipe.chartsprimefaces.dao.UserDAO;
import br.unipe.chartsprimefaces.entity.User;
import br.unipe.chartsprimefaces.model.UserQuerySQL;

public class UserService implements UserDAO{

	public Connection conn = ConnectionFactory.getConnection();

	@Override
	public void cadastrar(User usuario){
		try {
			PreparedStatement statement = conn.prepareStatement(UserQuerySQL.INSERT_SQL);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getSenha());
			statement.execute();
			statement.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(User usuario) {
		//	Faz o close pra mim
		try(PreparedStatement statement = conn.prepareStatement(UserQuerySQL.UPDATE_SQL);){
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getSenha());
			statement.setInt(4, usuario.getId());
			statement.execute();
			//	statement.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void remover(User usuario) {
		//	Faz o close pra mim
		try(PreparedStatement statement = conn.prepareStatement(UserQuerySQL.DELETE_SQL)){
			statement.setInt(1, usuario.getId());
			statement.execute();
			//	statement.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void salvar(User usuario){
		if(usuario.getId() != null && usuario.getId() > 0){
			atualizar(usuario);
		}else{
			cadastrar(usuario);
		}
	}
	
	@Override
	public User buscarPorId(Integer id){
		try(PreparedStatement statement = conn.prepareStatement(UserQuerySQL.SELECT_ONE_SQL)){
			statement.setInt(1, id);
			
			//	Traz o retorno da consulto em ResultSet
			ResultSet result = statement.executeQuery();
			
			//	Se tem registro...
			if(result.next()){
				//	Instancia objeto de retorno
				User usuario = new User();
				
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				usuario.setLogin(result.getString("login"));
				usuario.setSenha(result.getString("senha"));
				
				return usuario;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		//	Se não houver registros retorne nulo
		return null;
	}
	
	@Override
	public List<User> buscarTodos(){
		//	Lista de usuários
		List<User> usuarios = new ArrayList<User>();
		
		try(PreparedStatement statement = conn.prepareStatement(UserQuerySQL.SELECT_SQL)){
			
			//	Traz o retorno da consulto em ResultSet
			ResultSet result = statement.executeQuery();
			
			//	Enquanto houver registros...
			while(result.next()){
				//	Instancia objeto de retorno
				User usuario = new User();
				
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				usuarios.add(usuario);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		//	Retorna a lista de usuários
		return usuarios;
	}
	
}
