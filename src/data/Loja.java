package data;

import java.util.ArrayList;

/** Representa a Loja
 * @version 1.0
 * @since 1.0
 */
public class Loja {

    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    /** Construtor sem lista de produtos
     * @param nome
     * @param endereco
     * @param bairro
     * @param cidade
     * @param estado
     */
    public Loja(String nome, String endereco, String bairro, String cidade, String estado) { 
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    /** Construtor com uma lista de produtos já definida
     * @param nome
     * @param endereco
     * @param bairro
     * @param cidade
     * @param estado
     * @param produtos
     */
    public Loja(String nome, String endereco, String bairro, String cidade, String estado, ArrayList<Produto> produtos) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.produtos = produtos;
    }

    /**
     * @return
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * @return
     */
    public ArrayList<Produto> getProdutos(){
        return produtos;
    }
    
    /**
     * @param prod
     */
    public void setProdutos(ArrayList<Produto> prod){
        this.produtos = prod;
    }
}
