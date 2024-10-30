package com.example.viajouapimongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Schema(description = "Modelo que representa uma figurinha")
@Document(collection = "figurinha")
public class Figurinha {

    @Id
    @Field("_id")
    @Schema(description = "ID único da figurinha", example = "671177e7ff3af8c28bed7ea6")
    private String id;

    @Schema(description = "URL da imagem da figurinha", example = "http://example.com/image.jpg")
    @Field("url_imagem")
    private String urlImagem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
