package com.hotdesking.study.service;

import com.hotdesking.study.domain.TableInfo;
import com.hotdesking.study.domain.TableRequest;
import com.hotdesking.study.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public TableInfo findTable(String tableId){
        Optional<TableInfo> desk = tableRepository.findByTableId(tableId);
        return desk.get();
    }
    public List<TableInfo> findAll(){

        return tableRepository.findAll();
    }
}
