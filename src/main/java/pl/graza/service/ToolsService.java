package pl.graza.service;

import pl.graza.dao.ToolDao;
import pl.graza.dao.ToolDaoImpl;
import pl.graza.model.Tool;

import java.util.List;
import java.util.Optional;

public class ToolsService {

    private ToolDao toolDao = new ToolDaoImpl();

    public List<Tool> getTools(){
        return toolDao.getAllTools();
    }

    public Optional<Tool> getTool(Long id){
        return toolDao.getAllTools().stream().filter(tool -> tool.getId().equals(id)).findAny();
    }

    public List<Tool> takeTool(Long id){
        return setAvailability(id, false);
    }

    public List<Tool> returnTool(Long id){
        return setAvailability(id, true);
    }

    private List<Tool> setAvailability(Long id, boolean isAvailable){
        toolDao.setAvailability(id, isAvailable);

        return getTools();
    }
}
