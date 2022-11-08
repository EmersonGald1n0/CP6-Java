package fiap.model;

import java.sql.*;
import java.util.*;

public class FilmesDAO implements IDAO {
	private Connection con;
	private Filmes filmes;

	public FilmesDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		filmes = (Filmes) obj;
		String sql = "insert into filmes(codigo,titulo,genero,produtora)";
		sql += " values(?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filmes.getCodigo());
			ps.setString(2, filmes.getTitulo());
			ps.setString(3, filmes.getGenero());
			ps.setString(4, filmes.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Object obj) {
		filmes = (Filmes) obj;
		String sql = "update filmes set titulo=?, genero=?, produtora=?";
		sql += " where codigo=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filmes.getTitulo());
			ps.setString(2, filmes.getGenero());
			ps.setString(3, filmes.getProdutora());
			ps.setString(4, filmes.getCodigo());

			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Object obj) {
		filmes = (Filmes) obj;
		String sql = "delete from filmes";
		sql += " where codigo=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filmes.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<String> listarFilmes(String id) {
		String sql = "select * from filmes";
		sql += " where codigo=?";
		ArrayList<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString(1));
				resul.add(rs.getString(2));
				resul.add(rs.getString(3));
				resul.add(rs.getString(4));
				return resul;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}
