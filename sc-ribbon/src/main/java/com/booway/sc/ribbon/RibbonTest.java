package com.booway.sc.ribbon;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.booway.sc.RibbonInit;

/**
 * 负载均衡测试
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@SpringBootTest(classes = { RibbonInit.class })
@RunWith(SpringRunner.class)
public class RibbonTest
{
	/** 负载均衡器 */
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	/** rest template */
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void testRibbon()
	{
		ServiceInstance si = loadBalancerClient.choose("service-user");
		
		String url = String.format("http://%s:%s/service/user/queryById", si.getHost(), si.getPort());
		RestTemplate restTemplate = new RestTemplate();
		
		// 参数信息
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<String, Object>();
		postParameters.add("id", "1");
		
        // 返回的是List<Map>
		List<?> responseEntity = restTemplate.postForObject(url, postParameters, List.class);
		System.out.println(responseEntity);
	}
	@Test
	public void testRestTemplate()
	{
		// 封装请求参数
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<String, Object>();
		postParameters.add("id", "1");
		
		List<?> responseEntity = restTemplate.postForObject("http://service-user/service/user/queryById", postParameters, List.class);
		System.out.println(responseEntity);
	}
}
