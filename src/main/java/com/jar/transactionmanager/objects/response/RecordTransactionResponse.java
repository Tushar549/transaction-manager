package com.jar.transactionmanager.objects.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 3:05 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Getter
@Setter
@Builder
public class RecordTransactionResponse {
    Boolean isStored;
}
