package librarian.kz.boilerplate.presentation.view;

import java.util.List;

import librarian.kz.boilerplate.presentation.model.PresentationModel;

/**
 * Created by Nurlan. Email: nabievnurlan7@gmail.com on 19.11.2017.
 */

public interface ListView extends LoadDataView {
    void renderTownshipList(List<PresentationModel> presentationModels);
}
