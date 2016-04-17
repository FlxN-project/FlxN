package com.flxn.message.impl.database;

import com.flxn.address.Address;
import com.flxn.dao.api.ProjectDao;
import com.flxn.dao.model.Project;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBase;
import com.flxn.message.api.MsgToDataBaseWithDefer;
import com.flxn.message.impl.projectservice.MsgToProjectServiceCreateResultImpl;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.logic.DeferredResponse;

/**
 * Created by Gadzzzz on 15.04.2016.
 */
public class MsgToDataBaseCreateProjectImpl extends MsgToDataBaseWithDefer {

	private Project project;
	private ProjectDao projectDao;

	public MsgToDataBaseCreateProjectImpl(Address to, Address from, Project project, ProjectDao projectDao, DeferredResponse deferredResponse) {
		super(to, from, deferredResponse);
		this.project = project;
		this.projectDao = projectDao;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		Msg back;
		try {
			projectDao.create(project);
			deferredResponse.setData(null, null);
			back = new MsgToProjectServiceCreateResultImpl(getFrom(), getTo(), deferredResponse);
		}catch (UnsupportedOperationException e){
			deferredResponse.setData(null,e);
			back = new MsgToProjectServiceCreateResultImpl(getFrom(),getTo(), deferredResponse);
		}
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
