package netease.gx.dao;

import java.util.List;

import netease.gx.bean.AlreadyBuy;

public interface AlreadyBuyDao {

	public boolean addBuyGoods(int uid, int gid, int number) throws Exception;

	public List<AlreadyBuy> getAllBuyGoods(int uid) throws Exception;
	
	public boolean ifInAlreadyBuyList(int gid,int uid) throws Exception;

}
