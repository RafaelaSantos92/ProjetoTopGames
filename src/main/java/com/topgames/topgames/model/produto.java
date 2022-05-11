package com.topgames.topgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String marca;
	
	@NotNull
	private String preco;
	
	
	private String idadeRecomendada;
	
	
	private String numeroDeJogadores;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;


	


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getIdadeRecomendada() {
		return idadeRecomendada;
	}

	public void setIdadeRecomendada(String idadeRecomendada) {
		this.idadeRecomendada = idadeRecomendada;
	}

	public String getNumeroDeJogadores() {
		return numeroDeJogadores;
	}

	public void setNumeroDeJogadores(String numeroDeJogadores) {
		this.numeroDeJogadores = numeroDeJogadores;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
