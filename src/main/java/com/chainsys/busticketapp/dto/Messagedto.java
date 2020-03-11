package com.chainsys.busticketapp.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Messagedto {
		private String infoMessage;
		private String errorMessage;
	}
