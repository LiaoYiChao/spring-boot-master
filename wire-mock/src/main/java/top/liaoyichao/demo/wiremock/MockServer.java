package top.liaoyichao.demo.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @Author: LiaoYiChao
 * @Date: 2019/4/22 16:42
 * @Description:
 */
public class MockServer {

    public static void main(String[] args) throws IOException {

        WireMock.configureFor(8060);
        WireMock.removeAllMappings();

        ClassPathResource resource = new ClassPathResource("/mock/1.json");

        String strings = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(),"\n");

        System.out.println(strings);

        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/user/1")).willReturn(WireMock.aResponse().withBody(strings).withStatus(200)));

    }

}
