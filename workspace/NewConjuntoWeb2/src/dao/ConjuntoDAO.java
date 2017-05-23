package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

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
		String sqlSelect = "select id_Conjunto, status_ocupado, valor, medida, tempo, obs from conjunto where id_Conjunto = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId_conjunto(rs.getInt(1));
					to.setStatus(rs.getBoolean(2));
					to.setValor(rs.getDouble(3));
					to.setMedida(rs.getDouble(4));
					to.setTempoLocacao(rs.getInt(5));
					to.setObservacao(rs.getString(6));
				} else {
					to.setId_conjunto(-1);
					to.setStatus(false);
					to.setValor(0.0);
					to.setMedida(0.0);
					to.setTempoLocacao(0);
					to.setObservacao("Conjunto não encontrado!");
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
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
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
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId_conjunto());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// PEGAR ULTIMO ID INSERIDO
	public int consultarNumero() {
		int id = 0;
		// to.setId_conjunto(id);
		String sqlSelect = "SELECT id_Conjunto FROM Conjunto ORDER BY id_Conjunto DESC LIMIT 1;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
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

	// CONSULTA TODOS OS CONJUNTOS
	public ArrayList<Conjunto> listarConjuntos() {
		Conjunto conjunto;
		ArrayList<Conjunto> lista = new ArrayList<>();
		String sqlSelect = "select * from Conjunto;";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					conjunto = new Conjunto();
					conjunto.setId_conjunto(rs.getInt("id_Conjunto"));
					conjunto.setMedida(rs.getDouble("medida"));
					conjunto.setObservacao(rs.getString("obs"));
					conjunto.setStatus(rs.getBoolean("status_ocupado"));
					conjunto.setValor(rs.getDouble("valor"));
					lista.add(conjunto);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	
	
	//CONSULTA APENAS UM CONJUNTO
	public Conjunto listarConjunto(String chave) {
		Conjunto to = new Conjunto();
		
		String sqlSelect = "select id_Conjunto, status_ocupado, valor, medida, tempo, obs from conjunto where id_Conjunto = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, Integer.parseInt(chave));
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId_conjunto(rs.getInt(1));
					to.setStatus(rs.getBoolean(2));
					to.setValor(rs.getDouble(3));
					to.setMedida(rs.getDouble(4));
					to.setTempoLocacao(rs.getInt(5));
					to.setObservacao(rs.getString(6));
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
}
