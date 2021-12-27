package com.nossaclinica.api.converter.to_tdo;

import java.util.ArrayList;
import java.util.List;

import com.nossaclinica.api.entities.Picture;
import com.nossaclinica.api.tdo.PictureTDO;

public class ConverterEntityPictureToTDO {
	
	//CONVERTE DO TIPO Picture para PictureTDO
		public PictureTDO fromPictureToPictureTDO(Picture picture) {
			List<PictureTDO> listPictures = new ArrayList<PictureTDO>();

			if (picture.getId() == null) {
				return null;
			}
			
			picture.getPictures().stream()
			.forEach(p -> {
				listPictures.add(PictureTDO.builder()
						.id(p.getId())
						.title(p.getTitle())
						.description(p.getDescription())
						.path(p.getPath())
						.pictures(null)
						.build()
	);
			});
			return PictureTDO.builder()
					.id(picture.getId())
					.description(picture.getDescription())
					.path(picture.getPath())
					.title(picture.getTitle())
					.pictures(listPictures)
					.build();
		}

}
