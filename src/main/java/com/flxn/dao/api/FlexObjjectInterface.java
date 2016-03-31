package com.flxn.dao.api;

import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Clazz;
import com.flxn.dao.model.FlexObjject;
import com.flxn.dao.model.Objject;

import java.util.List;

/**
 * Created by X8 on 31.03.2016.
 */
public interface FlexObjjectInterface {
   FlexObjject create (Objject objject);
   String getValueByAtribute(Atribute atribute);
   List<FlexObjject> getFlexObjjectListByClass(Clazz clazz);
}
