package com.raj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.FileRecord;
import com.raj.repository.IFileRecordRepository;
@Service
public class FileStorageServiceImpl implements IFileRecordMgmtService{

	@Autowired
	private IFileRecordRepository fileRecordRepo;
	
	@Override
	public String saveFileRecord(FileRecord fileRecord) {
		Long id = fileRecordRepo.save(fileRecord).getId();
		return "New File Record is saved with ID: "+id;
	}

	@Override
	public FileRecord getFileRecordById(long id) {
		
		return fileRecordRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid ID."));
	}

	@Override
	public List<FileRecord> showAllFileRecords() {
		
		return fileRecordRepo.findAll();
	}
}
