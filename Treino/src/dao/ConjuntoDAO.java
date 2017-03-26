package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Conjunto;

public class ConjuntoDAO {
	public void criar(Conjunto conjunto)
	{
		String sqlInsert = "INSERT INTO conjuto(statusOcupado,valor,tempoLocacao,medida,observacao) values (?,?,?,?,?);";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setBoolean(1, conjunto.isStatus());
			stm.setDouble(2, conjunto.getValor());
			stm.setDouble(3, conjunto.getTempoLocacao());
			stm.setDouble(4, conjunto.getMedida());
			stm.setString(5, conjunto.getObservacao());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Conjunto conjunto) {
		String sqlUpdate = "UPDATE conjunto SET statusOcupado=?, valor=?, tempoLocacao=?, medida=?,observacao=? WHERE idConjunto=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setBoolean(1, conjunto.isStatus());
			stm.setDouble(2, conjunto.getValor());
			stm.setDouble(3, conjunto.getTempoLocacao());
			stm.setDouble(4, conjunto.getMedida());
			stm.setString(5, conjunto.getObservacao());
			stm.setInt(6, conjunto.getIdConjunto());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM conjunto WHERE idConjunto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Conjunto carregar(int id) {
		Conjunto conjunto= new Conjunto();
		conjunto.setIdConjunto(id);
		String sqlSelect = "SELECT statusOcupado,valor,tempoLocacao,medida,observacao FROM conjunto WHERE conjunto.idConjunto = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conjunto.getIdConjunto());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					conjunto.setStatus(rs.getBoolean("statusOcupado"));
					conjunto.setValor(rs.getDouble("valor"));
					conjunto.setTempoLocacao(rs.getDouble("tempoLocacao"));
					conjunto.setMedida(rs.getDouble("medida"));
					conjunto.setObservacao(rs.getString("observacao"));
				} else {
					conjunto.setIdConjunto(-1);
					conjunto.setStatus(false);
					conjunto.setValor(0.0);
					conjunto.setTempoLocacao(0.0);
					conjunto.setMedida(0.0);
					conjunto.setObservacao(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return conjunto;
	}
}
