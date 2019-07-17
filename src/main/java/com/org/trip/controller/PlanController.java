package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.PlanService;
import com.org.trip.vo.PlanVO;

@RestController
public class PlanController {

	@Resource
	   PlanService ps;
	   
	   @GetMapping("/plans")
	   public List<PlanVO> getPlanList() {
	      return ps.getPlanList();
	         }
	   
	   @GetMapping("/planNum")
	   public PlanVO getPlan(@RequestParam(value="planNum") Integer planNum) {
	      PlanVO plan = new PlanVO();
	      plan.setPlanNum(planNum);
	      return ps.getPlan(plan);
	   }
	   
	   @GetMapping("/planUser/{userNum}")
	   public List<PlanVO> getPlanByUser(@PathVariable Integer userNum){
	      PlanVO plan = new PlanVO();
	      plan.setUserNum(userNum);
	      return ps.getPlanByUser(plan);
	   }
	   
	   @GetMapping("/planTema/{planTema}")
	   public List<PlanVO> getPlanByTema(@PathVariable Integer planTema){
	      PlanVO plan = new PlanVO();
	      plan.setPlanTema(planTema);
	      return ps.getPlanByTema(plan);
	   }
	   
	   @PostMapping("/plan")
	   public Integer insertPlan(@RequestBody PlanVO plan) {
	      return ps.insertPlan(plan);
	   }
	   
	   @PutMapping("/plan")
	   public Integer updatePlan(@RequestBody PlanVO plan) {
	      return ps.updatePlan(plan);
	   }
	   
	   @DeleteMapping("/plan")
	   public Integer deletePlan(@RequestBody PlanVO plan) {
	      return ps.deletePlan(plan);
	   }
}
