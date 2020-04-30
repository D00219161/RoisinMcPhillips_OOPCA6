package Daos;

import DTOs.TollEvent;
import Exceptions.DaoException;
import java.util.List;

public interface TollEventDaoInterface
{
    public List<TollEvent> findAllTollEvents() throws DaoException;
    public TollEvent findTollEventByRegistration(String reg) throws DaoException;
    public TollEvent findAllTollEventByCertainDate(long Timestamp) throws DaoException;
    //public List<TollEvent> findAllTollEventBetweenStartAndEndDate(long Timestamp) throws DaoException;
    public void insertTollEvent(String registration, long imageId, long timestamp) throws DaoException;
    public void updateTollEvent(String registration, long timestamp) throws DaoException;
}
