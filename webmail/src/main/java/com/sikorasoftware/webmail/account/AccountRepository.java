package com.sikorasoftware.webmail.account;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertsikora on 04.01.2016.
 */
public interface AccountRepository extends CrudRepository<Account, ObjectId> {
}
