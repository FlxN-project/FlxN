package com.flxn.message.impl.database;

import com.flxn.address.Address;
import com.flxn.dao.api.ProjectDao;
import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;
import com.flxn.message.api.Msg;
import com.flxn.message.api.MsgToDataBaseWithDefer;
import com.flxn.message.impl.projectservice.MsgToProjectServiceGetAllResultImpl;
import com.flxn.service.impl.DataBaseServiceImpl;
import com.flxn.service.logic.DeferredResponse;

import java.util.List;

/**
 * Created by Gadzzzz on 17.04.2016.
 */
public class MsgToDataBaseGetAllProjectsImpl extends MsgToDataBaseWithDefer {

	private User user;
	private ProjectDao projectDao;
	private int userid;

	public MsgToDataBaseGetAllProjectsImpl(Address to,
														Address from,
														DeferredResponse deferredResponse,
														User user,
														ProjectDao projectDao,
														int userid) {
		super(to, from, deferredResponse);
		this.user = user;
		this.projectDao = projectDao;
		this.userid = userid;
	}

	@Override
	public void exec(DataBaseServiceImpl dataBaseService) {
		List<Project> projects = projectDao.getProjectListByUser(user,userid);
		if(projects == null)
			deferredResponse.setData(null, new UnsupportedOperationException());
		else
			deferredResponse.setData(projects, null);
		Msg back = new MsgToProjectServiceGetAllResultImpl(getFrom(), getTo(), deferredResponse);
		dataBaseService.getMessageSystem().sendMessage(back);
	}
}
