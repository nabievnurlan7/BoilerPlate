package librarian.kz.boilerplate.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import librarian.kz.boilerplate.domain.model.DomainModel;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface Repository
{
    Observable<List<DomainModel>> townships();
}
