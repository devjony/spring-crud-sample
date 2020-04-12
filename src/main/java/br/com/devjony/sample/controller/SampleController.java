package br.com.devjony.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.devjony.sample.domain.SampleDomain;
import br.com.devjony.sample.service.SampleService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/sample")
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    @GetMapping
    public ModelAndView listAll(){
        logger.info("Request received on [GET][/sample]");

        ModelAndView mv = new ModelAndView("/sample/sample-list");
        mv.addObject("sampleDomainList", sampleService.findAll());

        logger.info("Returning view to the client");
        return mv;
    }
    
    @GetMapping("/create")
    public ModelAndView createSample() {
    	logger.info("Request received on [GET][/sample/create]");
    	
    	ModelAndView mv = new ModelAndView("sample/sample-create");
    	mv.addObject("sampleDomain", new SampleDomain());
    	
    	logger.info("Returning view to the client");
    	return mv;
    }
    
    @PostMapping("/save")
    public String save(SampleDomain sampleDomain) {
    	logger.info("Request received on [GET][/sample/save]");
    	
    	sampleService.save(sampleDomain);
    	
    	logger.info("Returning view to the client");
    	return "redirect:/sample";
    }
    
    @GetMapping("/update/{id}")
    public ModelAndView updateSample(@PathVariable("id") Integer id) throws ObjectNotFoundException {
    	logger.info("Request received on [GET][/sample/update/" + id + "]" );
    	
    	ModelAndView mv = new ModelAndView("/sample/sample-update");
    	mv.addObject("sampleDomain", sampleService.find(id));
    	
    	logger.info("Returning view to the client");
    	return mv;
    }
    
    @PostMapping("/update")
    public String update(SampleDomain sampĺeDomain) throws ObjectNotFoundException {
    	logger.info("Request received on [POST][/sample/update]");
    	sampleService.update(sampĺeDomain);
    	
    	return "redirect:/sample";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
    	logger.info("Request received on [GET][/sample/delete/{id}]");
    	
    	sampleService.delete(id);
    	
    	logger.info("Returning view to the client");
    	return "redirect:/sample";
    }
}
