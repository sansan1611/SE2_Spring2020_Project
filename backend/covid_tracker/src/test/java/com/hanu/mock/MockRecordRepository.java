package com.hanu.mock;

import com.hanu.db.util.AggregationType;
import com.hanu.db.util.FilterType;
import com.hanu.domain.model.Record;
import com.hanu.domain.repository.RecordRepository;
import com.hanu.exception.InvalidQueryTypeException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockRecordRepository implements RecordRepository {

    public static final Map<Integer, Record> records = new HashMap<Integer, Record>() {

        private static final long serialVersionUID = 5403964494677058636L;

        {
            put(1, new Record(1, new Timestamp(1), 1, 10, 0, 10));
            put(2, new Record(2, new Timestamp(1), 1, 10, 0, 10));
            put(3, new Record(3, new Timestamp(1), 1, 10, 0, 10));
            put(4, new Record(4, new Timestamp(1), 1, 10, 0, 10));
            put(5, new Record(5, new Timestamp(1), 1, 10, 0, 10));
        }
    };

    @Override
    public List<Record> getAll() {
        return records.values().stream().collect(Collectors.toList());
    }

    @Override
    public Record getById(Integer id) {
        return records.get(id);
    }

    @Override
    public int add(Record item) {
        records.put(item.getId(), item);
        return 0;
    }

    @Override
    public int add(List<Record> items) {
        items.forEach(itm -> {
            records.put(itm.getId(), itm);
        });
        return 0;
    }

    @Override
    public long count() {
        return records.size();
    }

    @Override
    public boolean exists(Integer id) {
        return records.containsKey(id);
    }

    @Override
    public List<Record> getAggregatedRecords(AggregationType type) {
        return records.values().stream().sorted((r1, r2) -> (new Integer(r1.getId()).compareTo(new Integer(r2.getId())))).collect(Collectors.toList());
    }

    @Override
    public int getPoiIdByName(String poiName) throws SQLException, InvalidQueryTypeException {
        return 0;
    }

    @Override
    public Timestamp getLatestTime() throws SQLException, InvalidQueryTypeException {

        return null;
    }

    @Override
    public int remove(Integer id) {

        return 0;
    }

    @Override
    public int remove(List<Integer> ids) {
        return 0;
    }

    @Override
    public int update(Record item) {

        return 0;
    }

    @Override
    public int update(List<Record> items) {

        return 0;
    }

    @Override
    public List<Record> getRecordByContinent(String continent) throws SQLException, InvalidQueryTypeException {
        return new ArrayList<>();
    }

    @Override
    public List<Record> getByPoiID(int input) throws SQLException, InvalidQueryTypeException {
        return new ArrayList<>();
    }

    @Override
    public List<Record> getFilteredRecords(FilterType filterType) throws SQLException, InvalidQueryTypeException {
        return new ArrayList<>();
    }

}
