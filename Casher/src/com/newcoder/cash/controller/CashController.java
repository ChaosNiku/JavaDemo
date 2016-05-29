package com.newcoder.cash.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.newcoder.cash.entity.ShoppingInfo;
import com.newcoder.cash.service.CashInit;
import com.newcoder.cash.service.CashSolve;
import com.newcoder.cash.utils.SimpleParser;
import com.newcoder.cash.utils.TicketConverter;
import com.newcoder.cash.utils.TicketsGnerator;


/**
 * @author chaos
 *	@version 0.31
 *	think of the whole model is simple i choose to let the controller
 *	solve the problem not create a service
 */
@Controller
public class CashController {
	
	@RequestMapping(value="cash.do",produces="application/json;charset=UTF-8")	
	public @ResponseBody String cashredirect(Model model,HttpServletRequest req,HttpServletResponse res){
		String ticket = req.getParameter("ticket");
		CashInit.init();
		List<ShoppingInfo> l = new LinkedList<ShoppingInfo>();
		String little = new String("");
		try {
			l = TicketConverter.convert(SimpleParser.simpleparser(ticket));
			little = TicketsGnerator.generate(CashSolve.cash(l, CashInit.getDiss().get(0)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		model.addAttribute("tickets", little);
		return little;
		
	}
}
