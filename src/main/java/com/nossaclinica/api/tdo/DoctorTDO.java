package com.nossaclinica.api.tdo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class DoctorTDO {
	
	private Long id;
	private String name;
	private String crm;
	private List<SpecialtyTDO> specialties;
	private PictureTDO picture;
	private String price;
	private List<AttendanceTDO> attendances;
	private List<DayOfServiceTDO> daysOfServie;

}
