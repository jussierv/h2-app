package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente() {
		super();
	}
	
	
	public Cliente(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Cliente(String nome) {
		super();
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", getId()=" + getId() + ", getNome()=" + getNome() + "]";
	}
	
	
	
	
	
	
}
