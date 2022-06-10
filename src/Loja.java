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

    ///Levantar exceção produtoJaExistente
    void incluirProduto(Produto produto) throws ProdutoJaExistente {
        for(Produto p: produtos){
            if(p == produto){
                throw new ProdutoJaExistente();
            }
            else {
                produtos.add(produto);
            }
        }
    }

    void excluirProduto(Produto produto) throws ProdutoNaoExistente {

        boolean achou = false;

        for(Produto p: produtos){ //Varrer a lista para encontrar o produto passado no parâmetro
            if(p == produto){
                achou = true;
                break;
            }
        }

        if(achou){
            produtos.remove(produto);
        }
        else {
            throw new ProdutoNaoExistente();
        }
    }

    void alterarProduto(){

    }

}
