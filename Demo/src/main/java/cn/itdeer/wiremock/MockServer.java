package cn.itdeer.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * Description :
 * PackageName : cn.itdeer.wiremock
 * ProjectName : ItdeerSecurity
 * CreatorName : itdeer.cn
 * CreateTime : 2019/4/15/17:42
 */
public class MockServer {


    public static void main(String[] args) throws IOException {

        WireMock.configureFor(9999);
        WireMock.removeAllMappings();

        mock("/order/1","data/01.json");

        mock("/v2/movie/in_theaters_all","data/inTheaters_all.json");
        mock("/v2/movie/in_theaters_list","data/inTheaters_list.json");

        mock("/v2/movie/coming_soon_all","data/comingSoon_all.json");
        mock("/v2/movie/coming_soon_list","data/comingSoon_list.json");

        mock("/v2/movie/top250_all","data/top250_all.json");
        mock("/v2/movie/top250_list","data/top250_list.json");

    }

    public static void mock(String url,String name) throws IOException{
        ClassPathResource resource = new ClassPathResource(name);
//        String content = FileUtils.readFileToString(resource.getFile());
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(),"UTF-8"),"\n");
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url)).willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }

}
