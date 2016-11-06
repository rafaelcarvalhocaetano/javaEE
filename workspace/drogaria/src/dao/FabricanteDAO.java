package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Fabricante;
import factory.ConexaoFactory;

public class FabricanteDAO {
	
	public void salvar(Fabricante f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getDescricao());
		
		comando.executeUpdate();
	}
	
	public void excluir(Fabricante f)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setLong(1, f.getCodigo());
		
		comando.executeUpdate();
	}
	public void editar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		
		comando.executeUpdate();
				
	}
	
	
	
	
	public static void main(String[] args) {
		
	/*
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAO 1");
		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAO 2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
			try {
				fdao.salvar(f1);
				fdao.salvar(f2);
				System.out.println("Salvo com sucesso");
			} catch (SQLException e) {
				System.out.println("N�o salvo....");
				e.printStackTrace();
			}
			
		Fabricante f1 = new Fabricante();
		f1.setCodigo(2L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(3L);
		
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.excluir(f1);
			fdao.excluir(f2);
			System.out.println("Sucesso....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro.....");
		}

	 	*/
		Fabricante f1 = new Fabricante();
		f1.setCodigo(5L);
		f1.setDescricao("DESCRICAO 3");
		
		
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.editar(f1);
			System.out.println("SUCESSO...");
		} catch (SQLException e) {
			System.out.println("Sem Conex�o....");
			e.printStackTrace();
			
		}
	}

}
