package com.jar.transactionmanager.objects.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 9:03 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ForexResponse {
    public boolean success;
    public String terms;
    public String privacy;
    public int timestamp;
    public LocalDateTime date;
    public String base;
    public RatesResponseHelper rates;
}


