package com.raj.service;

import java.util.List;
import java.util.Optional;

import com.raj.entity.FileRecord;

public interface IFileRecordMgmtService {

	String saveFileRecord(FileRecord fileRecord);
	
	FileRecord getFileRecordById(long id);
	
	List<FileRecord> showAllFileRecords();
}
