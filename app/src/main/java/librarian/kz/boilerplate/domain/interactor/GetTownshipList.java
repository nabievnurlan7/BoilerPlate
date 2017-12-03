package librarian.kz.boilerplate.domain.interactor;

import java.util.List;
import io.reactivex.Observable;
import librarian.kz.boilerplate.domain.model.DomainModel;
import librarian.kz.boilerplate.domain.repository.Repository;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class GetTownshipList extends UseCase<List<DomainModel>,Void>
{
    private final Repository repository;

    public GetTownshipList(Repository repository)
    {
        this.repository = repository;
    }

    @Override
    Observable<List<DomainModel>> buildUseCaseObservable(Void unused)
    {
        return repository.townships();
    }
}