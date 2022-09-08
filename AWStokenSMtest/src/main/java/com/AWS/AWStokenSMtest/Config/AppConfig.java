package com.AWS.AWStokenSMtest.Config;

import com.AWS.AWStokenSMtest.Model.Keys;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {
	
	@Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretkey;
    
    private Gson gson = new Gson();
    
    @Bean
    public String returnPublicKey() {
    	Keys  secrets = getSecret();
    	System.out.println("private key: " + secrets.getPubkey());
    	return secrets.getPubkey();
    }
    @Bean
    public String returnPrivateKey() {
    	Keys  secrets = getSecret();
    	System.out.println("private key: " + secrets.getPrikey());
    	return secrets.getPrikey();
    }
    
	public Keys getSecret() {

	    String secretName = "/aws/sm/app_test_sm";
	    String region = "us-west-2";

	    AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
	    		.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretkey)))
	                                    .withRegion(region)
	                                    .build();

	    String secret, decodedBinarySecret;
	    GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
	                    .withSecretId(secretName);
	    GetSecretValueResult getSecretValueResult = null;

	    try {
	        getSecretValueResult = client.getSecretValue(getSecretValueRequest);
	    } catch (Exception e) {

	        throw e;
	    } 
	    if (getSecretValueResult.getSecretString() != null) {
	        secret = getSecretValueResult.getSecretString();
	        return gson.fromJson(secret, Keys.class);
	    }
	    
	    return null;

	}

}
