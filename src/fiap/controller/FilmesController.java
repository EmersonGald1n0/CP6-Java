package fiap.controller;

import java.sql.*;
import java.util.*;

import fiap.model.*;

public class FilmesController {

	public String insereFilmes(String codigo, String titulo, String genero, String produtora) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FilmesDAO fd = new FilmesDAO(con);
		Filmes filmes = new Filmes();
		filmes.setCodigo(codigo);
		filmes.setTitulo(titulo);
		filmes.setGenero(genero);
		filmes.setProdutora(produtora);
		resultado = fd.inserir(filmes);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String alteraFilmes(String codigo, String titulo, String genero, String produtora) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FilmesDAO fd = new FilmesDAO(con);
		Filmes filmes = new Filmes();
		filmes.setCodigo(codigo);
		filmes.setTitulo(titulo);
		filmes.setGenero(genero);
		filmes.setProdutora(produtora);
		resultado = fd.alterar(filmes);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String excluiFilmes(String codigo) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		FilmesDAO fd = new FilmesDAO(con);
		Filmes fil = new Filmes();
		fil.setCodigo(codigo);
		resultado = fd.excluir(fil);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public ArrayList<String> listaFilmes(String codigo) {
		ArrayList<String> resultado = new ArrayList<String>();
		Connection con = Conexao.abrirConexao();
		FilmesDAO fd = new FilmesDAO(con);
		resultado = fd.listarFilmes(codigo);
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}

}