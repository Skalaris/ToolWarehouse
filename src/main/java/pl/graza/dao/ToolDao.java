package pl.graza.dao;

import pl.graza.model.Tool;

import java.util.List;

public interface ToolDao {
    List<Tool> getAllTools();
    void setAvailability(Long id, boolean availability);
}

//data acces object
