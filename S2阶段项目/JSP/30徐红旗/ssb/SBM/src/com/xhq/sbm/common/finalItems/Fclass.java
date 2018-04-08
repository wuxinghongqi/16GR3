package com.xhq.sbm.common.finalItems;

import java.util.UUID;

public class Fclass {
	public static final String FILE_USER_PIC_PHOTO_PATH="files/user/pic/photo/";
	
	public static String getUUID() {
		String uuid =UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;		
	} 
}
