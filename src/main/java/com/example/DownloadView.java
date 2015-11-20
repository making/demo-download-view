package com.example;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class DownloadView extends AbstractView {
    @Value("${filepath:classpath:/hello.txt}")
    Resource file;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map,
            HttpServletRequest req, HttpServletResponse res) throws Exception {
        String fileName = (String) map.get("fileName");
        res.setHeader("Content-Disposition", "attachment; filename=" + fileName
                + ".txt");
        res.setContentType("text/plain");
        FileCopyUtils.copy(file.getInputStream(), res.getOutputStream());
    }
}
