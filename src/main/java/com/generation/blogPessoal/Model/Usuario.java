package com.generation.blogPessoal.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_usuarios")

public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="O atributo nome é obrigatório")
	private String nome;
	
	@NotBlank(message="O atributo usuário é obrigatório")
	@Email(message="O atributo usuário é um e-mail válido")
	private String usuario;
	
	@NotBlank(message="O atributo senha é obrigatório")
	@Size(min=8, message="A senha precisa conter no mínimo 8 caracteres")
	private String senha;
	
	@Size(max=5000, message="O link da foto não pode contem mais de 5000 caracteres")
	private String foto;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	
	//construtor com todos os atributos da classe
	//o criador automático cria o método inclusive com as anotações, isso pode ser retirado
	public Usuario(Long id, String nome, String usuario, String senha, String foto, List<Postagem> postagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.postagem = postagem;
	}
	
	//construtor vazio
	public Usuario() {
	}
	
	
	//getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	

}
