package com.example.viajouapimongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Schema(description = "Modelo que representa o progresso do usuário no tour virtual")
@Document(collection = "tour-usuario")
public class TourUsuario {

    @Id
    @Field("_id")
    @Schema(description = "ID único da imagem", example = "671177e7ff3af8c28bed7ea6")
    private String id;

    @Field("id_usuario")
    @Schema(description = "ID do usuário", example = "dmg0eT7l7BPD2RkXKIXEM06ihUs1")
    private String idUsuario;

    @Field("id_tour")
    @Schema(description = "ID da do tour que o usuário começou", example = "67210522e68fe38d58ca6b96")
    private String idTour;

    @Field("prosicao_atual")
    @Schema(description = "Em qual tela do tour virtual que o usuário esta no momento ", example = "2")
    private int prosicaoAtual;

    @Schema(description = "Porcentagem de quanto foi o progresso da pessoa nesse tour", example = "50")
    private String progresso;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
    }

    public int getProsicaoAtual() {
        return prosicaoAtual;
    }

    public void setProsicaoAtual(int prosicaoAtual) {
        this.prosicaoAtual = prosicaoAtual;
    }

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }
}
