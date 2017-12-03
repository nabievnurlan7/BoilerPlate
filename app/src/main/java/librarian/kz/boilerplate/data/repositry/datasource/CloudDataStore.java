package librarian.kz.boilerplate.data.repositry.datasource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import librarian.kz.boilerplate.data.cache.Cache;
import librarian.kz.boilerplate.data.entity.DataModel;
import librarian.kz.boilerplate.data.net.ServiceGenerator;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class CloudDataStore implements DataStore
{
    private final Cache cache;

    CloudDataStore(Cache cache)
    {
        this.cache = cache;
    }

    @Override
    public Observable<List<DataModel>> townships()
    {
        return ServiceGenerator.getService().getTownships().doOnNext(new Consumer<List<DataModel>>()
        {
            @Override
            public void accept(final List<DataModel> townshipEntities) throws Exception
            {
                cache.put(townshipEntities);
            }
        });
    }
}
