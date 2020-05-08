package com.zhileiedu.spring.curator.controller;

import com.zhileiedu.spring.curator.service.DistributedLockByZookeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 王志雷
 * @Date: 2020/5/8 15:08
 */
@RestController
public class IndexController {

	@Autowired
	DistributedLockByZookeeper distributedLockByZookeeper;

	private final static String PATH = "test";
	private int count = 0;

	@GetMapping("/lock1")
	public int getLock1() {
		Boolean flag;
		distributedLockByZookeeper.acquireDistributedLock(PATH);
		//try {
		count++;
		// Thread.sleep(20000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//	flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
		//}
		flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
		return count;
	}


}

