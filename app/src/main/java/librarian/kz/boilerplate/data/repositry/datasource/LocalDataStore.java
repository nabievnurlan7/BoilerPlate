package librarian.kz.boilerplate.data.repositry.datasource;

import java.util.List;

import io.reactivex.Observable;
import librarian.kz.boilerplate.data.cache.Cache;
import librarian.kz.boilerplate.data.entity.DataModel;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class LocalDataStore implements DataStore
{
    private final Cache cache;

    LocalDataStore(Cache cache)
    {
        this.cache = cache;
    }

    //Return a list of townships from DB
    @Override
    public Observable<List<DataModel>> townships() {
        return cache.get();
    }
}
