package egovframework.let.temp3.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("tempService")
public class TempServiceImpl extends EgovAbstractServiceImpl implements TempService {
	/*
	@Resource(name = "tempDAO")
	private TempDAO tempDAO;
	*/
	@Resource(name="tempMapper")
	private TempMapper tempMapper;
	
	@Resource(name="temp2Mapper")
	private Temp2Mapper temp2Mapper;
	
	@Resource(name = "egovTempIdGnrService")
	private EgovIdGnrService idgenService; //pk값에 데이터를 insert 할때 사용
	
	
	/*
	public TempVO selectTemp(TempVO vo) throws Exception {
		return tempDAO.selectTemp(vo);
	}
	*/
//	public TempVO selectTemp(TempVO vo) throws Exception {
//		return tempMapper.selectTemp(vo);  
//	} 
	public TempVO selectTemp(TempVO vo) throws Exception {
		return temp2Mapper.selectTemp(vo);  
	} 
	
	//임시데이터 목록 가져오기
//	public List<EgovMap> selectTempList(TempVO vo) throws Exception {
//		return tempMapper.selectTempList(vo);
//	}
	public List<EgovMap> selectTempList(TempVO vo) throws Exception {
		return temp2Mapper.selectTempList(vo);
	}
	
	//임시데이터 등록하기
	public String insertTemp(TempVO vo) throws Exception {
		String id = idgenService.getNextStringId();
		vo.setTempId(id);
		
		temp2Mapper.insertTemp(vo);
		return id; //insert 한것에 대한 id를 받을 수 있다.-> 받은 id가지고 후속 작업이 가능하다. 
	}
//	public String insertTemp(TempVO vo) throws Exception {
//		tempMapper.insertTemp(vo);
//		return null; 
//	}
	
	//임시데이터 수정하기
	public void updateTemp(TempVO vo) throws Exception{
		temp2Mapper.updateTemp(vo);
	}
//	public void updateTemp(TempVO vo) throws Exception{
//		tempMapper.updateTemp(vo);
//	}

	//임시데이터 삭제하기
	public void deleteTemp(TempVO vo) throws Exception{
		temp2Mapper.deleteTemp(vo);
	}
//	public void deleteTemp(TempVO vo) throws Exception{
//		tempMapper.deleteTemp(vo);
//	}
	
}


