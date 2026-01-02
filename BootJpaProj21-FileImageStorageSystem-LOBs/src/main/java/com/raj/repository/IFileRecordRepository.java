package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.FileRecord;

public interface IFileRecordRepository extends JpaRepository<FileRecord, Long>{

}
