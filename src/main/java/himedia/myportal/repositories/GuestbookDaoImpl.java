package himedia.myportal.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.GuestbookDaoException;
import himedia.myportal.mappers.GuestbookMapper;
import himedia.myportal.repositories.vo.GuestbookVo;

@Repository
public class GuestbookDaoImpl 
	implements GuestbookDao {
//	@Autowired
//	SqlSession sqlSession;
	
	@Autowired
	private GuestbookMapper guestbookMapper;
	
	@Override
	public List<GuestbookVo> selectAll() {
//		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
//		return list;
		return guestbookMapper.selectAll();
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = 0;
		try {
			insertedCount = guestbookMapper.insert(vo);
			// PersistenceException or SQLException
		} catch (Exception e) {
			//	예외 전환
			throw new GuestbookDaoException("방명록 기록중 에러 발생", vo);
		}
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = 0;
		try {
//			deletedCount = sqlSession.delete("guestbook.delete", vo);
			deletedCount = guestbookMapper.delete(vo);
		} catch (Exception e) {
			throw new GuestbookDaoException("방명록 삭제중 에러 발생", vo);
		}
		return deletedCount;
	}

}