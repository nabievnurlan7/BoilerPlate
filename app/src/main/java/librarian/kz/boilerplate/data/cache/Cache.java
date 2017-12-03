package librarian.kz.boilerplate.data.cache;

import java.util.List;
import io.reactivex.Observable;
import librarian.kz.boilerplate.data.entity.DataModel;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface Cache
{
    boolean isExpired();
    boolean isCached();
    Observable<List<DataModel>> get();
    void put(List<DataModel> townshipEntities);
}
