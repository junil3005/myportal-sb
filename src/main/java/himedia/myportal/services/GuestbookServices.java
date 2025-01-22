package himedia.myportal.services;

import java.util.List;

import himedia.myportal.repositories.vo.GuestbookVo;

public interface GuestbookServices {
	public List<GuestbookVo> getMessageList() ;
	public boolean writeMessage(GuestbookVo vo);
	public boolean deleteMessage(GuestbookVo vo);

}
