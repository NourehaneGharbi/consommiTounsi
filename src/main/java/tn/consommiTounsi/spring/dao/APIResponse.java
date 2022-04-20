package tn.consommiTounsi.spring.dao;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestConstructor;

@DataJpaTest
@ConstructorBinding

public class APIResponse<T>{
	int recordCount;
	T response;
	

}
