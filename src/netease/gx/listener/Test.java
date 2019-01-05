package netease.gx.listener;

import netease.gx.bean.Goods;
import netease.gx.dao.GoodsDao;
import netease.gx.factory.DAOFactory;

public class Test {

	public static void main(String[] args) throws Exception {

		// ShoppingCartDao dao = DAOFactory.getShoppingCartServiceInstance();
		// if (dao.payGoods(14, 11, 2)) {
		// System.out.println("++++++++++++++++++++");
		// } else {
		// System.out.println("------------------");
		// }
		// if (dao.addGoods(12, 11, 1)) {
		// }
		// dao.addGoods(12, 12, 1);
		// dao.deleteGoods(2, 8, 7);

		// List<ShoppingCart> scList=dao.getAllGoods(2);
		// for(int i=0;i<scList.size();i++){
		// System.out.println(scList.get(i).getNumber());
		// }

		// System.out.println(dao.getDesignateGoodsMs(2, 8));

		/*
		 * String gname, String photo, String type, String producer, float
		 * price, float carriage, String pdate, String paddress, String
		 * described
		 */
		
		GoodsDao dao = DAOFactory.getGoodsServiceInstance();
		System.out.print("�����ɹ�");
		String gname = "�㷨ʱ��";
		String photo = gname + "1.jpg&" + gname + "2.jpg";
		String type = "�鼮";
		int number = 46;
		String producer = "������ѧ������";
		float price = 38;
		float carriage = 2;
		String pdate = "2015-05-06";
		String paddress = "���㽭����";
		String described = " �ڡ��㷨ʱ����һ���У����ߴ������չ����һ���㷨�ʹ����������̽��֮�ã�̽Ѱ������ο�ʼ���Ŵ����ݵ������������ǽ����˹�����ר�ҡ������ݿ�ѧ�Һ͹�ȵĴ�ҵ���ǣ������Ǵ�������������������硣�ڵ����Լ�δ�����������ݺ��㷨��Ϊ��ᡢ��ҵ�͸����Ѿ��޷����ӵ��ʲ�ʱ���ͻ����һЩ���;���ģʽ����ӹ���ɣ��㷨����Ϊ�¾��õ������档�������˹����ܡ������ݡ��������������㷨����Ȥ�����㷨ʱ�����ͷǳ��ʺ����Ķ���";
		Goods goods = new Goods(gname, number, photo, type, producer, price,
				carriage, pdate, paddress, described);
		dao.addGoods(goods);
		 
		// System.out.println(dao.queryNumberById(9));
		// System.out.println(dao.queryNumberById(10));
		// Goods goods = new Goods("��Ʒһ", "1", "1", "1", "1", 1, 1,
		// "2011:01:01",
		// "1", "1");
		// if (dao.addGoods(goods)) {
		// System.out.println("+++++++++++++++++++++++");
		// }
		// goods = new Goods("��Ʒ��", "2", "2", "2", "2", 2, 2, "2011:01:01", "2",
		// "2");
		// dao.addGoods(goods);

		// UserDao dao = DAOFactory.getUserServiceInstance();
		// User user = new User();
		// user.setUname("�¶�");
		// user.setEmail("163");
		// user.setPasswd("123456");
		// boolean hh = dao.addUser(user);
		// System.out.println("--------------------------" + hh);

		// AlreadyBuyDao dao = DAOFactory.getAlreadyBuyServiceInstance();
		// if(dao.addBuyGoods(12, 10, 4)){
		// System.out.println("true");
		// }else{
		// System.out.println("false");
		// }
		// List<AlreadyBuy> list = dao.getAllBuyGoods(12);
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i).getBuyTime());
		// System.out.println(list.get(i).getNumber());
		// System.out.println(list.get(i).getGid());
		// }
		// AlreadyBuy buy=new AlreadyBuy();
		// buy.setUid(1);
		// buy.setGid(2);
		// buy.setNumber(2);

		// boolean flag=dao.editInfo(2,"hh","hh");
		// System.out.println("--------------"+flag);

		// boolean flag=dao.editPasswd(1, "����");
		// boolean flag=dao.deleteUser(1);
		// System.out.println("--------------"+flag);

		// User user = dao.queryByName("�ػ�");
		// if (user == null) {
		// System.out.println("----------------");
		// } else {
		// System.out.println(user.getEmail());
		// }

		// GoodsDao dao = DAOFactory.getGoodsServiceInstance();

		// Goods goods = new Goods("gname", "kind", "photo", "type", "producer",
		// 1, 2, "1111:11:12", "paddress", "described");
		// if (dao.addGoods(goods)) {
		// System.out.println("+++++++++++++++++++++++");
		// }

		// Goods hh=new Goods("��", "kind", "photo", "type", "producer",
		// 1, 2, "1111:11:12", "paddress", "described");
		// hh.setGid(7);
		// hh=null;
		// if(dao.editInfo(hh)){
		// System.out.println("+++++++++++++++");
		// }
		// dao.deleteGoods(9);
		// Goods goods=dao.queryById(9);
		// System.out.println(goods.getPdate());

		// Date date=new Date();
		// SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// System.out.println(df.format(date));
		/*
		ShoppingCartDao scDao = DAOFactory.getShoppingCartServiceInstance();
		String uid="6";
			if (scDao.payAllGoods(Integer.parseInt(uid))) {
				System.out.println("֧���ɹ�");
			} else {
				System.out.println("֧��ʧ�ܣ������ԡ�");
			}
		*/
	}
}
