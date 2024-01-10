package com.jar.transactionmanager.objects.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 9:04 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RatesResponseHelper {
    @SerializedName("INR")
    public double iNR;

}
