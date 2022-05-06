package com.topgames.topgames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class categoria {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@NotNull
	public String jogosEletronicos;
	
	@NotNull
	public String jogosTabuleiro;
	
	@NotNull
	public String cartas;
	
	@NotNull
	public String brinquedos;
	
	@NotNull
	public String acessorios;
	
	@OneToMany(mappedBy = "categoria" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<produto> produto;	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJogosEletronicos() {
		return jogosEletronicos;
	}

	public void setJogosEletronicos(String jogosEletronicos) {
		this.jogosEletronicos = jogosEletronicos;
	}

	public String getJogosTabuleiro() {
		return jogosTabuleiro;
	}

	public void setJogosTabuleiro(String jogosTabuleiro) {
		this.jogosTabuleiro = jogosTabuleiro;
	}

	public String getCartas() {
		return cartas;
	}

	public void setCartas(String cartas) {
		cartas = cartas;
	}

	public String getBrinquedos() {
		return brinquedos;
	}

	public void setBrinquedos(String brinquedos) {
		brinquedos = brinquedos;
	}

	public String getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(String acessorios) {
		acessorios = acessorios;
	}

	public List<produto> getProduto() {
		return produto;
	}

	public void setProduto(List<produto> produto) {
		this.produto = produto;
	}


	

}
