package com.example.viajouapimongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Schema(description = "Modelo que representa um tour virtual")
@Document(collection = "tour-virtual")
public class TourVirtual {

    @Id
    @Field("_id")
    @Schema(description = "ID único da imagem", example = "671177e7ff3af8c28bed7ea6")
    private String id;

    @Field("id_turismo")
    @Schema(description = "ID do ponto turistico associado ao tour", example = "123")
    private int idTurismo;

    @Field("media_classificacao")
    @Schema(description = "Média de classificação do tour", example = "4.5")
    private double mediaClassificacao;

    @Field("id_figurinha")
    @Schema(description = "ID da figurinha associada ao tour", example = "456")
    private String idFigurinha;

    @Schema(description = "Preço do tour virtual", example = "29.99")
    private double preco;

    @Schema(description = "Tamanho da quantidade de conteudos que o tour possui", example = "3")
    private int tamanho;

    @Schema(description = "Conteúdo do tour virtual", example = "Conteúdo de imagens e descrições")
    private List<Conteudo> conteudo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdTurismo() {
        return idTurismo;
    }

    public void setIdTurismo(int idTurismo) {
        this.idTurismo = idTurismo;
    }

    public double getMediaClassificacao() {
        return mediaClassificacao;
    }

    public void setMediaClassificacao(double mediaClassificacao) {
        this.mediaClassificacao = mediaClassificacao;
    }

    public String getIdFigurinha() {
        return idFigurinha;
    }

    public void setIdFigurinha(String idFigurinha) {
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
