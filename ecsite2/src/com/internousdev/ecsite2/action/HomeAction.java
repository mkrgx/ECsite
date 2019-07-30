package com.internousdev.ecsite2.action;

import java.util.Map;
import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
public Map<String, Object> session;
public String execute(){
	String result ="login";
	if(session.containsKey("login_user_id")){
		BuyItemDAO buyItemDAO=new BuyItemDAO();
		BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

		/*sessionに登録情報を入れる*/
		session.put("id", buyItemDTO.getId());
		session.put("buyItem_name", buyItemDTO.getItemName());
		session.put("buyItem_price", buyItemDTO.getItemPrice());
		result =SUCCESS;
	}
	return result;
}

/*登録情報が入っているかhome.jspに真偽値を送る*/
@Override
public void setSession(Map<String, Object> session){
	this.session=session;
}
public Map<String, Object> getSession(){
	return this.session;
}
}