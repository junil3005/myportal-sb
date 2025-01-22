package himedia.myportal.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import himedia.myportal.repositories.vo.GuestbookVo;

@Repository
public class GuestbookDaoImpl 
	implements GuestbookDao {
//	@Autowired
//	SqlSession sqlSession;
	
	@Override
	public List<GuestbookVo> selectAll() {
//		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
//		return list;
		return null;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = 0;
//		try {
//			insertedCount = 
//					sqlSession.insert("guestbook.insert", vo);
//			// PersistenceException or SQLException
//		} catch (Exception e) {
//			//	예외 전환
//			throw new GuestbookDaoException("방명록 기록중 에러 발생", vo);
//		}
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = 0;
//		try {
//			deletedCount = sqlSession.delete("guestbook.delete", vo);
//		} catch (Exception e) {
//			throw new GuestbookDaoException("방명록 삭제중 에러 발생", vo);
//		}
		return deletedCount;
	}

}