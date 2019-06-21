package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    //Map<Long, TimeEntry> map;
    ConcurrentHashMap map = null;
    long timeId=0L;
    List<TimeEntry> l=null;

    public InMemoryTimeEntryRepository()
    {
        map=new ConcurrentHashMap();
    }

    public TimeEntry create(TimeEntry timeEntry) {
        timeId=timeId+1L;
        timeEntry.setId(timeId);
        map.put(timeId,timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        if(!map.containsKey(id))
        {
            return null;
        }
        TimeEntry timeEntry=(TimeEntry) map.get(id);
        return timeEntry;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(!map.containsKey(id))
        {
            return null;
        }
        else
        {timeEntry.setId(id);
            map.put(id,timeEntry);
            return timeEntry;
        }
    }

    public void delete(long id){
        map.remove(id);
    }

    public List<TimeEntry> list() {
        if(map.isEmpty())
        {
            return l;
        }
        else
        {
            l=new ArrayList<>();
            for(Object id:map.keySet())
            {
                l.add((TimeEntry)map.get(id));
            }
            return l;
        }
    }
}
