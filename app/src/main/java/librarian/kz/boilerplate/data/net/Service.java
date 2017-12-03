package librarian.kz.boilerplate.data.net;

import java.util.List;

import io.reactivex.Observable;
import librarian.kz.boilerplate.data.entity.DataModel;
import retrofit2.http.GET;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface Service
{
    @GET("bins/yy0wl")
    Observable<List<DataModel>> getTownships();
}
