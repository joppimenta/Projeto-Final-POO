package data;

import java.util.ArrayList;

public class Loja {

    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Loja(String nome, String endereco, String bairro, String cidade, String estado) { //Construtor que não possui uma lista de produtos definida
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Loja(String nome, String endereco, String bairro, String cidade, String estado, ArrayList<Produto> produtos) { //Construtor que já recebe uma lista produtos definida
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public ArrayList<Produto> getProdutos(){
        return produtos;
    }
    
    public void setProdutos(ArrayList<Produto> prod){
        this.produtos = prod;
    }
}
