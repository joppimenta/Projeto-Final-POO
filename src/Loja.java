import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;

import java.util.ArrayList;

public class Loja {

    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    ArrayList<Produto> produtos = new ArrayList<Produto>();

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

    boolean procurarProduto(Produto produto){ //Função para procurar determinado produto dentro da ArrayList. Função criada a fim de reutilizar código
        boolean achou = false;
        for(Produto p: produtos){
            if(p == produto){
                achou = true;
                break;
            }
        }
        return achou;
    }


    void incluirProduto(Produto produto) throws ProdutoJaExistente {
        if(procurarProduto(produto)){
            throw new ProdutoJaExistente(); //Se o produto já existir, ele levanta exceção
        }
        else {
            produtos.add(produto);
        }
    }

    void excluirProduto(Produto produto) throws ProdutoNaoExistente {
        if(!procurarProduto(produto)){
            throw new ProdutoNaoExistente(); //Se o produto especificado não existir dentro da ArrayList, ele levanta exceção
        }
        else {
            produtos.remove(produto);
        }
    }

    void alterarProduto(Produto produto) throws ProdutoNaoExistente{
        boolean achou = false;
        for(Produto p: produtos){
            if(p.getNome() == produto.getNome()){ //O parametro para o produto ser alterado é o nome do produto.
                p = produto;
                break;
            }
        }
        if(!achou){
            throw new ProdutoNaoExistente();
        }
    }

    Produto consultarProduto(String nomeProduto) throws ProdutoNaoExistente{
        boolean achou = false;
        Produto produtoProcurado = null;
        for(Produto p: produtos){
            if(p.getNome() == nomeProduto){
                achou = true;
                produtoProcurado = p;
            }
        }
        if(achou){
            return produtoProcurado;
        }
        else {
            throw new ProdutoNaoExistente();
        }
    }

}
