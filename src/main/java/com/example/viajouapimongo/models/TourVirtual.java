package com.example.viajouapimongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Schema(description = "Modelo que representa um Tour Virtual")
@Document(collection = "tour-virtual")
public class TourVirtual {

    @Schema(description = "Título do tour virtual", example = "Entrada")
    private String titulo;

    @Schema(description = "ID da atração associada ao tour", example = "123")
    private int idAtracao;

    @Schema(description = "Descrição do tour virtual", example = "Evento cultural com apresentações únicas...")
    private String descricao;

    @Schema(description = "Média de classificação do tour", example = "4.5")
    private double mediaClassificacao;

    @Schema(description = "ID da figurinha associada ao tour", example = "456")
    private int idFigurinha;

    @Schema(description = "Preço do tour virtual", example = "29.99")
    private double preco;

    @Schema(description = "Tamanho da quantidade de conteudos que o tour possui", example = "3")
    private int tamanho;

    @Schema(description = "Conteúdo do tour virtual", example = "Conteúdo de imagens e descrições")
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
