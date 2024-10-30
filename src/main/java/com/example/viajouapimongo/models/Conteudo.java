package com.example.viajouapimongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Field;

@Schema(description = "Modelo que representa o conteúdo de um tour virtual")
public class Conteudo {

    @Schema(description = "Título de cada conteúdo", example = "Entrada")
    private String titulo;

    @Schema(description = "Posição do conteúdo na sequência", example = "1")
    private int posicao;

    @Schema(description = "Descrição do conteúdo", example = "Descubra as apresentações culturais únicas através de nosso tour virtual...")
    private String descricao;

    @Field("url_imagem")
    @Schema(description = "URL da imagem associada ao conteúdo", example = "http://example.com/image.jpg")
    private String urlImagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
