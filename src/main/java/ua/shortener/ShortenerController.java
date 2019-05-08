package ua.shortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ShortenerController {

    @Autowired
    private Shrotener shortener;

    @ResponseBody
    @PostMapping("/shorten")
    public String shortenURL(@RequestParam String url) {
        return shortener.shortenURL(url);
    }

    @PostMapping("/show")
    void prov(@RequestParam String url,
              HttpServletResponse response) throws IOException {
        String result = "https://" + shortener.getURL(url);
        response.sendRedirect(result);
    }

}


