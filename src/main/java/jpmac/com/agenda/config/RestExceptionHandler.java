package jpmac.com.agenda.config;

import jpmac.com.agenda.config.models.ApiError;
import jpmac.com.agenda.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ApiError> handleMissingServletRequestParameter(
            BusinessException ex) {
        String messageError = ex.getMessage();

        log.error("Erro de BusinessException: " + LocalDateTime.now() +  "  Message: " + messageError);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ApiError(001, messageError));
    }

}
