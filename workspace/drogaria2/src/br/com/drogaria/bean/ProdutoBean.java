package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	private Produto produto;
	private ArrayList<Fabricante> comboFabricante;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fabricante> getComboFabricante() {
		return comboFabricante;
	}

	public void setComboFabricante(ArrayList<Fabricante> comboFabricante) {
		this.comboFabricante = comboFabricante;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public void carregarListagem() {

		try {

			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.lista();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {

		try {
			produto = new Produto();
			FabricanteDAO dao = new FabricanteDAO();
			comboFabricante = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());

		}
	}

	public void novo() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);

			itens = dao.lista();

			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void prepararEditar(){
		try {
			FabricanteDAO dao = new FabricanteDAO();
			comboFabricante = dao.listar();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	public void editar(){
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			
			itens = dao.lista();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso");
			
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
