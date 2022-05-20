package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.repositories.TradeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TradeService extends CrudService<Trade> {
    @Getter
    private final TradeRepository repository;
}
