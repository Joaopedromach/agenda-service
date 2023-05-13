package agenda.com.agenda.config.models;

import lombok.Data;

@Data
public class ApiError {
    private Integer codigo;
    private String message;

    public ApiError(Integer codigo, String message) {
        this.codigo = codigo;
        this.message = message;
    }

    public ApiError(){

    }
}
