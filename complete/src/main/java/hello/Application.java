package hello;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

public class Application {

	public static void main(String[] args) {
		CouchbaseCluster cc = CouchbaseCluster.create();
		Bucket bucket = cc.openBucket();

		JsonObject jsonObject = JsonObject.create();
		jsonObject.put("firstName", "Alice");
		jsonObject.put("lastName", "Smith");
		JsonDocument document = JsonDocument.create("asmith", jsonObject);
		bucket.upsert(document);

		JsonDocument doc = bucket.get("asmith");
		System.out.println(doc.content());
	}

}
