package com.raj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class FileRecord {

	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "file_Record_id", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 50)
	@NonNull
	private String fileName;
	
	@Lob
	@NonNull
	private String fileText;
	
	@Lob
	@NonNull
	private byte[] fileImage;
	
}
