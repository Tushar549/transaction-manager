package com.jar.transactionmanager.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:51 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GlobalApiResponse {
    private String apiResponseCode;
    private String apiResponseMessage;
    private Object apiResponseBody;
}
