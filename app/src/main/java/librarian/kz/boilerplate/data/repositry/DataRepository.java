package librarian.kz.boilerplate.data.repositry;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import librarian.kz.boilerplate.data.entity.DataModel;
import librarian.kz.boilerplate.data.entity.mapper.Mapper;
import librarian.kz.boilerplate.data.repositry.datasource.DataStoreFactory;
import librarian.kz.boilerplate.domain.model.DomainModel;
import librarian.kz.boilerplate.domain.repository.Repository;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class DataRepository implements Repository
{
    private final DataStoreFactory dataStoreFactory;
    private final Mapper mapper;

    public DataRepository(DataStoreFactory dataStoreFactory, Mapper mapper)
    {
        this.dataStoreFactory = dataStoreFactory;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<DomainModel>> townships()
    {
        return dataStoreFactory.create().townships().map(new Function<List<DataModel>, List<DomainModel>>()
        {
            @Override
            public List<DomainModel> apply(List<DataModel> townshipEntities) throws Exception
            {
                return mapper.transformList(townshipEntities);
            }
        });
    }
}