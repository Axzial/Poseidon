package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.repositories.TradeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TradeService extends CrudService<Trade> {
    @Getter
    private final TradeRepository repository;
}
