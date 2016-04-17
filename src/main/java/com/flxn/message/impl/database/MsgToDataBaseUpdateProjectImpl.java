package com.flxn.message.impl.database;

import com.flxn.address.Address;
import com.flxn.dao.api.ProjectDao;
import com.flxn.dao.model.Project;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBaseWithDefer;
import com.flxn.message.impl.projectservice.MsgToProjectServiceUpdateResultImpl;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 17.04.2016.
 */
public class MsgToDataBaseUpdateProjectImpl extends MsgToDataBaseWithDefer {

	private Project project;
	private ProjectDao projectDao;

	public MsgToDataBaseUpdateProjectImpl(Address to, Address from, DeferredResponse deferredResponse, Project project, ProjectDao projectDao) {
		super(to, from, deferredResponse);
		this.project = project;
		this.projectDao = projectDao;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		Msg back;
		try {
			projectDao.update(project);
			deferredResponse.setData(null, null);
			back = new MsgToProjectServiceUpdateResultImpl(getFrom(), getTo(), deferredResponse);
		}catch (UnsupportedOperationException e){
			deferredResponse.setData(null,e);
			back = new MsgToProjectServiceUpdateResultImpl(getFrom(),getTo(), deferredResponse);
		}
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
