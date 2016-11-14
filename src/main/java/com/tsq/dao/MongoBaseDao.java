package com.tsq.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public abstract class MongoBaseDao<T> {
	private static final Logger logger = Logger.getLogger(MongoBaseDao.class);
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	abstract Class<T> getEntityClass();
	
	
	public void saveEntity(T t){
		logger.debug("[Mongo Dao ]==:"+t);
		this.mongoTemplate.save(t);
	}
	public void updateFirst(Query query,Update update){
		logger.debug("[Mongo Dao ]updateFirst:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.updateFirst(query, update, this.getEntityClass());
    }
    
    public void updateMulti(Query query, Update update){
    	logger.debug("[Mongo Dao ]updateMulti:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }
    
    public void updateInser(Query query, Update update){
    	logger.debug("[Mongo Dao ]updateInser:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.upsert(query, update, this.getEntityClass());
    }
	public T findById(String id){
		Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        logger.debug("[Mongo Dao ]==:" + query);
        return this.mongoTemplate.findOne(query, this.getEntityClass());
	}
	public List<T> queryList(Query query){
		logger.debug("[Mongo Dao ]queryList:" + query);
        return this.mongoTemplate.find(query, this.getEntityClass());
    }
	public T queryOne(Query query){
		logger.debug("[Mongo Dao ]queryOne:" + query);
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }
	public List<T> getPage(int start, int size){
		Query query = new Query();
        query.skip(start);
        query.limit(size);
        logger.debug("[Mongo Dao ]queryPage:" + query + "(" + start +"," + size +")");
        List<T> lists = this.mongoTemplate.find(query, this.getEntityClass());
        return lists;
    }
	public Long getPageCount(Query query){
		logger.debug("[Mongo Dao ]queryPageCount:" + query);
        return this.mongoTemplate.count(query, this.getEntityClass());
    }
	public void delete(T t){
		logger.debug("[Mongo Dao ]delete:" + t);
        this.mongoTemplate.remove(t);
    }
	public void deleteById(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        if(null!=criteria){
            Query query = new Query(criteria);
            logger.debug("[Mongo Dao ]deleteById:" + query);
            if(null!=query && this.queryOne(query)!=null){
                this.delete(this.queryOne(query));
            }
        }
    }
	
}
