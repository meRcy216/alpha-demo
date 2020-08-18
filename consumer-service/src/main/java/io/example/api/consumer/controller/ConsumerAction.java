package io.example.api.consumer.controller;

import io.example.api.provider.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerAction {

	@Reference
	private ProviderService providerService;

	@GetMapping("/service")
	public String getService() {
		return providerService.getService();
	}
}
