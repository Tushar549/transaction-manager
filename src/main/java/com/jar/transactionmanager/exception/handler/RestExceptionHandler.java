package com.jar.transactionmanager.exception.handler;

import com.jar.transactionmanager.exception.ApplicationException;
import com.jar.transactionmanager.objects.GlobalApiResponse;
import com.jar.transactionmanager.objects.constants.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:20 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<GlobalApiResponse> handleApplicationException(ApplicationException applicationException) {
        return ResponseEntity
                .status(applicationException.getHttpStatusCode())
                .body(
                        GlobalApiResponse.builder()
                                .apiResponseCode(applicationException.getErrorCode())
                                .apiResponseMessage(applicationException.getErrorMessage())
                                .apiResponseBody(null)
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalApiResponse> handleGenericException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        GlobalApiResponse.builder()
                                .apiResponseCode(ErrorCodes.UNHANDLED_EXCEPTION.getErrorCode())
                                .apiResponseMessage(exception.getLocalizedMessage())
                                .apiResponseBody(null)
                                .build()
                );
    }


}