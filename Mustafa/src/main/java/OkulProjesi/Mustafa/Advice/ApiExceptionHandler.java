package OkulProjesi.Mustafa.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public final ResponseEntity<ExceptionResponse> exception1(Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse=new ExceptionResponse(LocalDateTime.now(),"200",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
