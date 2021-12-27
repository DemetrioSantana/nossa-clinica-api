package com.nossaclinica.api.tdo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class PictureTDO {

	private Long id;
	private String path;
	private String title;
	private String description;
	private List<PictureTDO> pictures;
	
}
