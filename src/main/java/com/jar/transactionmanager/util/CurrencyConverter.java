package com.jar.transactionmanager.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jar.transactionmanager.exception.ApplicationException;
import com.jar.transactionmanager.objects.constants.ErrorCodes;
import com.jar.transactionmanager.objects.enums.CurrencyEnum;
import com.jar.transactionmanager.objects.response.ForexResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 6:53 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Component
public class CurrencyConverter {

    @Value("${fxratesapi.url}")
    String fxratesapiUrl;

    Logger logger = Logger.getLogger(CurrencyConverter.class.getCanonicalName());

    public Double convertBeforeSaving(CurrencyEnum currency, Double amount){
        Double finalAmount = amount;
        if (Objects.requireNonNull(currency) == CurrencyEnum.USD) {
            Double usdToInrValue = getUSDToINRValue();
            finalAmount = convertUSDToINR(amount, usdToInrValue);
        }
        return finalAmount;
    }

    public Double convertUSDToINR(Double amount, Double usdToInrValue){
        return (usdToInrValue * amount);
    }

    public Double convertINRToUSD(Double amount, Double usdToInrValue){
        return (amount / usdToInrValue);
    }

    public Double getUSDToINRValue(){
        logger.info("sending request to get USD values in different currency");
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response
                    = restTemplate.getForEntity(fxratesapiUrl, String.class);
            logger.info("Response received from fxrateApi : " + response.getBody());
            Gson gson = new Gson();
            String usdToInrResponse = gson.fromJson(gson.toJson(gson.fromJson(response.getBody(), HashMap.class).get("rates")), HashMap.class).get("INR").toString();
            return Double.valueOf(usdToInrResponse);
        }catch (Exception exception){
            throw ApplicationException
                    .builder()
                    .errorCode(ErrorCodes.CURRENCY_CONVERTER_DOWN.getErrorCode())
                    .errorMessage(ErrorCodes.CURRENCY_CONVERTER_DOWN.getDescription())
                    .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}