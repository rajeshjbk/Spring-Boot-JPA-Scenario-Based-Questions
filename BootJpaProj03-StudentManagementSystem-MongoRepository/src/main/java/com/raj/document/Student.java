package com.raj.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "Student_Documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	private String studentId;
	@NonNull
	private String studentName;
	@NonNull
	private String department;
	@NonNull
	private Double marks;
}
