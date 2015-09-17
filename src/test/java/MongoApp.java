import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

public class MongoApp {
	private static final Log log = LogFactory.getLog(MongoApp.class);
	public static void main(String[] args) throws Exception {
		MongoOperations mongoOps = new MongoTemplate(new MongoClient(),"database");
		Person p = new Person("张三",21);
		p.setId("sssss");
		List<Person> list = mongoOps.findAll(Person.class);
		System.out.println(list);
		//mongoOps.insert(p);
		log.info(mongoOps.find(new Query(Criteria.where("name").is("张三")), Person.class));
	//	mongoOps.dropCollection("person");
	}

}
