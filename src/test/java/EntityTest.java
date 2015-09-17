import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class EntityTest {
	public static void main(String[] args) throws Exception {
		saveEntity();
	}

	public static void saveEntity() throws Exception {
		try {
			Mongo mongo = new MongoClient();
			System.out.println(mongo.getDatabaseNames());
			//只有在对db不为空时才会创建此db 例如若无后面18-25行则不会创建此DB
			DB myFirstMDB = mongo.getDB("myFirstMDB");
			DBCollection dbc = myFirstMDB.getCollection("person");
			BasicDBObject doc = new BasicDBObject("name", "MongoDB")
					.append("type", "database")
					.append("count", 1)
					.append("info",
				 			new BasicDBObject("x", 203).append("y", 102));
			dbc.insert(doc);
			System.out.println(mongo.getDatabaseNames());
			DBObject myDoc = dbc.findOne();
			System.out.println(myDoc);
		} catch (Exception e) {
			// TODO Auto-generated catcsh block
			e.printStackTrace();
		}
		// Mongo mongo =new Mongo();
	}
}
