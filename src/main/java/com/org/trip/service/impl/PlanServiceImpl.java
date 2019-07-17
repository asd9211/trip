package com.org.trip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.trip.mapper.PlanMapper;
import com.org.trip.service.PlanService;
import com.org.trip.vo.PlanVO;

@Service
public class PlanServiceImpl implements PlanService {
	@Resource
	   PlanMapper pm;


	   @Override
	   public List<PlanVO> getPlanList() {
	      return pm.getPlanList();
	   }

	   @Override
	   public PlanVO getPlan(PlanVO plan) {
	      return pm.getPlan(plan);
	   }

	   @Override
	   public List<PlanVO> getPlanByUser(PlanVO plan) {
	      return pm.getPlanByUser(plan);
	   }

	   @Override
	   public List<PlanVO> getPlanByTema(PlanVO plan) {
	      return pm.getPlanByTema(plan);
	   }

	   @Override
	   public Integer insertPlan(PlanVO plan) {
	      return pm.insertPlan(plan);
	   }

	   @Override
	   public Integer updatePlan(PlanVO plan) {
	      return pm.updatePlan(plan);
	   }

	   @Override
	   public Integer deletePlan(PlanVO plan) {
	      return pm.deletePlan(plan);
	   }	
}
