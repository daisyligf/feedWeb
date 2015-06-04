package com.mofang.feedweb.controller.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IdentifyingCodeContorller {

	private static int WIDTH = 65;// 设置图片的宽度

	private static int HEIGHT = 22;// 设置图片的高度

	@RequestMapping("/checkCode")
	public void check(@RequestParam(value = "code") String code, HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject json = new JSONObject();
		String rand = (String)request.getSession().getAttribute("randCode"); 
		if(StringUtils.isEmpty(code) || StringUtils.isEmpty(rand)) {
			json.put("code", 0);
		}
		if(!StringUtils.isEmpty(code) && !StringUtils.isEmpty(rand)) {
			code = code.toLowerCase();
			rand = rand.toLowerCase();
			if(rand.equals(code)) {
				json.put("code", 1);
			}else{
				json.put("code", 0);
			}
		}
		response.getWriter().print(json.toString());
	}
	
	@RequestMapping("/generageCode")
	public void generate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		char[] rands = generateCheckCode();
		drawBackground(g);
		drawRands(g, rands);
		g.dispose();

		ServletOutputStream sos = null;
		ByteArrayOutputStream bos = null;
		try {
			sos = response.getOutputStream();
			bos = new ByteArrayOutputStream();
			ImageIO.write(image, "JPEG", bos);
			byte[] buf = bos.toByteArray();
			response.setContentLength(buf.length);
			sos.write(buf);
			sos.flush();
		} finally{
			if(sos != null) {
				sos.close();
			}
			if(bos != null) {
				bos.close();
			}
		}
		
		//String randomCode = new String(rands);
		//response.getWriter().print(randomCode);
		request.getSession().setAttribute("randCode", new String(rands));
	}

	private void drawBackground(Graphics g) {
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < 120; i++) {
			int x = (int) (Math.random() * WIDTH);
			int y = (int) (Math.random() * HEIGHT);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			g.setColor(new Color(red, green, blue));
			g.drawOval(x, y, 1, 0);
		}
	}

	private void drawRands(Graphics g, char[] rands) {
		// g.setColor(Color.BLUE);
		Random random = new Random();
		int red = random.nextInt(110);
		int green = random.nextInt(50);
		int blue = random.nextInt(50);
		g.setColor(new Color(red, green, blue));
		g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
		g.drawString("" + rands[0], 1, 17);
		g.drawString("" + rands[1], 16, 15);
		g.drawString("" + rands[2], 31, 18);
		g.drawString("" + rands[3], 46, 16);
	}

	private char[] generateCheckCode() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] rands = new char[4];
		for (int i = 0; i < 4; i++) {
			int rand = (int) (Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}
		return rands;
	}
	
	

}
