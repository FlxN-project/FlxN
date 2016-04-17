package com.flxn.message.impl.database;

import com.flxn.address.Address;
import com.flxn.dao.api.ProjectDao;
import com.flxn.dao.model.Project;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBaseWithDefer;
import com.flxn.message.impl.projectservice.MsgToProjectServiceGetResultImpl;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 17.04.2016.
 */
public class MsgToDataBaseGetProjectImpl extends MsgToDataBaseWithDefer {
	private int id;
	private ProjectDao projectDao;

	public MsgToDataBaseGetProjectImpl(Address to, Address from, DeferredResponse deferredResponse, int id, ProjectDao projectDao) {
		super(to, from, deferredResponse);
		this.id = id;
		this.projectDao = projectDao;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		Project project = projectDao.getById(id);
		if(project == null)
			deferredResponse.setData(null, new UnsupportedOperationException());
		else
			deferredResponse.setData(project, null);
		Msg back = new MsgToProjectServiceGetResultImpl(getFrom(), getTo(), deferredResponse);
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
