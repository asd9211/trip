package com.org.trip.mapper;

import java.util.List;

import com.org.trip.vo.PlanVO;

public interface PlanMapper {

	public List<PlanVO> getPlanList();
	public PlanVO getPlan(PlanVO plan);
	public List<PlanVO> getPlanByUser(PlanVO plan);
	public List<PlanVO> getPlanByTema(PlanVO plan);
	public Integer insertPlan(PlanVO plan);
	public Integer updatePlan(PlanVO plan);
	public Integer deletePlan(PlanVO plan);
}
