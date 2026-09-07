package pdv_willy.view;

import pdv_willy.model.Categoria;
import pdv_willy.repository.CategoriaCollectionRepository;

import javax.swing.*;

public class CategoriaView {

    static CategoriaCollectionRepository repository;

    public static Categoria select(Categoria categoria) {
        // @formatter:off
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null, // componente pai. Como não temos será null
                "Selecione uma categoria",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // ícone
                repository.findAll().toArray(), // Número da opção
                categoria == null ? 1 : categoria);

        return ret;
        // @formatter:on
    }

    public void sucesso() {
        JOptionPane.showConfirmDialog(null, "Categoria foisalva com sucesso");
    }

    public void sucesso(Categoria categoria) {
        JOptionPane.showConfirmDialog(null, "Categoria " + categoria.getNome() + " foi salva com sucesso");
    }

    public static Categoria form(Categoria categoria) {
        String nome = JOptionPane.showInputDialog(null, "Informe o nome da categoria", categoria != null ? categoria.getNome() : "");
        return new Categoria(nome);
    }

}
