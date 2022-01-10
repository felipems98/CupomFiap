package br.com.fiap.demo.Dto;

import java.math.BigDecimal;

public class LivroDto {
    private String isbn;
    private String titulo;
    private String autor;
    private BigDecimal preco;

    //Isbn
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    //Preco
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    //Autor
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    //Titulo
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
        

}
