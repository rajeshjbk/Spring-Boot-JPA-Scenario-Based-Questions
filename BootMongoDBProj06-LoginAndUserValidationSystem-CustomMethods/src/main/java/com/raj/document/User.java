package com.raj.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "USER_DOCUMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

	@Id
	private String id;
	
	@NonNull
	private String username;
	@NonNull
	private String email;
	@NonNull
	private String password;
	@NonNull
	private String role;
	@NonNull
	private Boolean active;
	
	
}
