package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody TimeEntry timeEntry) {
        TimeEntry timeEntry1=timeEntryRepository.create(timeEntry);
        return new ResponseEntity<>(timeEntry1,HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry=timeEntryRepository.find(id);
        if(timeEntry==null)
        {
            return new ResponseEntity<>(timeEntry,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(timeEntry,HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntries= timeEntryRepository.list();
        return new ResponseEntity<>(timeEntries, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody TimeEntry timeEntry) {
        TimeEntry timeEntry1=timeEntryRepository.update(id,timeEntry);
        if(timeEntry1==null)
        {
            return new ResponseEntity<>(timeEntry1,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(timeEntry1,HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
