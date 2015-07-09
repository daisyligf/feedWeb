package com.mofang.feedweb.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mofang.feedweb.component.RedisComponent;
import com.mofang.feedweb.entity.UserInfo;
import com.mofang.feedweb.global.GlobalObject;
import com.mofang.feedweb.util.LogConsole;
import com.mofang.feedweb.util.RedisUtil;
import com.mofang.feedweb.util.StringUtil;

@Controller
public class IdentifyingCodeContorller extends FeedCommonController{

	private static int WIDTH = 65;// 设置图片的宽度

	private static int HEIGHT = 22;// 设置图片的高度
	
	@Autowired
	private RedisComponent redisComp;

	@RequestMapping("/checkCode")
	public void check(@RequestParam(value = "code") String code, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			JSONObject json = new JSONObject();
			UserInfo userInfo = getUserInfo(request);
			if(userInfo == null) {
				json.put("code", 1);
				json.put("message", "登录超时,请重新登录");
				String result = json.toString();
				LogConsole.log(result);
				response.getWriter().print(result);
				return;
			}
			String rand = RedisUtil.get(redisComp, String.valueOf(userInfo.getUserId()));
			if(StringUtil.isNullOrEmpty(code) || StringUtil.isNullOrEmpty(rand)) {
				json.put("code", 1);
				json.put("message", "验证码错误");
			}
			if(!StringUtil.isNullOrEmpty(code) && !StringUtil.isNullOrEmpty(rand)) {
				code = code.toLowerCase();
				rand = rand.toLowerCase();
				if(rand.equals(code)) {
					json.put("code", 0);
				}else{
					json.put("code", 1);
					json.put("message", "验证码错误");
				}
			}
			String result = json.toString();
			StringBuilder sb = new StringBuilder();
			sb.append("userId=").append(userInfo.getUserId()).append(",").append("code=").
			append(code).append(",rand=").append(rand).append(result);
			LogConsole.log(sb.toString());
			response.getWriter().print(result);
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at IdentifyingCodeContorller.check throw an error.", e);
		}
	}
	
	@RequestMapping("/generageCode")
	public void generate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
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
			//request.getSession().setAttribute("randCode", new String(rands));
			UserInfo userInfo = getUserInfo(request);
			if(userInfo != null) {
				RedisUtil.set(redisComp, String.valueOf(userInfo.getUserId()), new String(rands));
			}
		} catch (Exception e) {
			GlobalObject.ERROR_LOG.error("at IdentifyingCodeContorller.generate throw an error.", e);
		}
	}

	private void drawBackground(Graphics g) {
		//g.setColor(new Color(0xDCDCDC));
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < 120; i++) {
			//int x = (int) (Math.random() * WIDTH);
			//int y = (int) (Math.random() * HEIGHT);
//			int red = (int) (Math.random() * 255);
//			int green = (int) (Math.random() * 255);
//			int blue = (int) (Math.random() * 255);
			//g.setColor(new Color(248, 248, 255));
			//g.drawOval(x, y, 1, 0);
		}
	}

	private void drawRands(Graphics g, char[] rands) {
		g.setColor(Color.BLUE);
//		Random random = new Random();
//		int red = random.nextInt(110);
//		int green = random.nextInt(50);
//		int blue = random.nextInt(50);
//		g.setColor(new Color(0, 0, 255));
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
