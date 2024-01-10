package com.jar.transactionmanager.objects.enums;

import lombok.Getter;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:22 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */
@Getter
public enum TransactionTypeEnum {
    CR("credit"), DR("debit");

    private final String type;

    TransactionTypeEnum(String type) {
        this.type = type;
    }
}
