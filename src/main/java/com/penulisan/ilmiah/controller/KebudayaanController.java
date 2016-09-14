package com.penulisan.ilmiah.controller;

import com.penulisan.ilmiah.domain.Kebudayaan;
import com.penulisan.ilmiah.service.KebudayaanService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Irman Juliansyah
 */
@RestController
@RequestMapping(value = "/api")
public class KebudayaanController {

    @Autowired
    private KebudayaanService kebudayaanService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/kebudayaan", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> saveKebudayaan(@RequestBody Kebudayaan kebudayaan) {

        kebudayaanService.save(kebudayaan);

        Map<String, Object> dataObject = new HashMap<>();
        dataObject.put("Success", Boolean.TRUE);
        dataObject.put("Info", "Data Tersimpan");

        return dataObject;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kebudayaan", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateKebudayaan(@RequestBody Kebudayaan kebudayaan) {
        kebudayaanService.update(kebudayaan);

        Map<String, Object> dataObject = new HashMap<>();
        dataObject.put("Success", Boolean.TRUE);
        dataObject.put("Info", "Data Berhasil di update");

        return dataObject;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kebudayaan/{idKebudayaan}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteKebudayaan(@PathVariable("idKebudayaan") String idKebudayaan) {

        kebudayaanService.delete(kebudayaanService.getKebudayaan(idKebudayaan));

        Map<String, Object> dataObject = new HashMap<>();
        dataObject.put("Success", Boolean.TRUE);
        dataObject.put("Info", "Data Berhasil di hapus");

        return dataObject;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kebudayaan", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Kebudayaan> getKebudayaans() {
        return kebudayaanService.getKebudayaans();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kebudayaan/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Kebudayaan getKebudayaan(@PathVariable("id") String id) {
        return kebudayaanService.getKebudayaan(id);
    }

}
