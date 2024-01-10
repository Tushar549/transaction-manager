package com.jar.transactionmanager.objects.constants;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 1:16 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */
public enum ErrorCodes {
    INVALID_FROM_DATE("TM_001", "From-date should be in valid format (yyyy-MM-dd)"),
    INVALID_TO_DATE("TM_002", "To-date should be in valid format (yyyy-MM-dd)"),
    INVALID_MOBILE_NUMBER("TM_003", "Invalid Mobile Number"),
    INVALID_TRANSACTION_TYPE("TM_004", "Invalid Transaction Type, Either it could be CR or DR"),
    INVALID_CURRENCY("TM_005", "Invalid value of Currency, either it could be INR or USD"),
    INVALID_AMOUNT("TM_006", "Invalid value for Amount"),
    CURRENCY_CONVERTER_DOWN("TM_007", "Forex rates API down"),
    UNHANDLED_EXCEPTION("TM_999", "Something went wrong");

    private final String errorCode;
    private final String description;

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }


    ErrorCodes(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
}
