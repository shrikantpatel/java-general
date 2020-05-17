package com.shri.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Version {

	@Builder.Default
	private String versionNum = "0";

}
