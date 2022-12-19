package kr.or.ddit.generation.options.board.widget.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.generation.options.board.widget.controller.BoardWidgetController;
import kr.or.ddit.generation.options.board.widget.dao.BoardWidgetDAO;
import kr.or.ddit.vo.GenBrdWdgtVO;
import kr.or.ddit.vo.GenLkLstVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class BoardWidgetServiceImpl implements BoardWidgetService {

	@Inject
	private BoardWidgetDAO dao;



	@Override
	public List<GenBrdWdgtVO> brdWgtRtView(String schId) {
		return dao.selectRtBrdWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> brdWgtLtView(String schId) {
		return dao.selectLtBrdWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> brdWgtOneView(String schId) {
		return dao.selectOnebrd(schId);
	}

	@Override
	public List<GenBrdWdgtVO> brdWgtOneImg(String schId) {
		return dao.selectOneImg(schId);
	}

	@Override
	public List<GenBrdWdgtVO> imgWgtRtView(String schId) {
		return dao.selectRtImgWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> imgWgtLtView(String schId) {
		return dao.selectLtImgWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> vdWgtLtView(String schId) {
		return dao.selectLtVdWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> vdWgtRtView(String schId) {
		return dao.selectRtVdWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> triVdWgtLt(String schId) {
		return dao.triLtVdWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> triVdWgtMd(String schId) {
		return dao.triMdVdWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> triVdWgtRt(String schId) {
		return dao.triRtVdWgt(schId);
	}

	@Override
	public List<GenBrdWdgtVO> noticeView(String schId) {
		return dao.noticeBrd(schId);
	}

	@Override
	public GenBrdWdgtVO dietBrd(String schId) {
		return dao.dietBrd(schId);
	}

	@Override
	public List<GenBrdWdgtVO> underBannerList(String schId) {
		return dao.underBanner(schId);
	}

	@Override
	public List<GenLkLstVO> linkListView(String schId) {
		return dao.selectLinkList(schId);
	}

	@Override
	public List<GenBrdWdgtVO> calendarView(String schId) {
		return dao.selectCalendar(schId);
	}

}
