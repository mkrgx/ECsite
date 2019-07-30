package com.internousdev.ecsite2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;

public class MyPageAction extends ActionSupport implements SessionAware{
public Map<String, Object> session;
private MyPageDAO myPageDAO=new MyPageDAO();
private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
private String deleteFlg;
private String message;

public String execute() throws SQLException{
	/*containsKey=指定したキーが存在するか確認を行う
	SELECTみたいな？*/
	/*存在しない場合*/
	if(!session.containsKey("login_user_id")){
		return ERROR;
	}
	/*Flgが反応なしならListからidをいれる*/
	if(deleteFlg==null){
		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();
		myPageList=myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
	}else if(deleteFlg.equals("1")){
		delete();
	}
	String result=SUCCESS;
	return result;
}
public void delete() throws SQLException {
	String item_transaction_id=session.get("id").toString();
	String user_master_id=session.get("login_user_id").toString();

	int res=myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

	/*消去された件数が一件以上ならif, ０ならelse*/
	if(res>0){
		myPageList=null;
		setMessage("商品情報を正しく削除しました。");
	}else if(res==0){
		setMessage("商品情報の消去に失敗しました。");
	}
}

public void setDeleteFlg(String deleteFlg){
	this.deleteFlg=deleteFlg;
}
@Override
public void setSession(Map<String, Object> session){
	this.session=session;
}
public ArrayList<MyPageDTO> getMyPageList(){
	return this.myPageList;
}
public String getMessage(){
	return this.message;
}
public void setMessage(String message){
	this.message=message;
}

}
