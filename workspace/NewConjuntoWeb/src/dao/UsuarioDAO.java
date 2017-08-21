package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	// CONSULTAR USER
	public Usuario consultarUsuario(Usuario to) {
		String sqlSelect = "select usuario,senha from Login where usuario=?;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, to.getUsername());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setUsername(rs.getString(1));
					to.setPassword(rs.getString(2));
				} else {
					to.setUsername(null);
					to.setPassword(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	
	public boolean validarUsuario(Usuario to) {
		String sqlSelect = "select usuario,senha from Login where usuario=? and senha=?;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, to.getUsername());
			stm.setString(2, to.getPassword());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return false;
	}
}
