package librarian.kz.boilerplate.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import librarian.kz.boilerplate.data.entity.DataModel;
import librarian.kz.boilerplate.domain.model.DomainModel;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class Mapper
{
    public Mapper() {}

    public DomainModel transform(DataModel dataModel)
    {
        DomainModel domainModel = null;
        if(dataModel != null)
        {
            domainModel = new DomainModel(dataModel.getId(), dataModel.getName(), dataModel.getImageUrl(), dataModel.getImageUrl());
        }
        return domainModel;
    }

    public List<DomainModel> transformList(List<DataModel> townshipEntities)
    {
        List<DomainModel> domainModels = new ArrayList<>();
        for(DataModel dataModel : townshipEntities)
        {
            if(dataModel !=null)
            {
                domainModels.add(transform(dataModel));
            }
        }
        return domainModels;
    }
}