package librarian.kz.boilerplate.presentation.model.mapper;

import java.util.ArrayList;
import java.util.List;

import librarian.kz.boilerplate.domain.model.DomainModel;
import librarian.kz.boilerplate.presentation.model.PresentationModel;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class ModelMapper
{
    public ModelMapper() {}

    public PresentationModel transform(DomainModel domainModel)
    {
        PresentationModel presentationModel = null;
        if (domainModel !=null)
        {
           presentationModel = new PresentationModel(domainModel.getId(), domainModel.getName(), domainModel.getImageUrl());
        }

        return presentationModel;
    }

    public List<PresentationModel> transformList(List<DomainModel> domainModels)
    {
        List<PresentationModel> presentationModels = new ArrayList<>();

        for(DomainModel domainModel : domainModels)
        {
            if(domainModel !=null)
            {
                presentationModels.add(transform(domainModel));
            }
        }

        return presentationModels;
    }
}