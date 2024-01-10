package com.jar.transactionmanager.objects.requests;

import com.jar.transactionmanager.objects.constants.StringConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:21 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecordTransactionRequest {
    Double amount;
    @ApiModelProperty(example = StringConstants.TRANSACTION_TYPE_DEFAULT_VALUE) String transactionType;
    @ApiModelProperty(example = StringConstants.CURRENCY_DEFAULT_VALUE) String currency;
}
