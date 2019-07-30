package com.org.trip.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.trip.service.WithService;
import com.org.trip.vo.WithVO;

@CrossOrigin("*")
@RestController
public class WithController {
   
   @Resource
   private WithService ws;
   
   @GetMapping("/withs")
   public List<WithVO> getWithList(){
      return ws.getWithList();
   }
   
   @GetMapping("/with")
   public WithVO getWith(WithVO with) {
      return ws.getWith(with);
   }
   
   @PostMapping("/with")
   public Integer insertWith(@RequestBody WithVO with) {
      return ws.insertWith(with);
   }
   
   @PutMapping("/with")
   public Integer updateWith(@RequestBody WithVO with) { 
      return ws.updateWith(with);
   }
   
   public Integer deleteWith(WithVO with) {
      return ws.deleteWith(with);
   }
   
   @GetMapping("/with/{userNum}")
   public List<WithVO> getWithListByuser(@PathVariable Integer userNum){
      WithVO with = new WithVO();
      with.setUserNum(userNum);
      return ws.getWithByUser(with); 
   }
}