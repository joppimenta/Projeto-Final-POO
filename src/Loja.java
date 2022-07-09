import exceptions.ProdutoJaExistente;
import exceptions.ProdutoNaoExistente;

import java.util.ArrayList;
import java.util.Objects;

public class Loja {

    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    ArrayList<Produto> produtos = new ArrayList<Produto>();

    private String id;

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

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    boolean existeProduto(String id){ //Função para procurar determinado produto dentro da ArrayList. Função criada a fim de reutilizar código
        boolean achou = false;
        for(Produto p: produtos){
            if(p.getId() == id){
                achou = true;
                break;
            }
        }
        return achou;
    }


    void inserir(Produto produto) throws ProdutoJaExistente {
        if(existeProduto(produto.getId())){
            throw new ProdutoJaExistente(); //Se o produto já existir, ele levanta exceção
        }
        else {
            produtos.add(produto);
        }
    }

    void excluir(Produto produto) throws ProdutoNaoExistente {
        if(!existeProduto(produto.getId())){
            throw new ProdutoNaoExistente(); //Se o produto especificado não existir dentro da ArrayList, ele levanta exceção
        }
        else {
            produtos.remove(produto);
        }
    }

    void alterar(Produto produto) throws ProdutoNaoExistente{
        boolean achou = false;
        for(Produto p: produtos){
            if(p.getNome().equals(produto.getNome())){ //O parametro para o produto ser alterado é o nome do produto.
                achou = true;
                p = produto;
                break;
            }
        }
        if(!achou){
            throw new ProdutoNaoExistente();
        }
    }

    Produto consultar(Produto produto) throws ProdutoNaoExistente{
        if(existeProduto(produto.getId())){
            return produto;
        }
        else{
            throw new ProdutoNaoExistente();
        }
    }

}
