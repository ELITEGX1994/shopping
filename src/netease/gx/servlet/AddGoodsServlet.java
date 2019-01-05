package netease.gx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netease.gx.bean.Goods;
import netease.gx.bean.User;
import netease.gx.factory.DAOFactory;

public class AddGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public AddGoodsServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("调用post函数");
		response.setContentType("text/html");
		/*
		String gname = request.getParameter("gname");
		int number = Integer.parseInt(request.getParameter("number"));
		String photo = request.getParameter("photo");
		String types = request.getParameter("types");
		String producer = request.getParameter("producer");
		if(producer==null) {
			producer = "生产�???";
		}
		float price= Float.parseFloat(request.getParameter("price"));
		float carriage = Float.parseFloat(request.getParameter("carriage"));
		if(producer==null) {
			carriage = (float)0.0;
		}
		String pdate = request.getParameter("pdate");
		if(pdate==null) {
			pdate = "日期";
		}
		String described = request.getParameter("described");
		String paddress = request.getParameter("paddress");
		if(paddress==null) {
			paddress = "地址";
		}
		
		
		*/
		String path = "jsp/addgoods.jsp";
		String message = "发布成功";
		/*
		String gname = "gx";
		int number = 1;
		String photo = "asda";
		String types = "sda";
		String producer = "sdasd";
		float price = (float)1.0;
		float carriage = (float)1.0;
		String pdate = "adsa";
		String paddress = "dasda";
		String described = "sdasd";
		*/

		String gname = "算法时代";
		String photo = gname + "1.jpg&" + gname + "2.jpg";
		String type = "书籍";
		int number = 46;
		String producer = "北京大学出版�???";
		float price = 38;
		float carriage = 2;
		String pdate = "2015-05-06";
		String paddress = "从浙江发�???";
		String described = "在�?�算法时代�?�一书中，作者带领读者展�???了一次算法和大数据世界的探索之旅：探寻我们如何开始相信大数据的力量；向我们介绍人工智能专家�?�大数据科学家和硅谷的创业家们，是他们创造了这个美丽的新世界。在当下以及未来，当大数据和算法成为社会、企业和个人已经无法忽视的资产时，就会催生一些新型经济模式�?�毋庸置疑，算法将成为新经济的新引擎。如果你对人工智能�?�大数据、互联网�???术和算法感兴趣，《算法时代�?�就非常适合你阅读�??";
		try {
			if (resister(gname,number,photo,type,producer,price,carriage, pdate,paddress,described)) {
				message = "发布成功";
				path = "jsp/addgoods.jsp";
				System.out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String truePath = request.getContextPath() + "/" + path;
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>ע��</TITLE>");
		out.println("<meta http-equiv=\"refresh\" content=\"5;url=" + truePath
				+ "\">");
		out.println("</HEAD>");
		out.println("  <BODY>");
		out.print("<div align=\"center\">");
		out.print(message);
		out.print("<br/>");
		out.print("���Զ���ת����Ӧҳ��");
		out.print("<br/>");
		out.print("�������");
		out.print("<a href=\"" + truePath + "\"" + ">����" + "</a>");
		out.print("</div>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

//	String path = "jsp/addgoods.jsp";
	
	public boolean resister(String gname, int number, String photo, String type,
			String producer, float price, float carriage, String pdate,
			String paddress, String described) throws Exception{
		System.out.println("�???始发布商�???");
		Goods goods = new Goods();
		goods.setGname(gname);
		goods.setNumber(number);
		goods.setPhoto(photo);
		goods.setCarriage(carriage);
		goods.setDescribed(described);
		goods.setPaddress(paddress);
		goods.setPdate(pdate);
		goods.setPrice(price);
		goods.setProducer(producer);
		goods.setType(type);
		
		
		return DAOFactory.getGoodsServiceInstance().addGoods(goods);
	}

}
