package com.nossaclinica.api.converter.to_entity;

import java.util.ArrayList;
import java.util.List;

import com.nossaclinica.api.entities.DayOfService;
import com.nossaclinica.api.tdo.DayOfServiceTDO;

public class ConveterDayOfServiceTDOToEntityDayOfService {
	
	public List<DayOfService> loadListDaysOfService(List<DayOfServiceTDO> dos) {
		List<DayOfService> daysOfService = new ArrayList<DayOfService>();
		
		if (!dos.isEmpty()) {
			
			dos.stream().forEach(d -> {
				
				daysOfService.add(fromDayOfServiceTDO(d));
				
			});
			
		}
		
		return daysOfService;
	}

	public DayOfService fromDayOfServiceTDO(DayOfServiceTDO d) {
		DayOfService dayOfService = new DayOfService();
		
		if (d.getId() != null) {
			
			dayOfService.setId(d.getId());
			
		}
		dayOfService.setDate(d.getDate());
		dayOfService.setTime(d.getTime());
		return dayOfService;
	}

}
