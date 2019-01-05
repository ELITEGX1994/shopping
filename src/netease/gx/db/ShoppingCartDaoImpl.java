package netease.gx.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import netease.gx.bean.Goods;
import netease.gx.bean.ShoppingCart;
import netease.gx.dao.AlreadyBuyDao;
import netease.gx.dao.GoodsDao;
import netease.gx.dao.ShoppingCartDao;
import netease.gx.factory.DAOFactory;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

	private Connection conn = null;

	private PreparedStatement pstmt = null;

	public ShoppingCartDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	//���ﳵ������Ʒ
	@Override
	public boolean addGoods(int uid, int gid, int number) throws Exception {
		pstmt = null;
		int result = 0;
		String message = this.getDesignateGoodsMs(uid, gid);
		if (!"".equals(message)) {
			int sid = Integer.valueOf(message.split("&")[0]);
			int goodsCount = Integer.valueOf(message.split("&")[1]);
			String sql = "update shoppingcart set number=?,sdate=now() where sid=?";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, goodsCount + number);
			pstmt.setInt(2, sid);
		} else {
			String sql = "insert into shoppingcart(uid,gid,number,sdate)value(?,?,?,now());";
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setInt(2, gid);
			pstmt.setInt(3, number);
		}
		result = pstmt.executeUpdate();
		pstmt.close();
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	//ɾ�����ﳵ�е���Ʒ
	@Override
	public boolean deleteGoods(int uid, int gid, int number) throws Exception {
		String message = this.getDesignateGoodsMs(uid, gid);
		int result = 0;
		if (!"".equals(message)) {
			int sid = Integer.valueOf(message.split("&")[0]);
			int goodsCount = Integer.valueOf(message.split("&")[1]);
			if (goodsCount < number) {
				return false;
			} else if (goodsCount == number) {
				String sql = "delete from shoppingcart where sid=?";
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, sid);
			} else {
				String sql = "update shoppingcart set number=? where sid=?";
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, goodsCount - number);
				pstmt.setInt(2, sid);
			}
			result = pstmt.executeUpdate();
			pstmt.close();
		}
		if (result == 1) {
			return true;
		}
		return false;
	}
	
	//��ȡ���ﳵ�е�������Ʒ
	@Override
	public List<ShoppingCart> getAllGoods(int uid) throws Exception {
		pstmt = null;
		ResultSet rs = null;
		List<ShoppingCart> scList = null;
		String sql = "select * from shoppingcart where uid=?";
		pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		ShoppingCart sc;
		scList = new ArrayList<ShoppingCart>();
		while (rs.next()) {
			sc = new ShoppingCart();
			sc.setSid(rs.getInt("sid"));
			sc.setUid(rs.getInt("uid"));
			sc.setGid(rs.getInt("gid"));
			sc.setNumber(rs.getInt("number"));
			String date = rs.getDate("sdate").toString();
			String time = rs.getTime("sdate").toString();
			sc.setSdate(date + " " + time);
			scList.add(sc);
		}
		return scList;
	}
	
	//���ָ���û����ﳵ���Ƿ���ָ����Ʒ��������򷵻ع��ﳵid����Ʒ���������򷵻ؿ�
	@Override
	public String getDesignateGoodsMs(int uid, int gid) throws Exception {
		ResultSet rs = null;
		String sql = "select * from shoppingcart where uid =? and gid=?";
		pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, uid);
		pstmt.setInt(2, gid);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getString("sid") + "&" + rs.getInt("number");
		}
		return "";
	}

	//֧��ָ����Ʒ
	@Override
	public boolean payGoods(int uid, int gid, int number) throws Exception {
		boolean flag = false;
		GoodsDao dao = DAOFactory.getGoodsServiceInstance();
		int extantGoods = dao.queryNumberById(gid);
		conn.setAutoCommit(false);
		if (extantGoods >= number) {
			if (this.deleteGoods(uid, gid, number)) {
				Goods goods = dao.queryById(gid);
				goods.setNumber(extantGoods - number);
				AlreadyBuyDao ab = DAOFactory.getAlreadyBuyServiceInstance();
				flag = (ab.addBuyGoods(uid, gid, number) & dao.editInfo(goods));
			}
		}
		conn.commit();
		conn.setAutoCommit(true);
		return flag;
	}

	//֧��������Ʒ
	@Override
	public boolean payAllGoods(int uid) throws Exception {
		List<ShoppingCart> scList = this.getAllGoods(uid);
		if (scList != null & scList.size() > 0) {
			int gid;
			int number;
			ShoppingCart sc;
			for (int i = 0; i < scList.size(); i++) {
				sc = scList.get(i);
				gid = sc.getGid();
				number = sc.getNumber();
				this.payGoods(uid, gid, number);
			}
			return true;
		}
		return false;
	}
}