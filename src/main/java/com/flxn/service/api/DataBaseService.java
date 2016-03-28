package com.flxn.service.api;

import com.flxn.fake.database.FakeDB;

/**
 * Created by Gadzzzz on 28.03.2016.
 */
public interface DataBaseService extends Service {
	FakeDB getFakeDB();
}
