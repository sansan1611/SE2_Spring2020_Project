package com.hanu.domain.usecase;

import com.hanu.base.RequestHandler;
import com.hanu.domain.model.Record;
import com.hanu.domain.repository.RecordRepository;
import com.hanu.exception.InvalidQueryTypeException;
import com.hanu.util.di.Inject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetRecordByContinentUseCase implements RequestHandler<String, List<Record>> {

    @Inject
    private RecordRepository repository;

    @Override
    public List<Record> handle(String continent) {
        try {
            return repository.getRecordByContinent(continent);
        } catch (SQLException | InvalidQueryTypeException e) {
            return new ArrayList<>();
        }
    }

}
