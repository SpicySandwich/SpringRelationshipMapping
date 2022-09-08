package AWS.AwsSecretManagerDB.Config;

import javax.sql.DataSource;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import AWS.AwsSecretManagerDB.Model.MysqlPropertiesSecret;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SMrdsConfig {
	
	private Gson gson = new Gson();
	
	   @Value("${cloud.aws.credentials.access-key}")
	    private String accessKey;
	    @Value("${cloud.aws.credentials.secret-key}")
	    private String secretkey;
	    
	    @Bean
	    public DataSource dataSource() {
	    	MysqlPropertiesSecret  secrets = getSecret();
	    	System.out.println("test: "+ secrets.getUsername());
	        return DataSourceBuilder
	                .create()
	                //  .driverClassName("com.mysql.cj.jdbc.driver")
	                .url("jdbc:" + secrets.getEngine() + "://" + secrets.getHost() + ":" + secrets.getPort() + "/rdsdb")
	                .username(secrets.getUsername())
	                .password(secrets.getPassword())
	                .build();
	        
	    }
	

	public MysqlPropertiesSecret getSecret() {

	    String secretName = "secret-name-aws-rds-test";
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
	        return gson.fromJson(secret, MysqlPropertiesSecret.class);
	    }
	    
	    return null;
	}

}
