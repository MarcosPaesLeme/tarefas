package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;

import dao.ConnectionFactory;
import model.Conjunto;

public class ConjuntoDAO {



	// CADASTRAR CONJUNTO
	public void cadastrarConjunto(Conjunto to) {
		String sqlInsert = "insert into Conjunto(status_ocupado, valor, medida, tempo, obs) values(?, ?, ?, ?, ?);";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setBoolean(1, to.getStatus());
			stm.setDouble(2, to.getValor());
			stm.setDouble(3, to.getMedida());
			stm.setInt(4, to.getTempoLocacao());
			stm.setString(5, to.getObservacao());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// CONSULTAR CONJUNTO
	public Conjunto consultarConjunto(int id) {
		Conjunto to = new Conjunto();
		// to.setId_conjunto(id);
		String sqlSelect = "select status_ocupado, valor, medida, tempo, obs from conjunto where id_Conjunto = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setStatus(rs.getBoolean(1));
					to.setValor(rs.getDouble(2));
					to.setMedida(rs.getDouble(3));
					to.setTempoLocacao(rs.getInt(4));
					to.setObservacao(rs.getString(5));
				} else {
					to.setId_conjunto(-1);
					to.setStatus(false);
					to.setValor(0.0);
					to.setMedida(0.0);
					to.setTempoLocacao(0);
					to.setObservacao(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	// ALTERAR CONJUNTO
	public void alterarConjunto(Conjunto to) {
		String sqlUpdate = "UPDATE Conjunto set status_ocupado = ?, valor = ?, medida = ?, tempo = ?, obs = ? where id_Conjunto = ?; ";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(6, to.getId_conjunto());
			stm.setBoolean(1, to.getStatus());
			stm.setDouble(2, to.getValor());
			stm.setDouble(3, to.getMedida());
			stm.setInt(4, to.getTempoLocacao());
			stm.setString(5, to.getObservacao());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// EXCLUIR CONJUNTO
	public void excluirConjunto(Conjunto to) {
		String sqlDelete = "delete from conjunto where id_Conjunto = ?;";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId_conjunto());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// PEGA O ID DA EMPRESA
	public int id_Empresa(String cnpj, Conjunto to) {
		String sqlSelect = "select id_Empresa from Empresa where cnpj = ?";
		int id = 0;
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cnpj);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					// conjunto.setCNPJ(rs.getInt(1));
					id = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return id;
	}

	// -----INSERIR EMPRESA NO CONJUNTO
	public void inserirEmpresa(Conjunto to, String cnpj) {
		String sqlUpdate = "UPDATE Conjunto SET id_Empresa = (select id_Empresa from Empresa where cnpj = ?), status_ocupado = true where id_Conjunto =?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cnpj);
			stm.setInt(2, to.getId_conjunto());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// VERIFICA OCUPAÇÃO DO CONJUNTO
	public boolean ocupado(Conjunto to) {

		String sqlAsk = "Select status_ocupado from Conjunto where id_Conjunto = ?";
		boolean sucesso = false;
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlAsk);) {
			try (ResultSet rs = stm.executeQuery();) {
				stm.setInt(1, to.getId_conjunto());
				if (rs.next()) {
					sucesso = rs.getBoolean(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return sucesso;
	}

	// --- QTD DE ANDARES
	public int andares() {
		String sqlAsk = "SELECT COUNT(*) FROM Conjunto";
		int andares = 0;
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlAsk);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					// conjunto.setCNPJ(rs.getInt(1));
					andares = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return (andares / 2);
	}

	/// ----------RETORNA CONJUNTOS DA EMPRESA X
	public ArrayList<Integer> conjEmpresa(String cnpj) {
		String sqlAsk = "select id_Conjunto from Conjunto where id_Empresa = (select id_Empresa from Empresa where cnpj = ?)";
		ArrayList<Integer> conjuntos = new ArrayList<Integer>();
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlAsk);) {
			stm.setString(1, cnpj);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					// conjunto.setCNPJ(rs.getInt(1));
					conjuntos.add(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return conjuntos;
	}

	// ---EXCLUI EMPRESA DO CONJUNTO
	public void excluiConj(Conjunto to) {
		String sqlUpdate = "UPDATE Conjunto SET id_Empresa = null, status_ocupado = false where id_Conjunto = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getId_conjunto());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ----------RETORNA O NOME DA EMPRESA QUE OCUPA O CONJUNTO
	public String nomeEmpresa(Conjunto to) {
		String nomeEmpresa = "";
		String sqlSelect = "Select nome from Empresa where id_Empresa = (select id_empresa from Conjunto where id_conjunto = ?)";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				stm.setInt(1, to.getId_conjunto());
				if (rs.next()) {
					nomeEmpresa = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());

		}

		return nomeEmpresa;
	}

}
