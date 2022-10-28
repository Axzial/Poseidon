package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class CurvePointService extends CrudService<CurvePoint, Long> {

    @Getter
    private final CurvePointRepository repository;

    @Override
    public CurvePoint create(CurvePoint curvePoint) {
        curvePoint.setCreatedAt(Timestamp.from(Instant.now()));
        return super.create(curvePoint);
    }

}
