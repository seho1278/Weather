package zerobase.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 전역에 일처리
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 클라이언트에서 서버API 호출시 에러가 발생한다면
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Exception handleAllException() {
        System.out.println("error from GlobalExceptionHandler");
        // 예외처리를 위한 로직을 작성

        return new Exception();
    }
}
