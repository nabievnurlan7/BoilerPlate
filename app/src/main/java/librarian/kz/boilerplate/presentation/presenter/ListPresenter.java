package librarian.kz.boilerplate.presentation.presenter;

import librarian.kz.boilerplate.domain.interactor.DefaultObserver;
import librarian.kz.boilerplate.domain.interactor.GetTownshipList;
import librarian.kz.boilerplate.domain.model.DomainModel;
import librarian.kz.boilerplate.presentation.model.PresentationModel;
import librarian.kz.boilerplate.presentation.model.mapper.ModelMapper;
import librarian.kz.boilerplate.presentation.view.ListView;

import java.util.List;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public class ListPresenter implements Presenter
{
    private ListView listView;
    private final GetTownshipList getTownshipList;
    private final ModelMapper modelMapper;

    public ListPresenter(GetTownshipList getTownshipList, ModelMapper modelMapper)
    {
        this.getTownshipList = getTownshipList;
        this.modelMapper = modelMapper;
    }

    public void setListView(ListView listView)
    {
        this.listView = listView;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy()
    {
        this.getTownshipList.dispose();
        this.listView = null;
    }

    public void initialize()
    {
        this.loadTownshipList();
    }

    private void loadTownshipList()
    {
        this.showViewLoading();
        this.getTownshipList();
    }

    private void showViewLoading()
    {
        this.listView.showLoading();
    }

    private void hideViewLoading()
    {
        this.listView.hideLoading();
    }

    private void showErrorMessage(String errorMessage)
    {
        this.listView.showError(errorMessage);
    }

    private void showTownshipListInView(List<DomainModel> domainModels)
    {
        final List<PresentationModel> presentationModelList =
                this.modelMapper.transformList(domainModels);
        this.listView.renderTownshipList(presentationModelList);
    }

    private void getTownshipList()
    {
        this.getTownshipList.execute(new TownshipListObserver(), null);
    }

    private final class TownshipListObserver extends DefaultObserver<List<DomainModel>>
    {
        @Override
        public void onComplete()
        {
            ListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e)
        {
            e.printStackTrace();
            ListPresenter.this.hideViewLoading();
            ListPresenter.this.showErrorMessage(e.getLocalizedMessage());
        }

        @Override
        public void onNext(List<DomainModel> domainModels)
        {
            ListPresenter.this.showTownshipListInView(domainModels);
        }
    }
}