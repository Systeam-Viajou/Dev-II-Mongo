package com.example.viajouapimongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Schema(description = "Modelo que representa uma Imagem")
@Document(collection = "imagem")
public class Imagem {

    @Id
    @Field("_id")
    @Schema(description = "ID único da imagem", example = "671177e7ff3af8c28bed7ea6")
    private String id;

    @Schema(description = "URL da imagem", example = "http://example.com/image.jpg")
    private String url;

    @Field("id_atracao")
    @Schema(description = "ID da atração associada a imagem", example = "123")
    private Long idAtracao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(Long idAtracao) {
        this.idAtracao = idAtracao;
    }
}
