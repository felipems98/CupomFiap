package br.com.fiap.Ocr.Dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ResponseDataDto {
    private int Id;
    private String isbn;
    private String titulo;
    private String autor;
    private BigDecimal preco;
    private String Descricao;
    private Date DataDePublicacao;

    //Isbn
    public String getIsbn() {
        return isbn;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
    public Date getDataDePublicacao() {
        return DataDePublicacao;
    }
    public void setDataDePublicacao(Date dataDePublicacao) {
        this.DataDePublicacao = dataDePublicacao;
    }
    public String getDescricao() {
        return Descricao;
    }
    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    //Preco
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal d) {
        this.preco = d;
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
