package br.com.devjony.sample.service;

import br.com.devjony.sample.domain.SampleDomain;
import br.com.devjony.sample.repository.SampleRepository;
import javassist.tools.rmi.ObjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleService {

    Logger logger = LoggerFactory.getLogger(SampleService.class);

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }
    
    public SampleDomain find(Integer id) throws ObjectNotFoundException {
    	
    	Optional<SampleDomain> sampleDomain = sampleRepository.findById(id);
    	
    	return sampleDomain.orElseThrow(() -> new ObjectNotFoundException(
    			"not found, id: " + id + "Tipe: " + SampleDomain.class.getName()));
    }

    public List<SampleDomain> findAll() {
        logger.info("Finding all [SampleDomain] on Database");

        List<SampleDomain> allSampleDomain = this.sampleRepository.findAll();

        logger.info("Returning [SampleDomain] List");
        return allSampleDomain;
    }

    public SampleDomain save(SampleDomain sampleDomain) {
        logger.info("Saving [SampleDomain] on Database");

        SampleDomain sampleDomainFromDb = this.sampleRepository.save(sampleDomain);

        logger.info("Returning [SampleDomain] saved on Database");
        return sampleDomainFromDb;
    }
    
    public SampleDomain update(SampleDomain sampleDomain) throws ObjectNotFoundException {
    	logger.info("Updating [SampleDomain] attributes");
    	
    	SampleDomain oldSampleDomain = find(sampleDomain.getId());
    	oldSampleDomain.setAttributeName(sampleDomain.getAttributeName());
    	
    	return save(oldSampleDomain);
    }
    
    public void delete(Integer id) {
    	logger.info("Deleting [SampleDomain], id: " + id);
    	sampleRepository.deleteById(id);
    }
}
