package com.getgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String dataLancamento;
	
	private String descricao;
	
	
	private byte[] photo;
	
	
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


	public String getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	
	public Jogos(Integer id, String nome, String dataLancamento, String descricao, byte[] photo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.descricao = descricao;
		this.photo = photo;
	}



}
