package com.jar.transactionmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:20 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApplicationException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
    private HttpStatus httpStatusCode;
}
