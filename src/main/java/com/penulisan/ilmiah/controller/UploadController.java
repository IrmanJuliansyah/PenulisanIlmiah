package com.penulisan.ilmiah.controller;

import com.penulisan.ilmiah.domain.Kebudayaan;
import com.penulisan.ilmiah.service.KebudayaanService;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author IrmanJuliansyah
 */
@Controller
@RequestMapping("admin")
public class UploadController {

    @Autowired
    private KebudayaanService kebudayaanService;
    
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Model model) {
        model.addAttribute("kebudayaan", new Kebudayaan());
        return "admin/TambahKebudayaan";
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String saveFile(@ModelAttribute("kebudayaan") Kebudayaan kebudayaan, @RequestParam MultipartFile fileUpload, Model model, HttpServletRequest request) throws IOException {

        if (fileUpload != null) {
            fileUpload.transferTo(new File(request.getSession().getServletContext().getRealPath("/") + "/upload/" +fileUpload.getOriginalFilename()));
            kebudayaan.setGambar(fileUpload.getOriginalFilename());
            kebudayaanService.save(kebudayaan);
        }
        return "redirect:/admin/#/kebudayaan";
    }

}
