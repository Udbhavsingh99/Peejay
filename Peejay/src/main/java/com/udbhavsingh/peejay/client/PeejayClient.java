package com.udbhavsingh.peejay.client;

import com.udbhavsingh.peejay.model.PeejayJokeResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface PeejayClient {

    @GetExchange("/")
    PeejayJokeResponse random();

}
