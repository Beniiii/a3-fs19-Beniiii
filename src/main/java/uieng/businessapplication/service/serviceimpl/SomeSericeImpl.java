package uieng.businessapplication.service.serviceimpl;

import uieng.businessapplication.service.SomeDTO;
import uieng.businessapplication.service.SomeService;

public class SomeSericeImpl implements SomeService {

    @Override
    public SomeDTO get(long id) {
        return new SomeDTO(String.valueOf(id), "dto-" + id);
    }
}
