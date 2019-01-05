package netease.gx.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netease.gx.bean.Goods;
import netease.gx.factory.DAOFactory;

public class EditGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public EditGoodsServlet() {
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
		String gname = request.getParameter("gname");
		//int number = Integer.parseInt(request.getParameter("number"));
		int number=10;
		String photo = request.getParameter("photo");
		//String types = request.getParameter("types");
		String types = "asda";
		//String producer = request.getParameter("producer");
		String producer= "dsasd";
		float price= Float.parseFloat(request.getParameter("price"));
		//float carriage = Float.parseFloat(request.getParameter("carriage"));
		float carriage = (float)0.0;
		String pdate = request.getParameter("pdate");
		String described = request.getParameter("described");
		//String paddress = request.getParameter("paddress");
		String paddress = "dsasd";
		String path = "jsp/editGoods.jsp";
		String message = "发布失败";
		try {
			if (resister(gname,number,photo,types,producer,price,carriage, pdate,paddress,described)) {
				message = "发布成功";
				path = "index.jsp";
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

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
	}

//	String path = "jsp/addgoods.jsp";
	
	public boolean resister(String gname, int number, String photo, String type,
			String producer, float price, float carriage, String pdate,
			String paddress, String described) throws Exception{
		System.out.println("开始发布商品");
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
		
		
		return DAOFactory.getGoodsServiceInstance().editInfo(goods);
	}

}

