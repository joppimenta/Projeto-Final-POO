public class Produto {

    private String nome;
    private int quantidadeEmEstoque;
    private double preco;

    public Produto(String nome, int quantidadeEmEstoque, double preco) {
        this.nome = nome;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
