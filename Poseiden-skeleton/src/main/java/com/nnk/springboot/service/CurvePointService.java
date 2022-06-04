package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.CurvePointRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CurvePointService extends CrudService<CurvePoint> {
    @Getter
    private final CurvePointRepository repository;
}
