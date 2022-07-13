package data;

/** Representa o produto.
 * @version 1.1
 * @since 1.0
*/
public class Produto {

    private String nome;
    private int quantidadeEmEstoque;
    private double preco;

    /** Construtor de produto.
     * @param nome O nome do produto
     * @param quantidadeEmEstoque A quantidade em estoque 
     * @param preco O preço do produto 
    */
    public Produto(String nome, int quantidadeEmEstoque, double preco) {
        this.nome = nome;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preco = preco;
    }

    /**
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return
     */
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    /**
     * @param
     */
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    /**
     * @return
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
