package io.example.api.consumer.service;

import io.example.api.consumer.ConsumerService;
import io.example.api.provider.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Reference
	private ProviderService providerService;

	@Override
	public String getService() {
		return providerService.getService();
	}
}
