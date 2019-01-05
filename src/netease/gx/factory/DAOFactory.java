package netease.gx.factory;

import netease.gx.dao.AlreadyBuyDao;
import netease.gx.dao.GoodsDao;
import netease.gx.dao.ShoppingCartDao;
import netease.gx.dao.UserDao;
import netease.gx.service.AlreadyBuyService;
import netease.gx.service.GoodsService;
import netease.gx.service.ShoppingCartService;
import netease.gx.service.UserService;

public class DAOFactory {

	public static UserDao getUserServiceInstance() throws Exception {
		return new UserService();
	}

	public static GoodsDao getGoodsServiceInstance() throws Exception {
		return new GoodsService();
	}

	public static ShoppingCartDao getShoppingCartServiceInstance()
			throws Exception {
		return new ShoppingCartService();
	}

	public static AlreadyBuyDao getAlreadyBuyServiceInstance() throws Exception {
		return new AlreadyBuyService();
	}
}
