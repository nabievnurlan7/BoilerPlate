package librarian.kz.boilerplate.data.repositry.datasource;

import librarian.kz.boilerplate.data.entity.DataModel;
import java.util.List;
import io.reactivex.Observable;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface DataStore {
    Observable<List<DataModel>> townships();
}
