package pdv_willy;

import pdv_willy.model.Categoria;
import pdv_willy.model.Produto;
import pdv_willy.repository.CategoriaCollectionRepository;
import pdv_willy.repository.ProdutoCollectionRepository;
import pdv_willy.view.CategoriaView;
import pdv_willy.view.Opcao;
import pdv_willy.view.OpcaoView;
import pdv_willy.view.ProdutoView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Opcao opcao = null;

        do {
            opcao = OpcaoView.select();
            switch (opcao) {

                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_SISTEMA -> encerrarOSistema();
            }
        } while (opcao != Opcao.ENCERRAR_SISTEMA);


    }

    private static void alterarProduto() {
        Produto produto = ProdutoView.select(null);
        ProdutoView.update(produto);
    }

    private static void encerrarOSistema() {
        System.exit(0);
    }

    private static void consultarProdutoPorCategoria() {
        Categoria categoria = CategoriaView.select(null);

        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);

        if (produtos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não encontramos produtos com a categoria: " + categoria.getNome());

        }
        else{
            produtos.forEach(ProdutoView::show);
            produtos.forEach(System.out::println);
        }

    }

    private static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form(new Categoria());
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
    }

    private static void cadastrarProduto() {
        Produto produto = ProdutoView.form(new Produto());
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
    }

    private static void consultarProdutoPorId() {

    }
}



