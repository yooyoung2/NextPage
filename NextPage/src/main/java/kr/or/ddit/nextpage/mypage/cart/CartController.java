package kr.or.ddit.nextpage.mypage.cart;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("nextpage/mypage")
public class CartController {

	@Inject
	private SchoolService service;

	// 카트 리스트
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public String nextPageCart(HttpSession session, Model model, Model schModel) {

		String id = (String) session.getAttribute("authSch");
		List<CartVO> cartList = service.retrueveCartList(id);

		SchoolVO schInfo = service.retrieveSchoolInfo(id);

		log.info("cart : {}", cartList);
		model.addAttribute("cartList", cartList);
		schModel.addAttribute("schInfo", schInfo);

		return "nextpage/mypage/33_nextPageCart/nextPageCart";
	}
	
	// 결제하기
	@PostMapping(value = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String pay(@RequestBody List<PayVO> dataList, HttpSession session) {
		log.debug("payList : {}", dataList);

		ServiceResult result = null;
		int count = 0;
		log.info("dataSize : {}", dataList.size());

		PayVO payvo = new PayVO();

		for (int i = 0; i < dataList.size(); i++) {
			payvo.setPayId(dataList.get(i).getPayId());
			payvo.setCartId(dataList.get(i).getCartId());
			payvo.setProdId(dataList.get(i).getProdId());
			payvo.setProdNm(dataList.get(i).getProdNm());
			payvo.setProdPrice(dataList.get(i).getProdPrice());

			result = service.pay(payvo);
			log.info("i, result : "+ i + " " +result);
			if (result == ServiceResult.OK) {
				count++;
			}
		}
		log.info("count : "+count);
		
		if(count == dataList.size()) {
			return "결제 완료 되었습니다.";
		}else {
			int fail = (dataList.size())-count;
			return fail+"건 결제 실패";
		}
	}
	
	// 장바구니에서 삭제하기
	@PostMapping(value = "/cartDel")
	@ResponseBody
	public void cartDelete(
			@RequestParam int cartId,
			@RequestParam String prodId,
			HttpSession session) {

		String schId = (String) session.getAttribute("authSch");
		ServiceResult result = null;
		
		CartVO cartvo = new CartVO();
		cartvo.setSchId(schId);
		cartvo.setProdId(prodId);
		cartvo.setCartId(cartId);

		result = service.cartDelete(cartvo);
		
	}

}
