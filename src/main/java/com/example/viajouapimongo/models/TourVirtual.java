package com.example.viajouapimongo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tour-virtual")
public class TourVirtual {
    private String titulo;
    private int idAtracao;
    private String descricao;
    private double mediaClassificacao;
    private int idFigurinha;
    private double preco;
    private int tamanho;
    private List<Conteudo> conteudo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(int idAtracao) {
        this.idAtracao = idAtracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getMediaClassificacao() {
        return mediaClassificacao;
    }

    public void setMediaClassificacao(double mediaClassificacao) {
        this.mediaClassificacao = mediaClassificacao;
    }

    public int getIdFigurinha() {
        return idFigurinha;
    }

    public void setIdFigurinha(int idFigurinha) {
        this.idFigurinha = idFigurinha;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public List<Conteudo> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<Conteudo> conteudo) {
        this.conteudo = conteudo;
    }
}

