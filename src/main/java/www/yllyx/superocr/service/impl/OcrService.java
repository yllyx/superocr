package www.yllyx.superocr.service.impl;

import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yllyx.superocr.common.domain.FileMeta;
import www.yllyx.superocr.common.util.ResponseEntityUtil;
import www.yllyx.superocr.logic.IOcrLogic;
import www.yllyx.superocr.service.IOcrService;

@Service
@Path("OcrService")
public class OcrService implements IOcrService
{

    @Autowired
    private IOcrLogic ocrLogic;

    @Override
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("upload")
    public ResponseEntityUtil uploadOrcImg(LinkedList<FileMeta> imgFile)
    {
        return ocrLogic.uploadImg(imgFile);
    }

    @Override
    public void ocrImg(LinkedList<FileMeta> files)
    {
        ocrLogic.doOcr(files);
    }

}
