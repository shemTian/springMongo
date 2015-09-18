package com.tsq.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.tsq.Exception.BaseException;
import com.tsq.model.Person;
import com.tsq.util.StringUtil;
@Repository
public class PersonDao extends MongoBaseDao<Person>{

	@Override
	Class<Person> getEntityClass() {
		return Person.class;
	}
	public void save(Person person){
		this.saveEntity(person);
	}
	public List<Person> queryPage(int startIndex,int pageSize){
		return getPage(startIndex, pageSize);
	}
	public void updatePerson(Person person){
		Update update = new Update();
        if(null==person.getId()||"".equals(person.getId().trim())){
            //如果主键为空,则不进行修改
            throw new BaseException("Update data Id is Null");
        }
        if(!StringUtil.isEmpty(person.getName())){
            update.set("name", person.getName());
        }
        update.set("age", person.getAge());
        
        if(person.getGender()!=null){
            update.set("gender", person.getGender());
        }
		updateFirst(Query.query(Criteria.where("_id").is(person.getId())), update);
	}
}
