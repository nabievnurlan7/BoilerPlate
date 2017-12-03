package librarian.kz.boilerplate.presentation.view.activity;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import librarian.kz.boilerplate.R;
import librarian.kz.boilerplate.data.cache.Cache;
import librarian.kz.boilerplate.data.cache.CacheImpl;
import librarian.kz.boilerplate.data.entity.mapper.Mapper;
import librarian.kz.boilerplate.data.repositry.DataRepository;
import librarian.kz.boilerplate.data.repositry.datasource.DataStoreFactory;
import librarian.kz.boilerplate.domain.interactor.GetTownshipList;
import librarian.kz.boilerplate.presentation.model.PresentationModel;
import librarian.kz.boilerplate.presentation.model.mapper.ModelMapper;
import librarian.kz.boilerplate.presentation.presenter.ListPresenter;
import librarian.kz.boilerplate.presentation.view.ListView;
import librarian.kz.boilerplate.presentation.view.adapter.Adapter;

public class ListActivity extends BaseActivity implements ListView
{
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.activity_township_list)
    RelativeLayout activityTownshipList;
    @BindView(R.id.error)
    TextView error;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private Adapter adapter;
    private ListPresenter listPresenter;
    private GetTownshipList getTownshipList;
    private ModelMapper modelMapper;
    private DataRepository townshipDataRepository;
    private Mapper mapper;
    private DataStoreFactory dataStoreFactory;
    private Cache cache;

    public ListActivity() {}

    @Override
    public void renderTownshipList(List<PresentationModel> townshipModels)
    {
        adapter.setTownships(townshipModels);
    }

    @Override
    public void showLoading()
    {
        recycler.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading()
    {
        recycler.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage)
    {
        recycler.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
        error.setText(errorMessage);
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public int getContentLayout()
    {
        return R.layout.activity_township_list;
    }

    @Override
    public void initComponents()
    {
        adapter = new Adapter();
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        recycler.setAdapter(adapter);

        modelMapper = new ModelMapper();
        mapper = new Mapper();
        cache = new CacheImpl();
        dataStoreFactory = new DataStoreFactory(cache);
        townshipDataRepository = new DataRepository(dataStoreFactory, mapper);
        getTownshipList = new GetTownshipList(townshipDataRepository);

        listPresenter = new ListPresenter(getTownshipList, modelMapper);
        listPresenter.setListView(this);
        listPresenter.initialize();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        listPresenter.resume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        listPresenter.pause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        listPresenter.destroy();
    }
}