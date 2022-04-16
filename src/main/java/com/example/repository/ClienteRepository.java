package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.entity.Cliente;


@Repository
public class ClienteRepository {
	
	private static String SELECT_ALL = "select * from cliente ";
	private static String UPDATE = "update cliente set nome = ? where id = ?";
	private static String DELETE = "delete from cliente where id = ?";

	
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}
	
	public Cliente atualizar(Cliente cliente) {
		jdbcTemplate.update(UPDATE, new Object[] {cliente.getNome(), cliente.getId()});
		return cliente;
	}
	
	public void deletar(Cliente cliente) {
		deletar(cliente.getId());
	}
	
	public void deletar(Integer id) {
		jdbcTemplate.update(DELETE, new Object[] {id});
	}
	
	@SuppressWarnings("deprecation")
	public List<Cliente> getNome(String nome) {
		return jdbcTemplate.query(SELECT_ALL.concat("where nome like ? "), 
								  new Object[] { "%" + nome + "%" },
								  getClienteMapper());
	}
	
	public List<Cliente> getAll(){
		
		return jdbcTemplate.query(SELECT_ALL, getClienteMapper());	
	}

	
	private RowMapper<Cliente> getClienteMapper() {
		return new RowMapper<Cliente>() {
			
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException{
				return new Cliente(resultSet.getInt("id"), resultSet.getString("nome"));
			}
			
			
		};
	}
}
